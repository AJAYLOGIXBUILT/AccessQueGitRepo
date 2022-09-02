package PackageAccessQue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class gradBussinessAPI 
{
	
	//WORKING CODE BUT INPROGRESS 
	@Test
	public void getAllDOcumentList()
	{
		//specify base URI
		RestAssured.baseURI="https://www.services.accessque.com/api/v1";
		//RestAssured.basePath="/GetListOfDocumentsStatus";
		
		RequestSpecification httprequest = RestAssured.given();
		
		//Request sending payload data 
		JSONObject requestpara = new JSONObject();
		/*
		 * requestpara.put("studentdocid", "14113");
		 * requestpara.put("document","A.jpg"); requestpara.put("Platform", "Student");
		 * requestpara.put("MailId", "ajaytestuser@spambox.xyz");
		 */
				
		httprequest.header("x-auth-token","asseccque");
		httprequest.header("Content-type","application/json");
		httprequest.body(requestpara.toJSONString());  //Attach data to the request
		
		//Response object
    	Response myResponseget=httprequest.request(Method.GET,"/GetListOfDocumentsStatus/724fed04-9c5d-4e45-b793-de6a86710f0c");
    	//myResponseget.prettyPrint();
    	
    	
    	//print response in console window
    			String responsebody=myResponseget.getBody().asString();
    			System.out.println("RESPONSE BODY IS: "+responsebody);
    			
    			//status code validation
    			int statuscode = myResponseget.getStatusCode();
    			int loadting = (int) myResponseget.getTime();
    			System.out.println("API LOADING TIME: = "+loadting);
    			
    			//Assert.assertEquals(statuscode,400);
    			
    			if(statuscode==200 || statuscode==201 || statuscode==304 )
    			{
    				System.out.println("PASSED: 1st FUNCTION  OF GETTING LIST DOCUMENTS");
    			}
    			else
    			{
    				System.out.println("FAILED: 1st FUNCTION  OF GETTING LIST DOCUMENTS");
    			}
    	
    	
	}
	
	
	@Test
	public void uploadDocs() throws FileNotFoundException
	{

		 	//https://www.services.accessque.com/api/v1/UploadDocument
			//	https://services.accessque.com/api/v1/sentNotifications

		RestAssured.baseURI="https://www.services.accessque.com/api/v1";
		RestAssured.basePath="/UploadDocument";
		
		RequestSpecification httprequest = RestAssured.given();
		
		//Request sending payload data 
		JSONObject requestpara = new JSONObject();
		requestpara.put("studentdocid", "14113");
		//requestpara.put("document","E:\\A\\Dummy_Images\\AMAZON.png");
		requestpara.put("Platform", "Student");
		requestpara.put("MailId", "ajaytestuser@spambox.xyz");
				
		httprequest.header("x-auth-token","asseccque");
		httprequest.header("Content-type","application/json");
		//httprequest.header("Content-type","multiPart/form-data");
		httprequest.body(requestpara.toJSONString());  //Attach data to the request
		httprequest.multiPart("document", new File("E:\\A\\Dummy_Images\\AMAZON.png"),"image/png");
		
		//Response object
    	Response myResponsepost=httprequest.request(Method.POST,"/724fed04-9c5d-4e45-b793-de6a86710f0c");
    	
    	//myResponsepost.multiParts("document", new File("E:\\A\\Dummy_Images\\AMAZON.png"),"image/png");
    	//myResponsepost.prettyPrint();
		   	
    	//print response in console window
		String responsebody=myResponsepost.getBody().asString();
		Assert.assertTrue(responsebody.contains("Uploaded the file successfully:"));
		System.out.println("UPLOADED FILE RESPONSE BODY ARE: "+responsebody);
		
		//status code validation
		int statuscode = myResponsepost.getStatusCode();
		int loadting = (int) myResponsepost.getTime();
		System.out.println("API LOADING TIME: = "+loadting);
		
		//Assert.assertEquals(statuscode,400);
		//message: "Uploaded the file successfully: "
		
		if(statuscode==200 || statuscode==201 || statuscode==304 )
		{
			System.out.println("PASSED: 2nd FUNCTION UPLOAD FILE WORKING ");
		}
		else
		{
			System.out.println("FAILED: 2nd FUNCTION UPLOAD FILE NOT WORKING");
		}
		
		
	}

	@Test
	 public void senNOtifications()
	 {
	      System.out.println("Test Case 2");
	      
	      RestAssured.baseURI=" https://www.services.accessque.com/api/v1";
	      RestAssured.basePath="/sentNotifications";
	     
	      //JSONObject requestpara2 = new JSONObject();
	   
	      
	      RequestSpecification httprequest=RestAssured.given();
	      	   httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
		    
				Response myResponse=httprequest.request(Method.POST,"/agentsignin");
			
	    	//print response in console window
			String responsebody=myResponse.getBody().asString();
			System.out.println("Response Body is:"+responsebody);
			
			//status code validation
			int statuscode = myResponse.getStatusCode();	
			//AssertJUnit.assertEquals(statuscode,200);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("PASSED: SIGNIN API WORKING");
			}
			else
			{
				System.out.println("FAILED: SIGNIN API NOT WORKING");
			}
	      
	      
	      
	 }
	
	
	 
	

}
