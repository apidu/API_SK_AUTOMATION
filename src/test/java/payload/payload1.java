package payload;

import java.util.HashMap;
import java.util.Map;

public class payload1 {
	
	public static String Addemployee(String name, String job)
	{
		String employeeData="{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		
		return employeeData;
	}
	
	public static Map gorestnewuser()
	{
		Map<String,String> mp = new HashMap<String, String>();
		
		mp.put("name", "john Dklo");
		mp.put("gender", "male");
		String email="John"+Math.random()+"dKLO"+"@gmail.com";
		
		mp.put("email", email);
		
		mp.put("status","active");
		
		return mp;
		
		
	}

}
