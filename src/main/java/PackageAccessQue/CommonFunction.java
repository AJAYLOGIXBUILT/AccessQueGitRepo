package PackageAccessQue;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonFunction 
{
	
	
	RestAssured.baseURI="https://services.accessque.com/api/v1";
	JSONObject requestpara = new JSONObject();
	RestAssured.baseURI="https://services.accessque.com/api/v1";

	public static void main(String[] args)
	{
		
		mutiURL();
		
		Response();
		APIstats();
		

	}

}




public void mutiURL()
{
	
	
	JSONObject requestpara = new JSONObject();
	//Response object
	Response response=httprequest.request(Method.POST,"/campbellsville/getRealTimeCountryReport");
	
	//Request object
	JSONObject requestpara = new JSONObject();
	//requestpara.put("endDate","2022-08-25T11:46:14.784Z");

	
	RequestSpecification httprequest=RestAssured.given();	            	        
    httprequest.header("x-auth-token","asseccque");
    httprequest.header("Content-type","application/json");
    httprequest.body(requestpara.toJSONString());
   			
	
}
	
public void Response()
{
Response response=httprequest.request(Method.POST,"/campbellsville/getRealTimeCountryReport");
//print response in console window
String responsebody=response.getBody().asString();
System.out.println("Response Body is 30:"+responsebody)
}
			
	    public void APIstats()
	    {
	    	
	    
	    	;
			
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