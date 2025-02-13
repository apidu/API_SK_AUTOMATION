package MyBasicPraCTICE;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class usinglistpayload {

	public static void main(String[] args) {
	
		
		Map<String,Object> mp = new LinkedHashMap<String,Object>();
		mp.put("name","gaurav");
		mp.put("id",1234);
		mp.put("salary",52000);
		mp.put("isMarried", "gaurav");
		
		
		Map<String,Object>mp2=new LinkedHashMap<String, Object>();
		mp2.put("name","kaurav");
		mp2.put("id",1235);
		mp2.put("salary", 545688);
		mp2.put("isMarried", "kaurav");
		
		Map<String,Object>mp3=new LinkedHashMap<String, Object>();
		
		mp3.put("name","jaurav");
		mp3.put("id",456);
		mp3.put("salary",45689);
		mp3.put("isMarried","jaurav");
		
		
		List<Map>l1=new ArrayList<Map>();
		
		l1.add(mp);
		l1.add(mp2);
		l1.add(mp3);
		
		RestAssured.baseURI="https://reqres.in";
		
		String resposne= given().log().all().relaxedHTTPSValidation().headers("Content-Type","application/json").body(l1)
		 .when().post("api/users").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(resposne);
		

	}

}
