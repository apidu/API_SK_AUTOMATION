package Authorisation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import  static io.restassured.RestAssured.*;

import org.testng.Assert;

public class Apikeyspract {
	
	public static void main(String[] args)
	{
		RestAssured.baseURI="http://api.openweathermap.org";
		String resposne=given().log().all().queryParam("q","Kolkata").queryParam("appid","52a486a06b567d461c73d1b9f1e460eb").
		when().get("data/2.5/weather").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.print(resposne);
		
		JsonPath js = new JsonPath(resposne);
		int humidity =js.getInt("main.humidity");
		
		Assert.assertEquals(77, humidity);
	}

}
