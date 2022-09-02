package PackageAccessQue;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class campBellsVilleDashboardAPI 
{
	
	//LIVE ACCESSQUE ALL API STATUS 
	@Test
	public void TC01_MyAgentSIgnIn()
	{
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			//Request object
			
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
			System.out.println("RESPONSE BODY IS 1: "+responsebody);
			
			//status code validation
			int statuscode = myResponse.getStatusCode();
			System.out.println("Actual Status Code 1 =" +statuscode);
			int loadtime = (int) myResponse.getTime();
			System.out.println("API LOADING TIME: = "+loadtime);
			//Assert.assertEquals(statuscode,200);
			
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("PASSED: SIGNIN API");
			}
			else
			{
				System.out.println("FAILED: SIGNIN API");
				
			}
			
			//validating headers from response
			String ContentType=myResponse.header("Content-Type");
			AssertJUnit.assertEquals(ContentType,"application/json; charset=utf-8");
	        
		}
				
	@Test
	public void TC0001_SerachOnCampBellsvilleDashboard()
	{	
		//specify base URI
		RestAssured.baseURI="https://services.accessque.com/api/v1";
					
		//Request object
		JSONObject requestpara = new JSONObject();
		requestpara.put("admin","false");
		requestpara.put("companyId","14");
		requestpara.put("userId","25");
							
								
		RequestSpecification httprequest=RestAssured.given();	            	        
		httprequest.header("x-auth-token","asseccque");
		httprequest.header("Content-type","application/json");
		httprequest.body(requestpara.toJSONString());
			       			
		//Response object
		Response response=httprequest.request(Method.POST,"/dashboardprojects");
		//print response in console window
		String responsebody=response.getBody().asString();
		System.out.println("Response Body is 1st:"+responsebody);
		
		//status code validation
		int statuscode = response.getStatusCode();	
		System.out.println("Actual Status Code 1st =" +statuscode);  //Run time 200 received
		//AssertJUnit.assertEquals(statuscode,201);
		if(statuscode==200 || statuscode==201 || statuscode==304 )
		{
			System.out.println("Searching on dashboard API = PASSED");
		}
		else
		{
			System.out.println("Searching on dashboard API = FAILED");
		}
			
	}
		
	

}
