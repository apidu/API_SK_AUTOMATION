package pojoexample2;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class createemployeemain {
	
	
	
	public static void main(String[] args) throws JsonProcessingException
	{
		
	
	
	RestAssured.baseURI="https://reqres.in";
	
	employeeadress empAdrsPojo = new employeeadress();
	
	empAdrsPojo.setCity("KOLKATA");
	empAdrsPojo.setState("wb");
	empAdrsPojo.setZip(700033);
	
	
	createemployee2 emp = new createemployee2();
	emp.setName("Tom");
	emp.setAge(32);
	emp.setSalary(56000);
	emp.setEmpAdd(empAdrsPojo);
	emp.setMarried(true);
	
	ObjectMapper obj = new ObjectMapper();
	
	String empJson= obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
	
	String resposne=  given().log().all().headers("Content-Type","application/json").body(empJson)
	 .when().post("api/users").then().log().all().assertThat().statusCode(201).extract().response().asString();
	
	System.out.println(resposne);
	
	
	
	}

}
