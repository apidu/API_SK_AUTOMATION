package Authorisation;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;

public class digestauthentication {
	
	public static void main(String[] args)
	{
		RestAssured.baseURI="https://postman-echo.com";
		
		given().log().all().auth().digest("postman","password")
		.when().get("digest-auth")
		.then().log().all().statusCode(200)
		.extract().response().asString();
	}

}
