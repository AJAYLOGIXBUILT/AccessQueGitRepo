package PackageAccessQue;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
 
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class fileUploadDocsGradBusiness 
{
	//ONLY  API WISE FILE UPLOADNING  WORKING 
	@Test
	public void StudenloginData()
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
	public void uploadFileBachlor()
	{
				
		
		//Request sending payload data 
		JSONObject requestpara = new JSONObject();
		requestpara.put("Mailid","admin.uh@accessque.com");
		requestpara.put("password", "University@Hub1");
		
		
	        File file = new File("E:\\A\\Dummy_Images\\AMAZON.png");

	        RequestSpecification httprequest = RestAssured.given();
	        JSONObject requestpara1 = new JSONObject();
			requestpara1.put("mailid","admin.uh@accessque.com");
			requestpara1.put("password", "University@Hub1");
	        httprequest.header("x-auth-token","asseccque");
	        Response response =httprequest
	                .given()
	                .multiPart("document", file, "multipart/form-data")
	                .formParam("studentdocid", "14113")
	                .formParam("Platform", "Student")
	                .formParam("MailId", "ajaytestuser@spambox.xyz")
	                .post("https://www.services.accessque.com/api/v1/UploadDocument");
	               
	        System.out.println(response.prettyPrint());
	        
	        int statuscode = response.getStatusCode();	
	        System.out.println("Actual Status Code=" +statuscode);
      
	        
			// String sMessag = response.jsonPath().get("message");
 			//AssertJUnit.assertEquals(sMessag,"Uploaded the file successfully: ");
	        // Assert.assertEquals(bodyAsString.contains("message","Uploaded the file successfully:") ;
	        
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("Bachloar document uploaded API success");
			}
			else
			{
				System.out.println("API NOT WORKING");
			}

			assertTrue(response.asString().contains("Uploaded the file successfully:"));


	    }
	
	
	
	@Test
	public void uploadFileMaster() 
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
	                .formParam("studentdocid", "14114")
	                .formParam("Platform", "Student")
	                .formParam("MailId", "ajaytestuser@spambox.xyz")
	                .post("https://www.services.accessque.com/api/v1/UploadDocument");

	        System.out.println(response.prettyPrint());
	        
	        ResponseBody body = response.getBody();
	        System.out.println("Response Body is: " + body.asString());
	        
	        
	        int statuscode = response.getStatusCode();	
	        System.out.println("Actual Status Code=" +statuscode);
	        
	       	        
		    //String bodyAsString = response.getContentType("Uploaded the file successfully:");
	    	  // Assert.assertEquals(bodyAsString.contains("message","Uploaded the file successfully:") ;
	        
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("Master  document uploaded API success");
			}
			else
			{
				System.out.println("API NOT WORKING");
			}

			assertTrue(response.asString().contains("Uploaded the file successfully:"));
	        


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
	                .formParam("studentdocid", "14115")
	                .formParam("Platform", "Student")
	                .formParam("MailId", "ajaytestuser@spambox.xyz")
	                .post("https://www.services.accessque.com/api/v1/UploadDocument");
	        	        
	        // System.out.println(response.prettyPrint());
	        
	        int statuscode = response.getStatusCode();	
	        System.out.println("Actual Status Code=" +statuscode);
	        
	      //  String sMessag=response.jsonPath().get("message");
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
	
	
	@Test
	public void uploadFileCredEvelution() 
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
	                .formParam("studentdocid", "14116")
	                .formParam("Platform", "Student")
	                .formParam("MailId", "ajaytestuser@spambox.xyz")
	                .post("https://www.services.accessque.com/api/v1/UploadDocument");
	              
	       // System.out.println(response.prettyPrint());
	        
	        int statuscode = response.getStatusCode();	
			//AssertJUnit.assertEquals(message,200);
	        
	       // String bodyAsString = response.getContentType("Uploaded the file successfully:");
	    	  // Assert.assertEquals(bodyAsString.contains("message","Uploaded the file successfully:") ;
	        
			
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("Cred evealution document uploaded API success");
			}
			else
			{
				System.out.println("API NOT WORKING");
			}


	    }
	
	
	@Test
	public void uploadFileIELTS() 
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
	                .formParam("studentdocid", "14117")
	                .formParam("Platform", "Student")
	                .formParam("MailId", "ajaytestuser@spambox.xyz")
	                .post("https://www.services.accessque.com/api/v1/UploadDocument");
	        
	        int statuscode = response.getStatusCode();	
			//AssertJUnit.assertEquals(message,200);
	    	 // Assert.assertEquals(bodyAsString.contains("message","Uploaded the file successfully:") ;
	        
			
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("IELTS document uploaded API success");
			}
			else
			{
				System.out.println("API NOT WORKING");
			}


	    }
	
	}
	