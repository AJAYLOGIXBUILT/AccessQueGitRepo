package PackageAccessQue;

import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
 
import java.io.IOException;
import java.io.InputStream;
import java.util.List; 
import org.testng.annotations.Test;
import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class RestAssuredAPITesting 
{
	@Test
	void loginTest()
	{	  		
		
	Response myresponse = RestAssured.get("https://services.accessque.com/api/v1/templateByName/passwordverification");
			  
	  System.out.println(myresponse.getContentType());
	  System.out.println(myresponse.toString());
	  //System.out.println(myresponse.getBody().asString());
	  System.out.println(myresponse.getStatusCode());
	  System.out.println(myresponse.toString());
	  
	  System.out.println(myresponse.getCookies());
	  System.out.println(myresponse.getHeaders());
	  
	  System.out.println(myresponse.getHeader("content-type"));
	    
	  
	 }	
}
