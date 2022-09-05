package PackageAccessQue;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;

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
	public void uploadFileI20() 
	{
	        File file = new File("E:\\A\\Dummy_Images\\AMAZON.png");

	        RequestSpecification httprequest = RestAssured.given();
	        JSONObject requestpara = new JSONObject();
			requestpara.put("mailid","admin.uh@accessque.com");
			requestpara.put("password", "University@Hub1");
	        httprequest.header("x-auth-token","asseccque");
	        Response response =httprequest
	                .given()
	                .multiPart("document", file, "multipart/form-data")
	                .formParam("studentdocid", "14874")
	                .formParam("Platform", "CRM")
	                .formParam("MailId", "admin.uh@accessque.com")
	                .post("https://www.services.accessque.com/api/v1/addCustomDocUpload");
	        	        
	        // System.out.println(response.prettyPrint());
	        
	        int statuscode = response.getStatusCode();	
	        System.out.println("Actual Status Code=" +statuscode);
	       
	        
	        String sMessag= ((HashMap) response).get("message").toString();
	        System.out.println("MY MSG ="+sMessag);
	        
	        //Object data=requestpara.get("message");
	        //System.out.println("MY MSG ="+data);
	        
	        //String sMessag=response.jsonPath().get("message");
	        assertTrue(response.asString().contains("Uploaded the file successfully:"));
		    //String bodyAsString = response.getContentType("Uploaded the file successfully:");
	    	// Assert.assertEquals(bodyAsString.contains("bodyAsString","Uploaded the file successfully:") ;
	        
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("I20  document uploaded API success");
			}
			else
			{
				System.out.println("API NOT WORKING");
			}

			assertTrue(response.asString().contains("Uploaded the file successfully:"));


	    }
	
		
	

}
