package Reusingofrequestandresponse;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.payload1;

public class requestspefication1 {

	public static void main(String[] args) {
		
		
		RequestSpecification res = given().log().all()
				.spec(reuseingrequestresponsespecbuilder.request()).body(payload1.Addemployee("KOM", "QA Manager"));
		
		
		
		
		Response respons= res.when().post("api/users").then().log().all().spec(reuseingrequestresponsespecbuilder.responseVai())
		.extract().response();
		
		String respon=respons.asString();
		
		Long Time=respons.getTime();
		
		
		System.out.println(Time);

	}

}
