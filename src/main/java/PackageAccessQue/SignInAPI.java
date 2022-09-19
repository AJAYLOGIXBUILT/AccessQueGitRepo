package PackageAccessQue;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import java.io.File;
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
		System.out.println("STATUS  CODE =" +statuscode);

		int loadting = (int) myResponse.getTime();
		System.out.println("API LOAD TIME: = "+loadting);

		//Assert.assertEquals(statuscode,400);

		if(statuscode==200 || statuscode==201 || statuscode==304 )
		{
			System.out.println("PASSED: SIGNIN API WORKING");
		}
		else
		{
			System.out.println("FAILED: SIGNIN API NOT WORKING");
		}

	}

	@Test
	public void UplodDocumentsAPI()
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
				.formParam("studentdocid", "15763")
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
}