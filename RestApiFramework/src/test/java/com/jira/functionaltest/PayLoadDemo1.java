package com.jira.functionaltest;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import io.restassured.RestAssured;

public class PayLoadDemo1 {
	public static String createSessionPayload="{  \r\n" + 
			"		    \"username\":\"sushildoiphode\",  \r\n" + 
			"		    \"password\": \"9881549281\"  \r\n" + 
			"		}\r\n";

	public static String createTicketPayload = "{\r\n" + 
			"    \"fields\": {\r\n" + 
			"       \"project\":\r\n" + 
			"       {\r\n" + 
			"          \"key\": \"JIR\"\r\n" + 
			"       },\r\n" + 
			"       \"summary\": \"Creating a new story for false ceiling 1\",\r\n" + 
			"       \"description\": \"Living room false ceiling\",\r\n" + 
			"       \"issuetype\": {\r\n" + 
			"          \"name\": \"Story\"\r\n" + 
			"       }\r\n" + 
			"   }\r\n" + 
			"}";
	
	public static void restAssuredUrl() {
		RestAssured.baseURI="http://localhost:8080/";
	}
	
	public static String addCommentPayload() {
		return "{\r\n" + 
				"    \"body\": \"This is a comment regarding the quality of the response. From Raghvendra\"\r\n" + 
				"}";
	}

}
