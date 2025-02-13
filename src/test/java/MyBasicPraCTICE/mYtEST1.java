package MyBasicPraCTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class mYtEST1 {
	
	@Test
	public void method1()
	{
		String expected_firstname="Janeat";
		RestAssured.baseURI="https://reqres.in";
		 
		String Response= given().log().all().header("Connection","keep-alive"). 
				when().get("/api/users/2").then().log().all().assertThat().statusCode(200).
				header("Server", "cloudflare").extract().response().asString();
		
		
		System.out.print("This Is respose body  "+Response);
		
		JsonPath js = new JsonPath(Response);
		String actual_name=js.getString("data.first_name");
		
		Assert.assertEquals(expected_firstname, actual_name);
		
	}

}
