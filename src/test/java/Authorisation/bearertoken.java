package Authorisation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import payload.payload1;

public class bearertoken {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://gorest.co.in";

		String bearertoken = "Bearer 25735f9dcef24e367737562934c4151c3a33276cf8534885acd641cf1abce0c0";

		Response response = given().log().all().body(payload1.gorestnewuser())
				.headers("Content-Type", "application/json").headers("Authorization", bearertoken).when()
				.post("public/v2/users").then().log().all().extract().response();

		int statuscode = response.getStatusCode();

		Assert.assertEquals(statuscode, 201);
		System.out.println("Testcase is passed");

	}

}
