package PackageAccessQue;

//import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.AssertJUnit;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import org.testng.annotations.Test;

import groovyjarjarasm.asm.commons.Method;
import io.restassured.RestAssured;

import org.testng.annotations.Test;
import io.restassured.http.Method.*;

public class RestAssuredAPITesting 
{
	@Test
	void loginTest()
	{		
		//Response myresponse = RestAssured.get("https://services.accessque.com/api/v1/templateByName/passwordverification");
		
		RestAssured.baseURI="https://accessque.com";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		//Response response=httprequest.request(Method.POST,"/Home");
		RequestSpecification response=httprequest.request();
		
		//Response myresponse = RestAssured.get("https://accessque.com/uhleads");
		
		//print response in console window
		String responsebody=((ResponseOptions<Response>) response).getBody().asString();
		System.out.println("Response Body is:"+responsebody);
		
		//status code validation
		int statuscodes= ((ResponseOptions<Response>) response).getStatusCode();
	  	System.out.println("STATUS CODE IS  = " +statuscodes);
	  	Assert.assertEquals(statuscodes,200);
	  	
	  	//Status Line from response 
	  	String statuscodeline = ((ResponseOptions<Response>) response).getStatusLine();
	  	System.out.println("STATUS LINE IS  = "+statuscodeline);
	  	Assert.assertEquals(statuscodeline,"HTTP/1.1 200 OK");
	  	
	  	
	  //	System.out.println(response.getHeader("content-type"));
	  //	System.out.println( response.getTime());
	  	//System.out.println(myresponse.getContentType());
	  	//System.out.println(myresponse.getCookies());
	  	//System.out.println(myresponse.getHeaders());	    
	 }
	
}
