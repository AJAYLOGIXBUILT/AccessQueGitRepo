package PackageAccessQue;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.config.RequestConfig;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.http.Method;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class SignInAPI 
{
	@Test
	public void LiveAccessque_Login()
	{
		//LIVE ACCESSQUE API AFTR LOGIN TESTING : WORKING 
		//specify base URI
		RestAssured.baseURI="https://services.accessque.com/api/v1";
		
		//Request sending payload data 
		JSONObject requestpara = new JSONObject();
		requestpara.put("Mailid","admin.uh@accessque.com");
		requestpara.put("password", "University@Hub1");
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
	    
		httprequest.header("x-auth-token","asseccque");
		httprequest.header("Content-type","application/json");
		httprequest.body(requestpara.toJSONString());  //Attach data to the request
		
		//Response object
    	Response myResponse=httprequest.request(Method.POST,"/agentsignin");
		
    	//print response in console window
		String responsebody=myResponse.getBody().asString();
		System.out.println("RESPONSE BODY IS: "+responsebody);
		
		
		//status code validation
		int statuscode = myResponse.getStatusCode();
		int loadting = (int) myResponse.getTime();
		System.out.println("API LOADING TIME: = "+loadting);
		
		//Assert.assertEquals(statuscode,400);
		
		if(statuscode==200 || statuscode==201 || statuscode==304 )
		{
			System.out.println("PASSED: SIGNIN API WORKING");
		}
		else
		{
			System.out.println("FAILED: SIGNIN API NOT WORKING");
		}
		
		//validating headers from response
		String ContentType=myResponse.header("Content-Type");
		Assert.assertEquals(ContentType,"application/json; charset=utf-8");
		       
	}
	
}
