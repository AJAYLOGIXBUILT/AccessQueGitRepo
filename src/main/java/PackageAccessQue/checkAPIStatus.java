package PackageAccessQue;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class checkAPIStatus 
{
 
	
	//NOT WORKING CODE 
	@Test
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		 RestAssured.baseURI=" https://www.services.accessque.com/api/v1";
	      RestAssured.basePath="/sentNotifications";
	     
	      JSONObject requestpara2 = new JSONObject();	   
	      
	      RequestSpecification httprequest=RestAssured.given();
	       httprequest.header("x-auth-token","asseccque");
	       httprequest.header("Content-type","application/json");
	       httprequest.body(requestpara2.toString());  //Attach data to the request
				
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


