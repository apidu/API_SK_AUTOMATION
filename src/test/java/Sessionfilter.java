import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.filter.session.SessionFilter;

public class Sessionfilter {

	SessionFilter s;
	@BeforeTest
	public SessionFilter prereq()
	{
		s=new SessionFilter();
		return s;
	}
	
	@Test
	public void test()
	{
		RestAssured.baseURI="https://httpbin.org";
		
		String response= given().log().all().filter(s).when().get("get").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
	}
	@Test
	public void Test2()
	{
RestAssured.baseURI="https://httpbin.org";
		
		String response= given().log().all().filter(s).when().post("post").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
	
		
		
		
		
	}

}
