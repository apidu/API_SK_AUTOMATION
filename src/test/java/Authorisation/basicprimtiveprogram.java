package Authorisation;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class basicprimtiveprogram {
	
	public static void main(String[] args)
	{
RestAssured.baseURI="https://postman-echo.com";
		
		given().log().all().auth().preemptive().basic("postman","password")
		.when().get("basic-auth")
		.then().log().all().statusCode(200)
		.extract().response().asString();
	}

}
