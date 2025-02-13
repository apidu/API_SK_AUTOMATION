package MyBasicPraCTICE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class createemployeepojo3 {
	
	public static void main(String[] args) throws JsonProcessingException
	{
		RestAssured.baseURI="https://reqres.in";
		
		pojoemployeeclass emp = new pojoemployeeclass();
		
		emp.setName("Tom");
		emp.setAge(32);
		emp.setSalary(56000);
		emp.setMarried(true);
		
		ObjectMapper obj = new ObjectMapper();
		
		String empJson= obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		String resposne=  given().log().all().headers("Content-Type","application/json").body(empJson)
		 .when().post("api/users").then().log().all().assertThat().statusCode(201).extract().response().asString();
		
		System.out.println(resposne);
		
		//doing dserlization
		
		pojoemployeeclass empObj =obj.readValue(empJson,pojoemployeeclass.class);
		
		System.out.println();
		
		System.out.println("doing dserilization");
		
		System.out.println(empObj.getAge());
		System.out.println(empObj.getSalary());
		System.out.println(empObj.getName());
		
		
		
		
		
	}
	

}
