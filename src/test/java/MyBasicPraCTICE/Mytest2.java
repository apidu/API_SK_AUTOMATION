package MyBasicPraCTICE;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Mytest2 {
	
	public static void main(String[] args)
	{
		RestAssured.baseURI="https://reqres.in";
		
		String response= given().log().all().queryParam("page",2).
		when().get("/api/user").then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.print(response);
	}

}
