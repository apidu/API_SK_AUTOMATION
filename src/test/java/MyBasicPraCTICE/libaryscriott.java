package MyBasicPraCTICE;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class libaryscriott {
	
	public static void main(String[] args)
	{
		RestAssured.baseURI="https://216.10.245.166";
		
		String response = given().log().all().headers("Content-Type","application/json")
				.body(null)
				.when().post("Library/Addbook.php").then().log.all().
				asserThat().statusCode(200)
				.extract().response().asString();
	}
	
	

}
