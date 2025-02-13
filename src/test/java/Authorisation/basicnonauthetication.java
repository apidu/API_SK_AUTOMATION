package Authorisation;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class basicnonauthetication {
	
	
	public static void main(String[] args)
	{
		RestAssured.baseURI="https://postman-echo.com";
		
		given().log().all().auth().basic("postman","password")
		.when().get("basic-auth")
		.then().log().all().statusCode(200)
		.extract().response().asString();
	}

}
