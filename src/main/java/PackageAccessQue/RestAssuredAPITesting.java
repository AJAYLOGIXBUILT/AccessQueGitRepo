package PackageAccessQue;

import static io.restassured.RestAssured.*;

import org.asynchttpclient.Response;
import org.testng.annotations.Test;

public class RestAssuredAPITesting 
{

	@Test
	void loginTest()
	{
	  
		RestAssured.o
		
	  Response myresponse = get("https://services.accessque.com/api/v1/templateByName/passwordverification");
	  
	  //Response myresponse = (Response) RestAssured.get("https://services.accessque.com/api/v1/templateByName/passwordverification");
	  
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
