package PackageAccessQue;

import java.io.File;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.mongodb.util.JSON;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
//import io.restassured.path.json.JsonPath;

public class simple
{
		@Test
		public void uploadImage()	
		{
		
			//WORKING FOR GRADBUSSINESS  LIVE CODE 
			        File file = new File("E:\\A\\Dummy_Images\\AMAZON.png");

			        RequestSpecification httprequest = RestAssured.given();
			        JSONObject requestpara = new JSONObject();
					requestpara.put("mailid","admin.uh@accessque.com");
					requestpara.put("password", "University@Hub1");
			        httprequest.header("x-auth-token","asseccque");
			       
			        Response response =httprequest
			                .given()
			                .multiPart("document", file, "multipart/form-data")
			                .formParam("studentdocid", "14113")
			                .formParam("Platform", "Student")
			                .formParam("MailId", "ajaytestuser@spambox.xyz")
			                .post("https://www.services.accessque.com/api/v1/UploadDocument");
			               
			        //System.out.println(response.prettyPrint());
			        
			        int statuscode = response.getStatusCode();	
			        System.out.println("Actual Status Code=" +statuscode);
			        
			      
			        //JSON jsonPathEvaluator = response.jsonPath();
			        //String mymessage = jsonPathEvaluator.get("Uploaded the file successfully:");
			       // Assert.assertEquals(mymessage, "Uploaded the file successfully:", "successfully uploaded in response");
			        
			        ResponseBody bodyAsString = response.getBody();
      			  
			        
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
}


/*
 <classes>
      <class name=".AfterLoginAccessQueAPI"/>
      <class name="PackageAccessQue.TigerNetApplicationForm"/>
      <class name="PackageAccessQue.multipleTestCases"/>
      <class name="PackageAccessQue.gradBussinessAPI"/>
      <class name="PackageAccessQue.RestAssuredAPITesting"/>
      <class name="PackageAccessQue.simpleclass"/>
      <class name="PackageAccessQue.TigerNetApplicationForm2"/>
      <class name="PackageAccessQue.AfterLoginAllAPI2"/>
      <class name="PackageAccessQue.simple"/>
      <class name="PackageAccessQue.MyNewSite"/>
      <class name="PackageAccessQue.SignInAPI"/>
      <class name="PackageAccessQue.TigerNetApplicationWithoutMethod"/>
      <class name="PackageAccessQue.LoginTestCases"/>
      <class name="PackageAccessQue.LoginPageTest"/>
    </classes> 
 */
