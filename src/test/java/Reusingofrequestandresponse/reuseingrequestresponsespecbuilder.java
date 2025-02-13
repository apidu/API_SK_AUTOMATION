package Reusingofrequestandresponse;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class reuseingrequestresponsespecbuilder {

	public static RequestSpecification request()
	
	{
		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("https://reqres.in/")
				.setContentType(ContentType.JSON)
				//.setSessionId(sessionId)
				.build();
		
		return req;
		
	}
	
	public static ResponseSpecification responseVai()
	{
		ResponseSpecification resp= new ResponseSpecBuilder()
				.expectStatusCode(201)
				.expectContentType(ContentType.JSON)
				.build();
		
		return resp;
	}
	
	}


