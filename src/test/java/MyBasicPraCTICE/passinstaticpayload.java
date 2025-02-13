package MyBasicPraCTICE;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import payload.payload1;

public class passinstaticpayload {
	
	
	public static void main(String[] args) throws IOException
	{
String expected_date="2024-12-14";
		
		RestAssured.baseURI="https://reqres.in";
		
		String response = given().log().all().header("Content-Type","application/json").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\tavis\\Downloads\\paylaod.txt")))).
				when().post("api/users").then().log().all().assertThat().statusCode(201).body("createdAt",equalTo("2024-12-14T11:53:48.724Z"))
				.extract().response().asString();
		
		
		System.out.print(response);
		
		JsonPath js = new JsonPath(response);
		String actual_date =js.getString("createdAt");
		
		String a[]=actual_date.split("T");
		
		String actual_calender_day=a[0];
		
		System.out.println(a[0]);
		
		Assert.assertEquals(actual_calender_day,expected_date);
	}

}
