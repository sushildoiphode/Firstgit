package com.jira.functionaltest;

public class TestBaseUrl {
	public static final String SESSION_URL = "rest/auth/1/session";

	public static final String CREATE_TICKET = "rest/api/2/issue";

	public static final String UPLAOD_FILE = "rest/api/2/issue/"+RestProjectJira.createTicket()+"/attachments";

	public static final String UPLAOD_FILE1 = "rest/api/2/issue/JIR-32/attachments";
	
	public static final String ADD_COMMENT = "rest/api/2/issue/"+RestProjectJira.createTicket()+"/comment";
		
	public static final String ADD_COMMENT1 = "rest/api/2/issue/JIR-39/comment";
}
