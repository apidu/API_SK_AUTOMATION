package usespecificbuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import payload.payload1;

import static io.restassured.RestAssured.*;

public class requestAndResonseBasedSpecifications {

	public static void main(String[] args) {
		
		RequestSpecification req =new RequestSpecBuilder()
				.setBaseUri("http://reqres.in")
				.setContentType(ContentType.JSON)
				.build();
		
		RequestSpecification res= given().log().all()
				.spec(req).body(payload1.Addemployee("JOKU", "QC Manager"));
		

	}

}
