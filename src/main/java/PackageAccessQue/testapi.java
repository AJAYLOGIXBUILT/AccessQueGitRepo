package PackageAccessQue;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

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
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testapi {
	
	
	@Test(priority=3)
	public void TC07_Login()
	{
		
		//specify base URI
		RestAssured.baseURI="https://accessque.com";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject request = new JSONObject();
        request.put("mailid","admin.uh@accessque.com");
        request.put("password", "University@Hub1");
        httprequest.header("Content-type","application/json");
        httprequest.body(request.toJSONString());  //Attach data to the request
		
    	//Response object
    	Response response=httprequest.request(Method.POST,"/api/v1/agentsignin");
		//print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response Body is:"+responsebody);
		
		//status code validation
		int statuscode = response.getStatusCode();	
		AssertJUnit.assertEquals(statuscode,200);
		
		//success msg validation
		String Confirm_msg1=response.jsonPath().get("msg");
		AssertJUnit.assertEquals(Confirm_msg1,"Login successful");
		
		//validating headers from response
		String ContentType=response.header("Content-Type");
		AssertJUnit.assertEquals(ContentType,"application/json; charset=utf-8");
        
	}
	

}
