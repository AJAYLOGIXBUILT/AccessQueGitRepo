package PackageAccessQue;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIaccessque 
{
	/*
	public static void main(String[] args) throws InterruptedException
	{
	//WebDriverManager.chromedriver().setup();
	WebDriver acQdriver = new ChromeDriver();
	acQdriver.manage().window().maximize();
	Thread.sleep(3000);
	
	acQdriver.get("https://services.accessque.com/uhleads");
	Thread.sleep(2000);
		
	acQdriver.findElement(By.xpath("//tbody/tr[1]/td[11]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/button[1]/span[1]/img[1]")).click();
	Thread.sleep(2000);
	
		AgentSIgnIn();
	
	 }
	*/
	
		@Test(priority=1)
		public static void AgentSIgnIn()
		{
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Json Object to sending payload data 
			JSONObject requestpara = new JSONObject();
			requestpara.put("Mailid","admin.uh@accessque.com");
			requestpara.put("password", "University@Hub1");
			
			//Request RequestSpecification object
			RequestSpecification httprequest=RestAssured.given();
		    httprequest.header("x-auth-token","asseccque");
			httprequest.header("Content-type","application/json");
			httprequest.body(requestpara.toJSONString());  //Attach data to the request
			
			//Response object
	    	Response myResponse=httprequest.request(Method.POST,"/agentsignin");
			
	    	//print response in console window
			String responsebody=myResponse.getBody().asString();
			System.out.println("SIGNIN RESPONSE BODY= "+responsebody);
			
			//status code validation
			int statuscode = myResponse.getStatusCode();
			System.out.println("Actual Status Code  =" +statuscode);
			
			//Load time for this API
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
	
			//Searched with "ajay" on campbellsville dashbaord 
		@Test(priority=2)
		public void SerachOnCampBellsvilleDashboard()
		{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("ProjectId","9");
				requestpara.put("admin","true");
				requestpara.put("callStatus","All");
				requestpara.put("course","All");
				requestpara.put("end","2022-08-03 09:40:25+00");
				requestpara.put("enrollmentTerm","All");
				requestpara.put("enrollmentYear","All");
				requestpara.put("export","false");
				requestpara.put("leadType","All");
				requestpara.put("mail","All");
				requestpara.put("page","1");
				requestpara.put("search","ajaytestuser@spambox.xyz");
				requestpara.put("start","2021-08-02 09:40:25+00");
									
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/campbellsville/getSearchDashboardLeads");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("SEARCHED RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code: =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("Searching on Campbellsville dashboard API = PASSED");
				}
				else
				{
					System.out.println("Searching on Campbellsville  API = FAILED");
				}		
			}
	
		
			//Searched with "ajaytestuser" on campbellsville dashbaord and click on VIEW button whose ID 2554 now 
			@Test(priority=3)
			public void GetLeadsVIEW()
			{	
				
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.GET,"/campbellsville/getLead1/2765");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("VIEW LEADS RESPONSE BODY="+responsebody);
				
				 JSONParser jsonParser = new JSONParser();
				  jsonParser.parse(response);
				
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code 1st =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("Searched and VIEW leads API = PASSED");
				}
				else
				{
					System.out.println("Searched and VIEW leads API = FAILED");
				}
					
			}
							
			//Searched with "ajaytestuser" on campbellsville dashbaord and click on VIEW button and created custom docs
			@Test(priority=4)
			public void AddCustomDocCreated()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("GUID","f81977d7-c710-4841-8f53-d18029ec6c41");
				requestpara.put("docName","6th Sep Doc");
				requestpara.put("Platform","CRM");
				requestpara.put("MailId","admin.uh@accessque.com");			
									
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/addCustomDocUpload");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println(" ADD CUSTOM DOC RESPONSE BODY= "+responsebody);
				
				
				
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code =" +statuscode);  //Run time 200 received
								
				
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("Add Custom doc Created API = PASSED");
				}
				else
				{
					System.out.println("Add Custom doc Created API = FAILED");
				}
					
			}
			
			//Searched with "ajay" on campbellsville dashbaord and created custom docs & Uploaded file
			@Test(priority=5)
			public void AddCustomDocUploaded()
			{	
				//specify base URI
				//RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				File file = new File("E:\\A\\Dummy_Images\\AMAZON.png");

		        RequestSpecification httprequest = RestAssured.given();
		        JSONObject requestpara = new JSONObject();
				//requestpara.put("mailid","admin.uh@accessque.com");
				//requestpara.put("password", "University@Hub1");
		        httprequest.header("x-auth-token","asseccque");
		        Response response =httprequest
		                .given()
		                .multiPart("document", file, "multipart/form-data")
		                .formParam("studentdocid", "14851")
		                .formParam("Platform", "CRM")
		                .formParam("MailId", "admin.uh@accessque.com")
		                .post("https://www.services.accessque.com/api/v1/UploadDocument");
		               
		        //System.out.println(response.prettyPrint());
		        
		        String responsebody=response.getBody().asString();
				System.out.println("UPLOADED DOC RESPONSE BODY= "+responsebody);
		        
		        int statuscode = response.getStatusCode();	
		        System.out.println("Actual Status Code=" +statuscode);
		        
		        //Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
		        
		        //JSON jsonPathEvaluator = response.jsonPath();
		        //String mymessage = jsonPathEvaluator.get("Uploaded the file successfully:");
		        //Assert.assertEquals(mymessage, "Uploaded the file successfully:", "Correct city name received in the Response");
		        //ResponseBody bodyAsString = response.getBody();
  			  
		        if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("Custom Doc uploaded API = PASSED");
				}
				else
				{
					System.out.println("Custom Doc uploaded API == FAILED");
				}

				assertTrue(response.asString().contains("Uploaded the file successfully:"));

		    }
			
			//Searched with "ajay" on campbellsville dashbaord and click on VIEW button and created custom docs and VALIDATED
			@Test(priority=6)
			public void ValidateDocument2()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("MailId","admin.uh@accessque.com");
				requestpara.put("Platform","CRM");
				requestpara.put("StudentdocId","14851");
				requestpara.put("admin","false");
				requestpara.put("validationStatus","validated");
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/campbellsville/documentValidation2");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("VALIDATED RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("DOCUMENT VALIDATED API = PASSED");
				}
				else
				{
					System.out.println("DOCUMENT VALIDATED API = FAILED");
				}
					
			}
			
			//Searched with "ajay" on campbellsville dashbaord and click on VIEW button and created custom docs and REVALIDATED
			@Test(priority=7)
			public void ReValidateDocument2()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("MailId","admin.uh@accessque.com");
				requestpara.put("Platform","CRM");
				requestpara.put("StudentdocId","14851");
				requestpara.put("admin","false");
				requestpara.put("validationStatus","revalidate");
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/campbellsville/documentValidation2");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("REVALIDATED RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
			
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println(" REVALIDATED DOCUMENT API = PASSED");
				}
				else
				{
					System.out.println("REVALIDATED DOCUMENT API = FAILED");
				}
					
			}
			
			//Send Both same notification when VALIDATE/REVALIDATE
			@Test(priority=8)
			public void SendNotifications()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("AgentMail","admin.uh@accessque.com");
				requestpara.put("GBPAssignedTo","");
				requestpara.put("GUID","");
				requestpara.put("LeadId","0");
				requestpara.put("Platform","CRM");
				requestpara.put("StudentDocId","14851");
				requestpara.put("Title","Document Validation");
				requestpara.put("description","Document status changed to validated by Admin UniversityHub");
				requestpara.put("notificationType","Validation");
				requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/sentNotifications");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("SEND NOTIFCATION RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("SEND NOTIFICATION API = PASSED");
				}
				else
				{
					System.out.println("SEND NOTIFICATION API = FAILED");
				}
					
			}
			
			//Add Comment APi 
			@Test(priority=9)
			public void AddComments()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("Admin","true");
				requestpara.put("AgentMail","admin.uh@accessque.com");
				requestpara.put("GUID","75e86332-b7cc-4015-97a5-ebbc622f60a1");
				requestpara.put("LeadId","2554");
				requestpara.put("Platform","CRM");
				requestpara.put("ProjectId","9");
				requestpara.put("StudentDocId","14851");
				requestpara.put("Text","Adidng Test COmments");
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/campbellsville/addComments");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("ADD COMMENT RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("ADD COMMENTS API = PASSED");
				}
				else
				{
					System.out.println("ADD COMMENTS API = FAILED");
				}
					
			}
			
			
			//UNDEFINED API getting with  504 error
			@Test(priority=10)
			public void LeadsUnDifined()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/campbellsville/getLead1/undefined");
				
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("UNDEFINED RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received

				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);

				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("LEADS UNDEFINED API= PASSED");
				}
				else
				{
					System.out.println("LEADS UNDEFINED API = FAILED THIS API ");
				}
					
			}
			
			
			//Send notification on added Comment 
			@Test(priority=11)
			public void CommentSendNotification()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("AgentMail","admin.uh@accessque.com");
				requestpara.put("GBPAssignedTo","");
				requestpara.put("GUID","75e86332-b7cc-4015-97a5-ebbc622f60a1");
				requestpara.put("LeadId","0");
				requestpara.put("Platform","CRM");
				requestpara.put("StudentDocId","14851");
				requestpara.put("Title","Comment");
				requestpara.put("description","Admin UniversityHub has commented");
				requestpara.put("notificationType","LeadComments");
				requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/sentNotifications");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("COMMENT SEND NOTIFCATION RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("COMMENTS SEND API = PASSED");
				}
				else
				{
					System.out.println("COMMENTS SEND API = FAILED");
				}
					
			}
			
			//------------------------------------CALL API 
			
			//Click on CALL button from Overview ,It get LIST of documents  
			@Test(priority=12)
			public void clickOnCALLListOfDoc()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
														
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.GET,"/GetListOfDocumentsStatus/75e86332-b7cc-4015-97a5-ebbc622f60a1");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("CLICK ON CALL LIST OF DOC RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("CLICKON CALL LIST OF DOC API = PASSED");
				}
				else
				{
					System.out.println("CLICKON CALL LIST OF DOC API = FAILED");
				}
					
			}
			
			
			//Click on CALL,and disconnceted at that time calling API   
			@Test(priority=13)
			public void updateCallStatus()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("calledBy","undefined undefined");
				requestpara.put("id","157");
				requestpara.put("status","answered");
				
														
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/campbellsville/updateCallStatus");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("CLICK ON CALL LIST OF DOC RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("UPDATE CALL STATUS  API = PASSED");
				}
				else
				{
					System.out.println("UPDATE CALL STATUS  API API = FAILED");
				}
					
			}
			
			
			//Click on CALL,and disconnceted at that time calling API   
			@Test(priority=14)
			public void updateStatus()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("fcmtoken","undefined undefined");
				requestpara.put("id","25");
				requestpara.put("status","Busy");
				requestpara.put("token","");
														
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/updateStatus");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("CLICK ON CALL LIST OF DOC RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("UPDATE STATUS API = PASSED");
				}
				else
				{
					System.out.println("UPDATE STATUS API = FAILED");
				}
					
			}
			
			
			//Click on CALL,and disconnceted at that time calling API   
			@Test(priority=15)
			public void updateCallSid()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("id","157");
				requestpara.put("sid","CA1ef4f6cc82317dc38d094d40b7c94a3d");
			
														
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/campbellsville/updateCallSid");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("CLICK ON CALL LIST OF DOC RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("UPDATE CALL SID API = PASSED");
				}
				else
				{
					System.out.println("UPDATE CALL SID API = FAILED");
				}
					
			}
			
	
			//Click on CALL,and disconnceted at that time calling API   
			@Test(priority=16)
			public void getAgentName()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
																		
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.GET,"/getAgentNames");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("CLICK ON CALL LIST OF DOC RESPONSE BODY="+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code  =" +statuscode);  //Run time 200 received
				
				//Load time for this API
				int loadtime = (int) response.getTime();
				System.out.println("API LOADING TIME: = "+loadtime);
				
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("GET AGENT NAME API = PASSED");
				}
				else
				{
					System.out.println("GET AGENT NAME  API = FAILED");
				}
					
			}
			

}
