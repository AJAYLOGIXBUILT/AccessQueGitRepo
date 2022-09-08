package PackageAccessQue;

import org.testng.annotations.Test;

import com.mongodb.util.JSON;

import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.config.RequestConfig;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.http.Method;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class allPagesAPIresponse 
{	
	
	
		//LIVE ACCESSQUE ALL API STATUS 
		@Test(priority=1)
		public void TC01_AgentSIgnIn() throws NoSuchFieldException, SecurityException
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
			
						
			//status code validationss
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
		
		
		@Test(priority=2)
		public void TC02_AdminRole()
		{
			
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			//Request object
				
			JSONObject request = new JSONObject();
	        
	        RequestSpecification httprequest=RestAssured.given();
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(request.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.GET,"/adminRole/25");
			//print response in console window
			String responsebody=response.getBody().asString();
			
			
					
			System.out.println("Response Body is 1:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 1=" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,200);
			
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("ADMIN ROLE API :PASSED");
			}
			else
			{
				System.out.println("ADMIN ROLE API :FAILED");
			}
			
			//validating headers from response
			String ContentType=response.header("Content-Type");
			AssertJUnit.assertEquals(ContentType,"application/json; charset=utf-8");
	        
		}

		@Test(priority=3)
		public void TC03_DashboardProject()
		{
			
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			//Request object
			
			
			JSONObject request = new JSONObject();
	        request.put("admin","false");
	        request.put("companyId","14");
	        request.put("userId","25");
	        
	        RequestSpecification httprequest=RestAssured.given();
	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(request.toString());  //Attach data to the request
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/dashboardprojects");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 3 :"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 3=" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,200);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("DASHBOARD PROJECT API :PASSED");
			}
			else
			{
				System.out.println("DASHBOARD PROJECT API API :FAILED");
			}
			
			//validating headers from response
			String ContentType=response.header("Content-Type");
			AssertJUnit.assertEquals(ContentType,"application/json; charset=utf-8");
	        
		}
		
		@Test(priority=4)
		public void TC04_CallsByAgent()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			//Request object
			JSONObject request = new JSONObject();
	        request.put("admin","false");
	        request.put("companyId","14");
	        request.put("userId","25");
	        
	        RequestSpecification httprequest=RestAssured.given();
	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(request.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.GET,"/callsByAgent/WK82eaeab74aaa06cad1e7a20b268e9afa");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 4 :"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 4=" +statuscode);  //Run time 200 received
			
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("CALLS BY AGENT API= PASSED");
			}
			else
			{
				System.out.println("CALLS BY AGENT API API= FAILED");
			}
			
			//validating headers from response
			String ContentType=response.header("Content-Type");
			AssertJUnit.assertEquals(ContentType,"application/json; charset=utf-8");
	        
		}
		
		@Test(priority=5)
		public void TC05_PasswordVerifcation()
		{			
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			//Request object
				
			JSONObject request = new JSONObject();
	        
	        RequestSpecification httprequest=RestAssured.given();
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(request.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.GET,"/templateByName/passwordverification");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 5:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 5=" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,200);
			
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("ADMIN ROLE API :PASSED");
			}
			else
			{
				System.out.println("ADMIN ROLE API :FAILED");
			}
			
			//validating headers from response
			System.out.println("Password verification API");
		}
		
		
		
		@Test(priority=6)
		public void TC06_GetAgentNames()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			//Request object
			JSONObject request = new JSONObject();
	       	        
	        RequestSpecification httprequest=RestAssured.given();
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(request.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.GET,"/getAgentNames");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 6:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 6 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("CALLS BY AGENT API= PASSED");
			}
			else
			{
				System.out.println("CALLS BY AGENT API API= FAILED");
			}
			
			//validating headers from response
			String ContentType=response.header("Content-Type");
			AssertJUnit.assertEquals(ContentType,"application/json; charset=utf-8");
	        
		}
		
		@Test(priority=7)
		public void TC07_ListOfMyNotifications()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("Platform","CRM");
			requestpara.put("currentPage", "1");
			requestpara.put("email", "admin.uh@accessque.com");
			requestpara.put("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			
	        RequestSpecification httprequest=RestAssured.given();
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/listOfMyNotifications");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 7:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 7 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("LIST MY NOTIFICATIONS= PASSED");
			}
			else
			{
				System.out.println("LIST MY NOTIFICATIONS= FAILED");
			}
			
			//validating headers from response
			String ContentType=response.header("Content-Type");
			AssertJUnit.assertEquals(ContentType,"application/json; charset=utf-8");
	        
		}
		
		@Test(priority=8)
		public void TC08_ListOfMyNotifications()
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
	    	Response response=httprequest.request(Method.GET,"/notifications/getSavedNotificaitons/admin.uh@accessque.com/CRM/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 8:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 8 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("LIST MY NOTIFICATIONS= PASSED");
			}
			else
			{
				System.out.println("LIST MY NOTIFICATIONS= FAILED");
			}
			
			//validating headers from response
			String ContentType=response.header("Content-Type");
			AssertJUnit.assertEquals(ContentType,"application/json; charset=utf-8");
	        
		}
		
		//FAILED API 
		@Test(priority=9)
		public void TC09_GetRoleAgents()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("name","counselling");
			requestpara.put("projectId", "7");
			
	        RequestSpecification httprequest=RestAssured.given();	        	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/getRoleAgents");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 9:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 9 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET ROLE AGENT API = PASSED");
			}
			else
			{
				System.out.println("GET ROLE AGENT API = FAILED");
			}
					
		}
		
		@Test(priority=10)
		public void TC010_GetProjectIDUHUB()
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
	    	Response response=httprequest.request(Method.GET,"/getProjectById/7");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 10:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 10 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET PROJECT ID API = PASSED");
			}
			else
			{
				System.out.println("GET PROJECT ID API = FAILED");
			}
		
		}
		
		@Test(priority=11)
		public void TC011_AGENTS()
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
	    	Response response=httprequest.request(Method.GET,"/contacts/7/25/agent");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 11:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 11 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("AGENTS API = PASSED");
			}
			else
			{
				System.out.println("AGENTS API = FAILED");
			}
		
		}
		
		@Test(priority=12)
		public void TC012_RoleCompany()
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
	    	Response response=httprequest.request(Method.GET,"/Role/company/7");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 12:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 12 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("ROLE COMPANY API = PASSED");
			}
			else
			{
				System.out.println("ROLE COMPANY API = FAILED");
			}
		
		}
				
		//Campbellsville 9
		@Test(priority=13)
		public void TC013_ProjectAdmin()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("userId", "25");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/projectAdmin");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 13:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 13 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("PROJECT ADMIN UHUB API = PASSED");
			}
			else
			{
				System.out.println("PROJECT ADMIN UHUB API = FAILED");
			}
		
		}
		
		
		@Test(priority=14)
		public void TC014_GetGBPAgents()
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
	    	Response response=httprequest.request(Method.GET,"/campbellsville/getGBPAgents");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 14:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 14 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("CBV GET GBP AGENTS API = PASSED");
			}
			else
			{
				System.out.println("CBV GET GBP AGENTS= FAILED");
			}
		
		}
		
				
		@Test(priority=15)
		public void TC015_GetSideMenuRole()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			
			//JSONParser requestpara = new JSONParser();
			requestpara.put("roles","[95, 94, 93, 91, 90, 89, 88, 87, 86, 84, 83, 82, 74, 71, 70, 69, 68]");
			requestpara.put("superAdmin", "false");
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/getSideMenuRoles");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 154:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 15 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET SIDE MENU ROLE API = PASSED");
			}
			else
			{
				System.out.println("GET SIDE MENU ROLE API = FAILED");
			}
		
		}
		
		
		@Test(priority=16)
		public void TC016_GetTopBarCRM()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			
			//JSONParser requestpara = new JSONParser();
			requestpara.put("AgentMail","admin.uh@accessque.com");
			requestpara.put("ProjectId", "9");
			requestpara.put("end", "2022-08-27 04:41:28+00");
			requestpara.put("start", "2021-08-26 04:41:28+00");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/campbellsville/getTopBarCRM");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 16:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 16 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET TOP BAR CRM API = PASSED");
			}
			else
			{
				System.out.println("GET TOP BAR CRM API = FAILED");
			}
		
		}
		
	
		//*THIS API FAILING ALL API 
		@Test(priority=17)
		public void TC017_GetDashboardLeads2()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("admin", "true");
			requestpara.put("end", "2022-08-26 14:34:23+00");
			requestpara.put("leadType", "all");
			requestpara.put("mail", "admin.uh@accessque.com");
			requestpara.put("page", "1");
			requestpara.put("start", "2021-08-25 14:34:23+00");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/campbellsville/getDashboardLeads2");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 17:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 17 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET DASHBOARD LEADS2  API = PASSED");
			}
			else
			{
				System.out.println("GET DASHBOARD LEADS2 API = FAILED");
			}
		
		}
		
		
		@Test(priority=18)
		public void TC018_CRMAgents()
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
	    	Response response=httprequest.request(Method.GET,"/CRMAgents/9");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 18:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 18 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("CRM AGENTS  API = PASSED");
			}
			else
			{
				System.out.println("CRM AGENTS  API = FAILED");
			}
		
		}
		
		@Test(priority=19)
		public void TC019_GetAWSSignInUrlCampBellsVille()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("url","services/TemplateDocuments/campbellsville.xlsx");
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/getAwsSignedUrl");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 19:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 19 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET AWS SIGNIN URL API = PASSED");
			}
			else
			{
				System.out.println("GET AWS SIGNIN URL  API = FAILED");
			}
		
		}
		
		@Test(priority=20)
		public void TC020_UnReadNotificationCount()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("Platform","CRM");
			requestpara.put("email","admin.uh@accessque.com");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
								
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/notifications/unreadNotificationCount");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 19:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 19 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("UNREAD NOTIFICATION COUNT API = PASSED");
			}
			else
			{
				System.out.println("UNREAD NOTIFICATION COUNT  API = FAILED");
			}
		
		}
		
		
		@Test(priority=21)
		public void TC021_GetCompanies()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			//requestpara.put("Platform","CRM");
									
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.GET,"/getCompanies");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 21:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 21 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET COMPANIES API = PASSED");
			}
			else
			{
				System.out.println("GET COMPANIES  API = FAILED");
			}
		
		}
		
		@Test(priority=22)
		public void TC022_AgentLogin()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			//requestpara.put("worker","{\"SID\":\"WK82eaeab74aaa06cad1e7a20b268e9afa\"}}");								
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body("{\"worker\":{\"SID\":\"WK82eaeab74aaa06cad1e7a20b268e9afa\"}}");
	        httprequest.body(requestpara.toJSONString());
	       
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/7/agents/login");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 22:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 22 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET AGENTS API = PASSED");
			}
			else
			{
				System.out.println("GET AGENTS API = FAILED");
			}
		
		}
		
		@Test(priority=23)
		public void TC023_WSchannels()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("method","GET");		
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBQzBmZmJjYjVlZWE1MTg4NjY5YmE2NTk4NjJmOGY5MGJkIiwiZXhwIjoxNjYxNTgyNzQ5LCJ2ZXJzaW9uIjoidjEiLCJhY2NvdW50X3NpZCI6IkFDMGZmYmNiNWVlYTUxODg2NjliYTY1OTg2MmY4ZjkwYmQiLCJjaGFubmVsIjoiV0s4MmVhZWFiNzRhYWEwNmNhZDFlN2EyMGIyNjhlOWFmYSIsIndvcmtzcGFjZV9zaWQiOiJXUzNmY2QzMGJkNWQwZDRkMmQyOThkNmFmODFlYjBkMzEyIiwicG9saWNpZXMiOlt7InVybCI6Imh0dHBzOi8vZXZlbnQtYnJpZGdlLnR3aWxpby5jb20vdjEvd3NjaGFubmVscy9BQzBmZmJjYjVlZWE1MTg4NjY5YmE2NTk4NjJmOGY5MGJkL1dLODJlYWVhYjc0YWFhMDZjYWQxZTdhMjBiMjY4ZTlhZmEiLCJtZXRob2QiOiJHRVQiLCJxdWVyeV9maWx0ZXIiOnt9LCJwb3N0X2ZpbHRlciI6e30sImFsbG93Ijp0cnVlfSx7InVybCI6Imh0dHBzOi8vZXZlbnQtYnJpZGdlLnR3aWxpby5jb20vdjEvd3NjaGFubmVscy9BQzBmZmJjYjVlZWE1MTg4NjY5YmE2NTk4NjJmOGY5MGJkL1dLODJlYWVhYjc0YWFhMDZjYWQxZTdhMjBiMjY4ZTlhZmEiLCJtZXRob2QiOiJQT1NUIiwicXVlcnlfZmlsdGVyIjp7fSwicG9zdF9maWx0ZXIiOnt9LCJhbGxvdyI6dHJ1ZX0seyJ1cmwiOiJodHRwczovL3Rhc2tyb3V0ZXIudHdpbGlvLmNvbS92MS9Xb3Jrc3BhY2VzL1dTM2ZjZDMwYmQ1ZDBkNGQyZDI5OGQ2YWY4MWViMGQzMTIiLCJtZXRob2QiOiJHRVQiLCJxdWVyeV9maWx0ZXIiOnt9LCJwb3N0X2ZpbHRlciI6e30sImFsbG93Ijp0cnVlfSx7InVybCI6Imh0dHBzOi8vdGFza3JvdXRlci50d2lsaW8uY29tL3YxL1dvcmtzcGFjZXMvV1MzZmNkMzBiZDVkMGQ0ZDJkMjk4ZDZhZjgxZWIwZDMxMi8qKiIsIm1ldGhvZCI6IkdFVCIsInF1ZXJ5X2ZpbHRlciI6e30sInBvc3RfZmlsdGVyIjp7fSwiYWxsb3ciOnRydWV9LHsidXJsIjoiaHR0cHM6Ly90YXNrcm91dGVyLnR3aWxpby5jb20vdjEvV29ya3NwYWNlcy9XUzNmY2QzMGJkNWQwZDRkMmQyOThkNmFmODFlYjBkMzEyLyoqIiwibWV0aG9kIjoiUE9TVCIsInF1ZXJ5X2ZpbHRlciI6e30sInBvc3RfZmlsdGVyIjp7fSwiYWxsb3ciOnRydWV9XSwid29ya2VyX3NpZCI6IldLODJlYWVhYjc0YWFhMDZjYWQxZTdhMjBiMjY4ZTlhZmEiLCJpYXQiOjE2NjE0OTYzNDl9.XdxhpsZygyMgnVsVBGCgA_iw9XBFlU8G_tgP47mkxAo");		
			requestpara.put("url","https://taskrouter.twilio.com/v1/Workspaces/WS3fcd30bd5d0d4d2d298d6af81eb0d312/Workers/WK82eaeab74aaa06cad1e7a20b268e9afa/Reservations");		
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/wschannels/AC0ffbcb5eea5188669ba659862f8f90bd/WK82eaeab74aaa06cad1e7a20b268e9afa");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 23:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 23 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("WS CHANNELS API = PASSED");
			}
			else
			{
				System.out.println("WS CHANNELS = FAILED");
			}
		
		}
		
		@Test(priority=24)
		public void TC024_AgentChatAgentChannels()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("identity","adminstudentUniversityHub");		
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/7/agent-chat/agentChannels");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 24:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 24 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("WS CHANNELS API = PASSED");
			}
			else
			{
				System.out.println("WS CHANNELS = FAILED");
			}
		
		}
		
		
		@Test(priority=25)
		public void TC025_UpdateStatus()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("fcmtoken","fJAq_VBeXBz1czB_UQknRS:APA91bEVVZrvTfG2_KRRMmjecoKU2C1w-HeQhzwhbcZx0rgnfRk980C-H87Wj07N23tS6_M-Ro-tTNXEJmHKRyWSGB0XjDXOMNvVzZJI3cX6ON3RQRftEtua-nbumSry_iaiOSA9C2jX");		
			requestpara.put("id","25");
			requestpara.put("status","Offline");
			requestpara.put("token","");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/updateStatus");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 25:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 25 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("UPDATE STATUS API = PASSED");
			}
			else
			{
				System.out.println("UPDATE STATUS API = FAILED");
			}
		
		}
		
		
		
		//Click on REFEREE MENU calling API  without v1
		@Test(priority=26)
		public void TC026_ListofUniversities()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			//requestpara.put("identity","adminstudentUniversityHub");		
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.GET,"/7/ref/universitryhub/listOfUniversities");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 26:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 26 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("LIST OF UNIVERSITIESIS API= PASSED");
			}
			else
			{
				System.out.println("LIST OF UNIVERSITIESIS API= FAILED");
			}
		
		}	
		
		
		@Test(priority=27)
		public void TC027_RefGetTopBarReferers()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			//requestpara.put("identity","adminstudentUniversityHub");		
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/ref/getTopBarReferrer");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 27:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 27 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET TOP BAR REFERER API = PASSED");
			}
			else
			{
				System.out.println("GET TOP BAR REFERER API = FAILED");
			}
		
		}
		
			
		
		
		@Test(priority=28)
		public void TC028_GetRefereredLeads()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("ProjectId","10");
			requestpara.put("admin","true");
			requestpara.put("end","2022-08-27 11:23:34+00");
			requestpara.put("leadType","total");
			requestpara.put("mail","admin.uh@accessque.comb");
			requestpara.put("start","2021-08-26 11:23:34+00");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/ref/getReferredLeads");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 28:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 28 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET REFERERED LEADS API = PASSED");
			}
			else
			{
				System.out.println("GET REFERERED LEADS API = FAILED");
			}
		
		}
		
		
		//Click on ANALYTICS sub menu  & double SLACE issue 
		//https://services.accessque.com/api/v1//campbellsville/getRunReports
		@Test(priority=29)
		public void TC029_GetRunReports()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("endDate","2022-08-25T11:46:14.784Z");
			requestpara.put("for","activeusers");
			requestpara.put("from","");
			requestpara.put("startDate","2022-08-27 11:02:39+00");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/campbellsville/getRunReports");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 29:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 29 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET RUN REPORTS API = PASSED");
			}
			else
			{
				System.out.println("GET RUN REPORTS API = FAILED");
			}
		
		}
		
		
		
		//https://services.accessque.com/api/v1//campbellsville/getRealTimeCountryReport   double slace issue 
		@Test(priority=30)
		public void TC030_GetRealTimeCountryReports()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			//requestpara.put("endDate","2022-08-25T11:46:14.784Z");
		
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/campbellsville/getRealTimeCountryReport");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 30:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 30 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET REALTIME COUNTRY REPORT API = PASSED");
			}
			else
			{
				System.out.println("GET REALTIME COUNTRY REPORT API = FAILED");
			}
		
		}
		
		
		//https://services.accessque.com/api/v1//campbellsville/getRealTimeCountryReportChart  double SLACE issue calling multple times onBIApplication
		@Test(priority=31)
		public void TC031_GetRealTimeCountryReportsCHART()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			//requestpara.put("endDate","2022-08-25T11:46:14.784Z");
		
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/campbellsville/getRealTimeCountryReportChart");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 31:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 31 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET REALTIME COUNTRY REPORT CHART API = PASSED");
			}
			else
			{
				System.out.println("GET REALTIME COUNTRY REPORT CHART API = FAILED");
			}
		
		}
		
		
		//click on  APPLICATION ANALYTICS sub menu BI ANALYTICS 
		@Test(priority=32)
		public void TC032_BiAnaReportsProjectList()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/projectsList");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 32:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 32 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("REPORT PROJEC LIST API = PASSED");
			}
			else
			{
				System.out.println("REPORT PROJEC LIST  API = FAILED");
			}
		
		}
		
		
		@Test(priority=33)
		public void TC033_BiAnaGetListOfPrograms()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			//requestpara.put("userId","25");
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.GET,"/campbellsville/getListOfPrograms/25/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 33:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 33 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET LIST OF PROGRAMS API = PASSED");
			}
			else
			{
				System.out.println("GET LIST OF PROGRAMS API = FAILED");
			}
		
		}
		
		@Test(priority=34)
		public void TC034_EnrollmentsTermsList()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("platform","CRM");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.GET,"/reports/enrollmentTermList");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 33:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 33 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("ENROLLMENT TERMS LIST API = PASSED");
			}
			else
			{
				System.out.println("ENROLLMENT TERMS LIST API = FAILED");
			}
		
		}
		
		
		@Test(priority=35)
		public void TC035_EnrollmentsYearsList()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("platform","CRM");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/enrollmentYearList");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 35:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 35 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("ENROLLMENT YEARS LIST API = PASSED");
			}
			else
			{
				System.out.println("ENROLLMENT YEARS LIST API = FAILED");
			}
		
		}
		
		
		
		@Test(priority=35)
		public void TC035_ApplicationList()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("platform","CRM");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/applicationslist");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 35:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 35 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("ENROLLMENT YEARS LIST API = PASSED");
			}
			else
			{
				System.out.println("ENROLLMENT YEARS LIST API = FAILED");
			}
		
		}
		
		@Test(priority=36)
		public void TC036_GetListOfAgentNew()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("platform","CRM");
			requestpara.put("projectId","2");
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/campbellsville/getListOfAgentsNew");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 36:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 36 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET LIST OF AGENTS NEW API = PASSED");
			}
			else
			{
				System.out.println("GET LIST OF AGENTS NEW  API = FAILED");
			}
		
		}
		
		@Test(priority=37)
		public void TC037_StatusCounts()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("agentEmail","All");
			requestpara.put("application","All");
			requestpara.put("course","All");
			requestpara.put("enrollmentTerm","All");
			requestpara.put("enrollmentYear","All");
			requestpara.put("from","2021-08-26 11:58:56+00");
			requestpara.put("platform","CRM");
			requestpara.put("to","2022-08-27 11:58:56+00");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
			
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/statusCounts");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 37:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 37 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("STATUS COUNTS API = PASSED");
			}
			else
			{
				System.out.println("STATUS COUNTS  API = FAILED");
			}
		
		}
		
		
		@Test(priority=38)
		public void TC038_AssignedCounts()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("agentEmail","All");
			requestpara.put("application","All");
			requestpara.put("course","All");
			requestpara.put("enrollmentTerm","All");
			requestpara.put("enrollmentYear","All");
			requestpara.put("from","2021-08-26 11:58:56+00");
			requestpara.put("platform","CRM");
			requestpara.put("to","2022-08-27 11:58:56+00");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/assignedCounts");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 38:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 38 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET LIST OF AGENTS NEW API = PASSED");
			}
			else
			{
				System.out.println("GET LIST OF AGENTS NEW  API = FAILED");
			}
		
		}
		@Test(priority=39)
		public void TC039_CourseCounts()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("agentEmail","All");
			requestpara.put("application","All");
			requestpara.put("course","All");
			requestpara.put("enrollmentTerm","All");
			requestpara.put("enrollmentYear","All");
			requestpara.put("from","2021-08-26 11:58:56+00");
			requestpara.put("platform","CRM");
			requestpara.put("to","2022-08-27 11:58:56+00");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/courseCounts");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 39:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 39 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("COURSE COUNTS API = PASSED");
			}
			else
			{
				System.out.println("COURSE COUNTS API = FAILED");
			}
		
		}
		
		@Test(priority=40)
		public void TC040_IncominCompleted()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("agentEmail","All");
			requestpara.put("application","All");
			requestpara.put("course","All");
			requestpara.put("enrollmentTerm","All");
			requestpara.put("enrollmentYear","All");
			requestpara.put("from","2021-08-26 11:58:56+00");
			requestpara.put("platform","CRM");
			requestpara.put("to","2022-08-27 11:58:56+00");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/incomingCompleted");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 40:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 40 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("INCOMING COMPLETED API = PASSED");
			}
			else
			{
				System.out.println("INCOMING COMPLETED API = FAILED");
			}
		
		}
		
		@Test(priority=41)
		public void TC041_TopPerformers()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("agentEmail","All");
			requestpara.put("application","All");
			requestpara.put("course","All");
			requestpara.put("enrollmentTerm","All");
			requestpara.put("enrollmentYear","All");
			requestpara.put("from","2021-08-26 11:58:56+00");
			requestpara.put("platform","CRM");
			requestpara.put("to","2022-08-27 11:58:56+00");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/topPerformers");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 41:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 41 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("TOP PERFORMER API = PASSED");
			}
			else
			{
				System.out.println("TOP PERFORMER  API = FAILED");
			}
		
		}
		
		@Test(priority=42)
		public void TC042_ProcessTimeMax10()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("agentEmail","All");
			requestpara.put("application","All");
			requestpara.put("course","All");
			requestpara.put("enrollmentTerm","All");
			requestpara.put("enrollmentYear","All");
			requestpara.put("from","2021-08-26 11:58:56+00");
			requestpara.put("platform","CRM");
			requestpara.put("to","2022-08-27 11:58:56+00");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/processingtimeMax10");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 42:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 42 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("PROCESS TIME MAX10 API = PASSED");
			}
			else
			{
				System.out.println("PROCESS TIME MAX10 API = FAILED");
			}
		
		}
		
		@Test(priority=43)
		public void TC043_ValidationTimeMax10()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("agentEmail","All");
			requestpara.put("application","All");
			requestpara.put("course","All");
			requestpara.put("enrollmentTerm","All");
			requestpara.put("enrollmentYear","All");
			requestpara.put("from","2021-08-26 11:58:56+00");
			requestpara.put("platform","CRM");
			requestpara.put("to","2022-08-27 11:58:56+00");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/validationtimeMax10");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 43:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 43 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("VALIDATION TIME MAX10 API = PASSED");
			}
			else
			{
				System.out.println("VALIDATION TIME MAX10 API = FAILED");
			}
		
		}
		
		
		//BI ANALYTICS -> Call Analytics
		@Test(priority=44)
		public void TC044_CallsPerDay()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","9");
			requestpara.put("agentEmail","All");
			requestpara.put("application","All");
			requestpara.put("course","All");
			requestpara.put("enrollmentTerm","All");
			requestpara.put("enrollmentYear","All");
			requestpara.put("from","2021-08-29 04:51:12+00");
			requestpara.put("platform","CRM");
			requestpara.put("to","2022-08-30 04:51:12+00");
			requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
			requestpara.put("userId","25");
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/reports/callsPerDay");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 44:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 44 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("CALL PER DAY  API = PASSED");
			}
			else
			{
				System.out.println("CALL PER DAY  API = FAILED");
			}
		}
		
		@Test(priority=45)
		public void TC045_CallsInboundOutbound()
		{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
				
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("projectId","9");
				requestpara.put("agentEmail","All");
				requestpara.put("application","All");
				requestpara.put("course","All");
				requestpara.put("enrollmentTerm","All");
				requestpara.put("enrollmentYear","All");
				requestpara.put("from","2021-08-29 04:51:12+00");
				requestpara.put("platform","CRM");
				requestpara.put("to","2022-08-30 04:51:12+00");
				requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
				requestpara.put("userId","25");
							
				RequestSpecification httprequest=RestAssured.given();	            	        
		        httprequest.header("x-auth-token","asseccque");
		        httprequest.header("Content-type","application/json");
		        httprequest.body(requestpara.toJSONString());
		       			
		    	//Response object
		    	Response response=httprequest.request(Method.POST,"/reports/callsInboundOutbound");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("Response Body is 45:"+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code 45 =" +statuscode);  //Run time 200 received
				//AssertJUnit.assertEquals(statuscode,201);
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("CALL INBOUND OUTBOUND API = PASSED");
				}
				else
				{
					System.out.println("CALL INBOUND OUTBOUND API = FAILED");
				}
		}
		
		@Test(priority=46)
		public void TC046_CallsInVsOut()
		{	
					//specify base URI
					RestAssured.baseURI="https://services.accessque.com/api/v1";
					
					//Request object
					JSONObject requestpara = new JSONObject();
					requestpara.put("projectId","9");
					requestpara.put("agentEmail","All");
					requestpara.put("application","All");
					requestpara.put("course","All");
					requestpara.put("enrollmentTerm","All");
					requestpara.put("enrollmentYear","All");
					requestpara.put("from","2021-08-29 04:51:12+00");
					requestpara.put("platform","CRM");
					requestpara.put("to","2022-08-30 04:51:12+00");
					requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
					requestpara.put("userId","25");
								
					RequestSpecification httprequest=RestAssured.given();	            	        
			        httprequest.header("x-auth-token","asseccque");
			        httprequest.header("Content-type","application/json");
			        httprequest.body(requestpara.toJSONString());
			       			
			    	//Response object
			    	Response response=httprequest.request(Method.POST,"/reports/callsInVsOut");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 46:"+responsebody);
					
					//status code validation
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 46 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("CALLS IN vs OUT API = PASSED");
					}
					else
					{
						System.out.println("CALLS IN vs OUT API = FAILED");
					}
						
				}
		
		@Test(priority=47)
		public void TC047_CallStatus()
		{	
						//specify base URI
						RestAssured.baseURI="https://services.accessque.com/api/v1";
						
						//Request object
						JSONObject requestpara = new JSONObject();
						requestpara.put("projectId","9");
						requestpara.put("agentEmail","All");
						requestpara.put("application","All");
						requestpara.put("course","All");
						requestpara.put("enrollmentTerm","All");
						requestpara.put("enrollmentYear","All");
						requestpara.put("from","2021-08-29 04:51:12+00");
						requestpara.put("platform","CRM");
						requestpara.put("to","2022-08-30 04:51:12+00");
						requestpara.put("token","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYWlsaWQiOiJhZG1pbi51aEBhY2Nlc3NxdWUuY29tIiwiaWF0IjoxNjU0NTEzNzc0LCJleHAiOjE2ODYwNDk3NzR9.OO3fOBwnUeVFRFAC3Ec1oE8a-Vhf2B0RTv6tPv3QE5A");
						requestpara.put("userId","25");
									
						RequestSpecification httprequest=RestAssured.given();	            	        
				        httprequest.header("x-auth-token","asseccque");
				        httprequest.header("Content-type","application/json");
				        httprequest.body(requestpara.toJSONString());
				       			
				    	//Response object
				    	Response response=httprequest.request(Method.POST,"/reports/callStatus");
						//print response in console window
						String responsebody=response.getBody().asString();
						System.out.println("Response Body is 47:"+responsebody);
						
						//status code validation
						int statuscode = response.getStatusCode();	
						System.out.println("Actual Status Code 47 =" +statuscode);  //Run time 200 received
						//AssertJUnit.assertEquals(statuscode,201);
						if(statuscode==200 || statuscode==201 || statuscode==304 )
						{
							System.out.println("CALL STATUS API = PASSED");
						}
						else
						{
							System.out.println("CALL STATUS API = FAILED");
						}
				}
		//-------------------------------------------------------------------------------------------------
		//INCIDENT MANAGEMENT ->DashboardTicket API  and selected University HUB
		
		@Test(priority=48)
		public void TC048_ProjectAdminUHUB()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","7");
			requestpara.put("userId", "25");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/projectAdmin");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 48:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 48 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("UHUB PROJECT ADMIN API = PASSED");
			}
			else
			{
				System.out.println("UHUB PROJECT ADMIN API = FAILED");
			}
		
		}
		
		@Test(priority=49)
		public void TC049_DashboardTicketsUHUB()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
						
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("admin","true");
			requestpara.put("companyId","7");
			requestpara.put("mail","admin.uh@accessque.com");
			requestpara.put("tickets","mygroups");
						
									
			RequestSpecification httprequest=RestAssured.given();	            	        
			httprequest.header("x-auth-token","asseccque");
			httprequest.header("Content-type","application/json");
			httprequest.body(requestpara.toJSONString());
				       			
			//Response object
			Response response=httprequest.request(Method.POST,"/dashboardTickets");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 49:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 49 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("DASHSBOARD TICKETS UHUB API = PASSED");
			}
			else
			{
				System.out.println("DASHSBOARD TICKETS UHUB API = FAILED");
			}
				
		}
		
		//Dashboard Admin true UHUB APi on when UHUB selected
			@Test(priority=50)
			public void TC050_DashboardAdminTrueUHUB()
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
		    	Response response=httprequest.request(Method.GET,"/dashboard/admin.uh@accessque.com/true/7");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("Response Body is 50:"+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code 50 =" +statuscode);  //Run time 200 received
				//AssertJUnit.assertEquals(statuscode,201);
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("DASHOBOARD ADMIN TRUE UHUB API = PASSED");
				}
				else
				{
					System.out.println("DASHOBOARD ADMIN TRUE UHUB API = FAILED");
				}
			}
				
		//------------------------------Campbellsville 51
				
			@Test(priority=51)
			public void TC051_DashboardTicketsCAMPBELLSVILLE()
			{	
				//specify base URI
				RestAssured.baseURI="https://services.accessque.com/api/v1";
							
				//Request object
				JSONObject requestpara = new JSONObject();
				requestpara.put("admin","true");
				requestpara.put("companyId","9");
				requestpara.put("mail","admin.uh@accessque.com");
				requestpara.put("tickets","mygroups");
							
										
				RequestSpecification httprequest=RestAssured.given();	            	        
				httprequest.header("x-auth-token","asseccque");
				httprequest.header("Content-type","application/json");
				httprequest.body(requestpara.toJSONString());
					       			
				//Response object
				Response response=httprequest.request(Method.POST,"/dashboardTickets");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("Response Body is 51:"+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code 51 =" +statuscode);  //Run time 200 received
				//AssertJUnit.assertEquals(statuscode,201);
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("DASHSBOARD TICKETS CAMPBELLVILLE API = PASSED");
				}
				else
				{
					System.out.println("DASHSBOARD TICKETS CAMPBELLVILLE API = FAILED");
				}
					
			}
		
			
			@Test(priority=52)
			public void TC052_DashboardAdminTrueCAMPBELLSVILLE()
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
		    	Response response=httprequest.request(Method.GET,"/dashboard/admin.uh@accessque.com/true/9");
				//print response in console window
				String responsebody=response.getBody().asString();
				System.out.println("Response Body is 52:"+responsebody);
				
				//status code validation
				int statuscode = response.getStatusCode();	
				System.out.println("Actual Status Code 52 =" +statuscode);  //Run time 200 received
				//AssertJUnit.assertEquals(statuscode,201);
				if(statuscode==200 || statuscode==201 || statuscode==304 )
				{
					System.out.println("DASHOBOARD ADMIN TRUE CAMPBELLSVILLE API = PASSED");
				}
				else
				{
					System.out.println("DASHOBOARD ADMIN TRUE CAMPBELLSVILLE API = FAILED");
				}
			}
			
			//----------------------------------------
		
		//INCIDENT MANAGEMENT ->DashboardTicket API  and selected REFERRALS dropdown
		
		@Test(priority=53)
		public void TC053_ProjectAdminREFERRALS()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("projectId","10");
			requestpara.put("userId", "25");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/projectAdmin");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 53:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 53 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("REFERRALS PROJECT ADMIN API = PASSED");
			}
			else
			{
				System.out.println("REFERRALS PROJECT ADMIN API = FAILED");
			}
		
		}
		
		
		@Test(priority=54)
		public void TC054_DashboardTicketsREFFERRALS()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
						
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("admin","true");
			requestpara.put("companyId","10");
			requestpara.put("mail","admin.uh@accessque.com");
			requestpara.put("tickets","mygroups");
						
									
			RequestSpecification httprequest=RestAssured.given();	            	        
			httprequest.header("x-auth-token","asseccque");
			httprequest.header("Content-type","application/json");
			httprequest.body(requestpara.toJSONString());
				       			
			//Response object
			Response response=httprequest.request(Method.POST,"/dashboardTickets");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 54:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 54 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("DASHSBOARD TICKETS REFERRALS API = PASSED");
			}
			else
			{
				System.out.println("DASHSBOARD TICKETS REFERRALS API = FAILED");
			}
				
		}
			
		
		//Dashboard Admin true REFERRALS  selected 
		@Test(priority=55)
		public void TC055_DashboardAdminTrueREFERRALS()
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
	    	Response response=httprequest.request(Method.GET,"/dashboard/admin.uh@accessque.com/true/9");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 51:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 51 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("DASHOBOARD ADMIN REFFERAL API = PASSED");
			}
			else
			{
				System.out.println("DASHOBOARD ADMIN CAMPBELLSVILL UNI = FAILED");
			}
		}

		//INCIDENT MANAGEMENT  ->Create NEW incident  ->TicketId API
		
		@Test(priority=56)
		public void TC056_CreateNewIncidentTicket()
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
	    	Response response=httprequest.request(Method.GET,"/ticketid");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 56:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 56 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("NEW TICKET API = PASSED");
			}
			else
			{
				System.out.println("NEW TICKET API = FAILED");
			}
		}

		@Test(priority=57)
		public void TC057_AgentGroupsID()
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
	    	Response response=httprequest.request(Method.GET,"/agentGroups/25");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 57:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 57 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("NEW TICKET API = PASSED");
			}
			else
			{
				System.out.println("NEW TICKET API = FAILED");
			}
		}
		
		@Test(priority=58)
		public void TC058_Priority()
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
	    	Response response=httprequest.request(Method.GET,"/prority");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 58:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 58 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("PRIORITY API = PASSED");
			}
			else
			{
				System.out.println("PRIORITY API = FAILED");
			}
		}
		
		
		@Test(priority=59)
		public void TC059_Urgency()
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
	    	Response response=httprequest.request(Method.GET,"/urgency");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 59:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 59 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("URGENCY API = PASSED");
			}
			else
			{
				System.out.println("URGENCY API = FAILED");
			}
		}
		
		@Test(priority=60)
		public void TC060_GetCompanyGroupsID()
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
	    	Response response=httprequest.request(Method.GET,"/getCompanyGroups/7");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 60:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 60 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET COMPANY GROUP ID API = PASSED");
			}
			else
			{
				System.out.println("GET COMPANY GROUP ID API = FAILED");
			}
		}
		
		
		@Test(priority=61)
		public void TC061_GetTemplateIDTikcet()
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
	    	Response response=httprequest.request(Method.GET,"/getTemplate/7/ticket");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 61:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 61 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET TEMPLATE ID  TICKET API = PASSED");
			}
			else
			{
				System.out.println("GET TEMPLATE ID  TICKET API = FAILED");
			}
		}
		
		//INCIDENT MANAGEMNET  -> MY GOUP OPEN Incident API 
		
		@Test(priority=62)
		public void TC062_ConfByNameDisplayColumnname()
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
	    	Response response=httprequest.request(Method.GET,"/configureByName/displayedColumns");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 62:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 62 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("CONFIGURE BYNAME DISPLAY COLUMNS API = PASSED");
			}
			else
			{
				System.out.println("CONFIGURE BYNAME DISPLAY COLUMNS API = FAILED");
			}
		}
		
		@Test(priority=63)
		public void TC063_RemainingColumns()
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
	    	Response response=httprequest.request(Method.GET,"/configureByName/remainingColumns");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 63:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 63 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("REMAINING COLUMNS API = PASSED");
			}
			else
			{
				System.out.println("REMAINING COLUMNS API = FAILED");
			}
		}
		
		
		@Test(priority=64)
		public void TC064_GetActiveAgentsID()
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
	    	Response response=httprequest.request(Method.GET,"/getActiveAgents/7");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 64:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 64 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET ACTIVE AGENTS ID API = PASSED");
			}
			else
			{
				System.out.println("GET ACTIVE AGENTS ID API = FAILED");
			}
		}
		
		@Test(priority=65)
		public void TC065_GetCustomTicketsOPEN()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("admin","true");
			requestpara.put("agentEmail","");
			requestpara.put("companyId","7");
			requestpara.put("from","2022-07-29T18:30:00.000Z");
			requestpara.put("mail","admin.uh@accessque.com");
			requestpara.put("offsetNumber","0");
			requestpara.put("status","open");
			requestpara.put("to","2022-08-30 04:51:12+00");					
																	
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/getCustomTickets");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 65:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 65 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET CUSTOM OPEN TICKETS API = PASSED");
			}
			else
			{
				System.out.println("GET CUSTOM OPEN TICKETS API = FAILED");
			}
		}
		
		
		@Test(priority=66)
		public void TC066_GetCustomTicketsCLOSED()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("admin","true");
			requestpara.put("agentEmail","");
			requestpara.put("companyId","7");
			requestpara.put("from","2022-07-29T18:30:00.000Z");
			requestpara.put("mail","admin.uh@accessque.com");
			requestpara.put("offsetNumber","0");
			requestpara.put("status","closed");
			requestpara.put("to","2022-08-29T18:30:00.000Z");					
																	
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
	       			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/getCustomTickets");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 66:"+responsebody);
			
			//status code validationfprojectAdmin
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 66 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET CUSTOM CLOSED TICKETS API = PASSED");
			}
			else
			{
				System.out.println("GET CUSTOM CLOSED TICKETS API = FAILED");
			}
		}
		//-----------------------------------------------------X------------------------------------------------
		//MARKETING  ->SMS Marketing with UINVERSITY HUB option selected 
		
		@Test(priority=67)
		public void TC067_GetAWSSignInUrlACCESSQUE()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("url","services/TemplateDocuments/accessque.xlsx");
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/getAwsSignedUrl");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 67:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 67 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET AWS SIGNIN URL API = PASSED");
			}
			else
			{
				System.out.println("GET AWS SIGNIN URL  API = FAILED");
			}
		
		}
		
		@Test(priority=68)
		public void TC068_AllCountries()
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
	    	Response response=httprequest.request(Method.GET,"/allCountries");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 68:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 68 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("ALL COUNTRY API = PASSED");
			}
			else
			{
				System.out.println("ALL COUNTRY API = FAILED");
			}
		
		}
		
		//Selecedt UHUB
		@Test(priority=69)
		public void TC069_SmsMarketingUHUB()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("ProjectId","7");
			requestpara.put("SmsStatus","pending");
			requestpara.put("admin","true");
			requestpara.put("mailId","admin.uh@accessque.com");
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/smsMarketing");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 69:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 69 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("SMS MARKETING API = PASSED");
			}
			else
			{
				System.out.println("SMS MARKETING API = FAILED");
			}
		
		}
		
		//Api 71 and 70 relative
		
		@Test(priority=70)
		public void TC070_GetProjectIDCAMPBELLSVILLE()
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
	    	Response response=httprequest.request(Method.GET,"/getProjectById/9");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 70:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 70 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET PROJECT ID API = PASSED");
			}
			else
			{
				System.out.println("GET PROJECT ID API = FAILED");
			}
		
		}
		
		//Sms marketing when selected CampBellsville
		@Test(priority=71)
		public void TC071_SmsMarketingCAMPBELLSVILLE()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("ProjectId","9");
			requestpara.put("SmsStatus","pending");
			requestpara.put("admin","true");
			requestpara.put("mailId","admin.uh@accessque.com");
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/smsMarketing");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 71:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 71 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("SMS MARKETING API = PASSED");
			}
			else
			{
				System.out.println("SMS MARKETING API = FAILED");
			}
		
		}
		
		
		//Selected Referrals 
		@Test(priority=72)
		public void TC072_SmsMarketingREFERRALS()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("ProjectId","10");
			requestpara.put("SmsStatus","pending");
			requestpara.put("admin","true");
			requestpara.put("mailId","admin.uh@accessque.com");
			
			
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/smsMarketing");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 72:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 72 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET PROJECT ID API = PASSED");
			}
			else
			{
				System.out.println("GET PROJECT ID API = FAILED");
			}
		
		}
		
		@Test(priority=73)
		public void TC073_GetProjectIDREFERRALS()
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
	    	Response response=httprequest.request(Method.GET,"/getProjectById/10");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 73:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 73 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("GET PROJECT ID API = PASSED");
			}
			else
			{
				System.out.println("GET PROJECT ID API = FAILED");
			}
		
		}
		//---------------------------------------------------
		//Call Marketing API- selected UHUB option
		
		@Test(priority=74)
		public void TC074_CallDataUHUB()
		{	
			//specify base URI
			RestAssured.baseURI="https://services.accessque.com/api/v1";
			
			//Request object
			JSONObject requestpara = new JSONObject();
			requestpara.put("ProjectId","7");
			requestpara.put("admin","true");
			requestpara.put("callStatus","all");
			requestpara.put("mailId","admin.uh@accessque.com");
						
			RequestSpecification httprequest=RestAssured.given();	            	        
	        httprequest.header("x-auth-token","asseccque");
	        httprequest.header("Content-type","application/json");
	        httprequest.body(requestpara.toJSONString());
			
	    	//Response object
	    	Response response=httprequest.request(Method.POST,"/callData");
			//print response in console window
			String responsebody=response.getBody().asString();
			System.out.println("Response Body is 74:"+responsebody);
			
			//status code validation
			int statuscode = response.getStatusCode();	
			System.out.println("Actual Status Code 74 =" +statuscode);  //Run time 200 received
			//AssertJUnit.assertEquals(statuscode,201);
			if(statuscode==200 || statuscode==201 || statuscode==304 )
			{
				System.out.println("CALLDATA FOR UHUB API = PASSED");
			}
			else
			{
				System.out.println("CALLDATA FOR UHUB API = FAILED");
			}
		
		}
		
		//Call Marketing API- selected CAMPBELLSVILLE option
		
				@Test(priority=75)
				public void TC075_CallDataCAMPBELLSVILLE()
				{	
					//specify base URI
					RestAssured.baseURI="https://services.accessque.com/api/v1";
					
					//Request object
					JSONObject requestpara = new JSONObject();
					requestpara.put("ProjectId","9");
					requestpara.put("admin","true");
					requestpara.put("callStatus","all");
					requestpara.put("mailId","admin.uh@accessque.com");
								
					RequestSpecification httprequest=RestAssured.given();	            	        
			        httprequest.header("x-auth-token","asseccque");
			        httprequest.header("Content-type","application/json");
			        httprequest.body(requestpara.toJSONString());
					
			    	//Response object
			    	Response response=httprequest.request(Method.POST,"/callData");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 75:"+responsebody);
					
					//status code validation
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 75 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("CALLDATA FOR CAMPBELLSVILLE API = PASSED");
					}
					else
					{
						System.out.println("CALLDATA FOR CAMPBELLSVILLE API = FAILED");
					}
				
				}
		
		
				//Call Marketing API- selected CAMPBELLSVILLE option
				
				@Test(priority=76)
				public void TC076_CallDataREFERRALS()
				{	
					//specify base URI
					RestAssured.baseURI="https://services.accessque.com/api/v1";
					
					//Request object
					JSONObject requestpara = new JSONObject();
					requestpara.put("ProjectId","10");
					requestpara.put("admin","true");
					requestpara.put("callStatus","all");
					requestpara.put("mailId","admin.uh@accessque.com");
								
					RequestSpecification httprequest=RestAssured.given();	            	        
			        httprequest.header("x-auth-token","asseccque");
			        httprequest.header("Content-type","application/json");
			        httprequest.body(requestpara.toJSONString());
					
			    	//Response object
			    	Response response=httprequest.request(Method.POST,"/callData");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 76:"+responsebody);
					
					//status code validation
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 76 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("CALLDATA FOR REFERRALS API = PASSED");
					}
					else
					{
						System.out.println("CALLDATA FOR REFERRALS API = FAILED");
					}
				
				}
			
		//------------------------------------------MAIL CAMPAIN API is not updated as per V1 so not created -----------------------
				//MAIL CAMPAGN ->Dashboard selected UHUB option
				//MAIL CAMPAGN ->Dashboard selected CAMPBELLSVILLE option
				//MAIL CAMPAGN ->Dashboard selected REFERRALS  option
				
	   //-------------------------------------------------------------------------------------------------------------------------
				
				
			//ADMINISTRATION ->Company Management API	
				
				@Test(priority=77)
				public void TC077_GetRoleCompaniesID()
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
			    	Response response=httprequest.request(Method.GET,"/getRoleCompanies/14");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 77:"+responsebody);
					
					//status code validation
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 77 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("GET ROLES COMPANYIES ID API = PASSED");
					}
					else
					{
						System.out.println("GET ROLES COMPANYIES ID API = FAILED");
					}
				
				}
				
				//Agent Management Api Template ByName ->UHUB
				@Test(priority=78)
				public void TC078_TemplateByNameTicket()
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
			    	Response response=httprequest.request(Method.GET,"/templateByName/ticket");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 78:"+responsebody);
					
					//status code validation
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 78 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("TEMPLATE BY NAME TICKET API = PASSED");
					}
					else
					{
						System.out.println("TEMPLATE BY NAME TICKE API = FAILED");
					}
				
				}
				
				// AGent managemnt  ->Campbellsville selected 
				@Test(priority=79)
				public void TC079_GetActiveAgentsIDCAMPBELLSVILLE()
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
			    	Response response=httprequest.request(Method.GET,"/getActiveAgents/9");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 79:"+responsebody);
					
					//status code validationfprojectAdmin
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 79 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("GET ACTIVE AGENTS ID API = PASSED");
					}
					else
					{
						System.out.println("GET ACTIVE AGENTS ID API = FAILED");
					}
				}
				
				// AGent managemnt  ->REFFERRALS selected 
				@Test(priority=80)
				public void TC080_GetActiveAgentsIDREFERRALS()
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
			    	Response response=httprequest.request(Method.GET,"/getActiveAgents/10");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 80:"+responsebody);
					
					//status code validationfprojectAdmin
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 80 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("GET ACTIVE AGENTS ID API = PASSED");
					}
					else
					{
						System.out.println("GET ACTIVE AGENTS ID API = FAILED");
					}
				}
				
				
				// MAIL TEMPLATE  ->UHUB selected 
				@Test(priority=81)
				public void TC081_AllTemplatesIDDREFERRALS()
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
			    	Response response=httprequest.request(Method.GET,"/allTemplates/7");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 81:"+responsebody);
					
					//status code validationfprojectAdmin
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 81 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("ALL TEMPLATE UHUB API = PASSED");
					}
					else
					{
						System.out.println("ALL TEMPLATE UHUB  API = FAILED");
					}
				}
		
				// MAIL TEMPLATE  ->CAMPBELLSVILLE selected 
				@Test(priority=82)
				public void TC082_AllTemplatesIDCAMPBELLSVILLE()
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
			    	Response response=httprequest.request(Method.GET,"/allTemplates/9");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 82:"+responsebody);
					
					//status code validationfprojectAdmin
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 82 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("ALL TEMPLATES CAMPBELLSVILLE API = PASSED");
					}
					else
					{
						System.out.println("ALL TEMPLATES CAMPBELLSVILLE  API = FAILED");
					}
				}
				
				
				// MAIL TEMPLATE  ->CAMPBELLSVILLE selected 
				@Test(priority=83)
				public void TC083_AllTemplatesIDREFERRALS()
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
			    	Response response=httprequest.request(Method.GET,"/allTemplates/10");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 83:"+responsebody);
					
					//status code validationfprojectAdmin
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 83 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("ALL TEMPLATES REFERRALS API = PASSED");
					}
					else
					{
						System.out.println("ALL TEMPLATES REFERRALS  API = FAILED");
					}
				}
				
				// AGENT CALL LOGS  ->UHUB selected 
				@Test(priority=84)
				public void TC084_GetCallLogsByCompany()
				{	
					//specify base URI
					RestAssured.baseURI="https://services.accessque.com/api/v1";
					
					//Request object
					JSONObject requestpara = new JSONObject();
					requestpara.put("companyId","7");
					requestpara.put("from","2022-07-29T18:30:00.000Z");
					requestpara.put("rowNumber","0");
					requestpara.put("to","2022-08-29T18:30:00.000Z");
					requestpara.put("workerSid","0");
								
																			
					RequestSpecification httprequest=RestAssured.given();	            	        
			        httprequest.header("x-auth-token","asseccque");
			        httprequest.header("Content-type","application/json");
			        httprequest.body(requestpara.toJSONString());
			       			
			    	//Response object
			    	Response response=httprequest.request(Method.POST,"/getCallLogsByCompany");
					//print response in console window
					String responsebody=response.getBody().asString();
					System.out.println("Response Body is 84:"+responsebody);
					
					//status code validationfprojectAdmin
					int statuscode = response.getStatusCode();	
					System.out.println("Actual Status Code 84 =" +statuscode);  //Run time 200 received
					//AssertJUnit.assertEquals(statuscode,201);
					if(statuscode==200 || statuscode==201 || statuscode==304 )
					{
						System.out.println("GET CALL LOGS BY COMPANY API = PASSED");
					}
					else
					{
						System.out.println("GET CALL LOGS BY COMPANY API = FAILED");
					}
				}
				
				//------------------------------------SOME ADDITIONAL ACTION WISE API----------------------------------------------
				
				//Searched with "ajay" on campbellsville dashbaord 
				@Test(priority=85)
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
						requestpara.put("search","ajaytestuser");
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
					@Test(priority=86)
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
						Response response=httprequest.request(Method.GET,"/campbellsville/getLead1/2554");
						//print response in console window
						String responsebody=response.getBody().asString();
						System.out.println("VIEW LEADS RESPONSE BODY="+responsebody);
						
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
					@Test(priority=87)
					public void AddCustomDocCreated()
					{	
						//specify base URI
						RestAssured.baseURI="https://services.accessque.com/api/v1";
									
						//Request object
						JSONObject requestpara = new JSONObject();
						requestpara.put("GUID","75e86332-b7cc-4015-97a5-ebbc622f60a1");
						requestpara.put("docName","2ndAugustDoc");
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
					@Test(priority=88)
					public void AddCustomDocUploaded()
					{	
						//specify base URI
						//RestAssured.baseURI="https://services.accessque.com/api/v1";
									
						//File file = new File("E:\\A\\Dummy_Images\\AMAZON.png");

				        RequestSpecification httprequest = RestAssured.given();
				        JSONObject requestpara = new JSONObject();
						//requestpara.put("mailid","admin.uh@accessque.com");
						//requestpara.put("password", "University@Hub1");
				        httprequest.header("x-auth-token","asseccque");
				        Response response =httprequest
				                .given()
				                .multiPart("document", new File("E:\\A\\Dummy_Images\\AMAZON.png"))
				                .formParam("studentdocid", "14851")
				                .formParam("Platform", "CRM")
				                .formParam("MailId", "admin.uh@accessque.com")
				                .post("https://www.services.accessque.com/api/v1/UploadDocument");
				        
				        //.multiPart("document", file, "multipart/form-data")
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
					@Test(priority=89)
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
					@Test(priority=90)
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
					@Test(priority=91)
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
					@Test(priority=92)
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
					@Test(priority=93)
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
					@Test(priority=94)
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
					@Test(priority=95)
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
					@Test(priority=96)
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
					@Test(priority=97)
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
					@Test(priority=98)
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
					@Test(priority=99)
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