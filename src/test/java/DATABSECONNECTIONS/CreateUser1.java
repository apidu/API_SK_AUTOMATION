package DATABSECONNECTIONS;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateUser1 {
	
	public static void main(String[] args) throws SQLException
	{
		LinkedHashMap<String,Object>mp=new LinkedHashMap<String, Object>();
		
		mp.put("personId",DBINTERGATE1.DbConectionresuse1(1));
		mp.put("lastName",DBINTERGATE1.DbConectionresuse1(2));
		mp.put("firstName",DBINTERGATE1.DbConectionresuse1(3));
		mp.put("city",DBINTERGATE1.DbConectionresuse1(4));
	
	
		RestAssured.baseURI="https://reqres.in";
		
		String response = given().log().all().body(mp).header("Content-Type","application/json")
		.when().post("api/user").then().assertThat().statusCode(201).extract().response().asString();
		
		System.out.println(response);
		
		
		
	}

}
