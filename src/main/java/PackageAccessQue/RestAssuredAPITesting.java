package PackageAccessQue;

//import io.restassured.RestAssured.*;
import io.restassured.response.Response;

import org.testng.Assert;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class RestAssuredAPITesting 
{
	@Test
	void loginTest()
	{		
		//Response myresponse = RestAssured.get("https://services.accessque.com/api/v1/templateByName/passwordverification");
		
		Response myresponse = RestAssured.get("https://accessque.com/uhleads");
						
	  	System.out.println(myresponse.toString());
	  	
	  	System.out.println(myresponse.getBody().asString());
	  	
	  	int statuscode= myresponse.getStatusCode();
	  	System.out.println("STATUS CODE IS  = " +statuscode);
	  	
	  	String statuscodeline = myresponse.getStatusLine();
	  	System.out.println("STATUS CODE LINE IS  = "+statuscodeline);
	  	Assert.assertEquals(statuscodeline, "HTTP/1.1 200 OK");
	  	
	  	System.out.println(myresponse.getHeader("content-type"));
	  	System.out.println( myresponse.getTime());
	    		  	
	  	//System.out.println(myresponse.getContentType());
	  	//System.out.println(myresponse.getCookies());
	  	//System.out.println(myresponse.getHeaders());	    
	 }
	
}
