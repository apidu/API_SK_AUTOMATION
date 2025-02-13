package usespecificbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.payload1;

import static io.restassured.RestAssured.*;

public class requestspecification2 {

	public static void main(String[] args) {
		///for get method.
		/*RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("http://reqres.in")
				//.setSessionId(sessionId)
				.build();
		
		RequestSpecification res = given().log().all().spec(req);
		
		ResponseSpecification respospec = new ResponseSpecBuilder()
				.expectStatusCode(200).build();
		
		
		String response = res.when().get("api/users?page=2").then().log().all().spec(respospec)
		.extract().response().asString();
		
		System.out.println(response);*/
		
		//for post method...
		
		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("https://reqres.in/")
				.setContentType(ContentType.JSON)
				//.setSessionId(sessionId)
				.build();
		
		
		RequestSpecification res = given().log().all()
				.spec(req).body(payload1.Addemployee("KOM", "QA Manager"));
		
		
		ResponseSpecification resp= new ResponseSpecBuilder()
				.expectStatusCode(201)
				.expectContentType(ContentType.JSON)
				.build();
		
		Response respons= res.when().post("api/users").then().log().all().spec(resp)
		.extract().response();
		
		String respon=respons.asString();
		
		Long Time=respons.getTime();
		
		
		System.out.println(Time);
		
		}

}
