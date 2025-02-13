package MyBasicPraCTICE;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class dataproviderj {

	@DataProvider(name="BookdData")
	
	public Object [][] getBooksData()
	{
		return new Object[][]
				{
			{"abcgh",3456},
			{"esdhgy",9456},
			{"ygcf",8456}
			
				};
	}
	
	
	@Test(dataProvider="BookdData")
	public void addBook(String ISBN, int aisle)
	{
		RestAssured.baseURI="https://216.10.245.166";
		
		String response = given().log().all().header("Content-Type","application/json").
				body(pay)
		when().post("api/users").then().log().all().assertThat().statusCode(201).body("createdAt",equalTo("2024-12-14T11:53:48.724Z"))
		.extract().response().asString();
	}
}
