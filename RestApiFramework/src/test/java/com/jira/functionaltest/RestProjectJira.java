package com.jira.functionaltest;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;

public class RestProjectJira {

		@Test(priority = 1)
		public static SessionFilter creatSession() {
		SessionFilter filter=new SessionFilter();
		PayLoadDemo1.restAssuredUrl();
		given()
		.contentType(ContentType.JSON)
		.body(PayLoadDemo1.createSessionPayload)
		.log().all()
		.filter(filter)
		.when()
		.post(TestBaseUrl.SESSION_URL)
		.then()
		.assertThat()
		.body("session.value", Matchers.notNullValue())
		.log().all();
		System.out.println("end session");
		return filter;
	}
		/**
		 * This Method Create new Ticket 
		 * @return ID of that Ticket
		 */
		//@Test(priority = 2)
		public static String createTicket() {
			PayLoadDemo1.restAssuredUrl();
			String responceString= given()
			.contentType(ContentType.JSON)
			.body(PayLoadDemo1.createTicketPayload)
			.log().all()
			.filter(RestProjectJira.creatSession())
			.when()
			.post(TestBaseUrl.CREATE_TICKET)
			.then()
			.assertThat()
			.statusCode(201)
			.log().all()
			.extract().asString();
			System.out.println("Responce Extract from server "+responceString);
			JsonPath js=new JsonPath(responceString);
			String id1=js.getString("id");
			System.out.println(id1);
			return id1;
		}
		/**
		 * This Method create new Ticket only.
		 */
		@Test(priority = 3)
		public void onlyCreatTicket() {
			PayLoadDemo1.restAssuredUrl();
			given()
			.contentType(ContentType.JSON)
			.body(PayLoadDemo1.createTicketPayload)
			.log().all()
			.filter(RestProjectJira.creatSession())
			.when()
			.post(TestBaseUrl.CREATE_TICKET)
			.then()
			.assertThat()
			.statusCode(201)
			.log().all();	
		}
	//	@Test(priority = 4)
		public void uploadFile() {
			given()  
			.header("X-Atlassian-Token","nocheck")
			.header("Content-Type","multipart/form-data") 
			.filter(RestProjectJira.creatSession())  
			.multiPart("file",new File("C:\\Users\\Dell\\Desktop\\TS.docx"))  
			.when()
			.post(TestBaseUrl.UPLAOD_FILE)  
			.then()
			.log().all()
			.assertThat()
			.statusCode(200);
		}
	//	@Test(priority = 5)
		public void addComment() {
			//System.out.println(RestProjectJira.creatSession());
			given()
			//.header("Cookie",RestProjectJira.creatSession())
			.contentType(ContentType.JSON)
			.body(PayLoadDemo1.addCommentPayload())
			.filter(RestProjectJira.creatSession()) 
			.log().all()
			.when()
			.post(TestBaseUrl.ADD_COMMENT)
			.then()
			.log().all()
			.assertThat()
			.statusCode(201);
		
		}
}
