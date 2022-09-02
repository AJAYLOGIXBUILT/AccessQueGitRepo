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

public class fileUploadDocs 
{
	@Test
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException
	//public void uploadFileBachlor() throws InterruptedException 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver mydriver = new ChromeDriver();
		Thread.sleep(3000);

		mydriver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		//mydriver.get("https://accessque.com");
		mydriver.get("https://www.gradbusinesstest.accessque.com/redirect/49c44628-1423-46e0-bf97-568bd4e34a07/MSCS/N");
		mydriver.manage().window().maximize();
		Thread.sleep(3000);
			
		//REDIRCTED ON GRADBUSINESS 		
		String strUrl = mydriver.getCurrentUrl();
		System.out.println("GRABUSINESS URL IS ="+strUrl);
		Thread.sleep(3000);	
		
			
		
		//Getting all the Document Name 
		WebElement MsterTrn=mydriver.findElement(By.xpath("//td[text()=' Masters Transcript ']"));
		Assert.assertTrue(MsterTrn.isDisplayed());
		
		
		
		String Docname2 =MsterTrn.getText();
		System.out.println(Docname2);
		
		WebElement i20doc=mydriver.findElement(By.xpath("//td[text()=' I-20 ']"));
		String Docname3 =i20doc.getText();
		System.out.println(Docname3);
		
		WebElement BachTrn=mydriver.findElement(By.xpath("//td[text()=' Bachelors Transcript ']"));
		String Docname4 =BachTrn.getText();
		System.out.println(Docname4);
		
		WebElement english=mydriver.findElement(By.xpath("//td[text()=' English Proficiency  ']"));
		String Docname5 =english.getText();
		System.out.println(Docname5);
		
		WebElement credEvl=mydriver.findElement(By.xpath("//td[text()=' Credential Evaluation ']"));
		String Docname1 =credEvl.getText();
		System.out.println(Docname1);
		Thread.sleep(2000);
		
		WebElement clickImport=mydriver.findElement(By.xpath("//tbody//tr[1]//td[4]//button//img[1]"));
		clickImport.click();
		Thread.sleep(2000);
			
		Actions myact=new Actions(mydriver);
		
		WebElement BachlorTrnscpt= mydriver.findElement(By.xpath("//button[contains(text(),' Select Files ')]"));
		//BachlorTrnscpt.click();
		myact.moveToElement(BachlorTrnscpt).perform();
		
		//Runtime.getRuntime().exec("E:\\A\\SOFTWARE\\AutoIt\\AccessqueAutoIt\\TigerNetFileUpload.au3");			
		Thread.sleep(4000);
		
		BachlorTrnscpt.sendKeys("C:\\Users\\Admin\\Desktop\\Aston-Martin.jpg"); //Uploading the file using sendKeys
		Thread.sleep(4000);
		
		
		mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
		Thread.sleep(6000);	
		System.out.println("BACHELOR  TRANSCRIPT DOC uploaded Successfully");
		mydriver.close();
	}

	//mydriver.close();

}	

		


	
/*	
	@Test
	public void uploadFileBachlor() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver mydriver = new ChromeDriver();

		mydriver.manage().deleteAllCookies();
		Thread.sleep(3000);

		//mydriver.get("https://accessque.com");
		mydriver.get("https://tigernet.campbellsville.edu/ICS/Apply/");
		mydriver.manage().window().maximize();
		Thread.sleep(3000);

		
		WebElement BacTrn=mydriver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[1]/img[1]"));
		BacTrn.click();
		Thread.sleep(4000);
		
		WebElement BachlorTrnscpt= mydriver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
		BachlorTrnscpt.sendKeys("E:\\A\\Dummy_Images\\mex2.jpg"); //Uploading the file using sendKeys
		Thread.sleep(4000);
		//Click on Upload button 
		mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
		Thread.sleep(6000);	
		System.out.println("BACHELOR  TRANSCRIPT DOC uploaded Successfully");
		
		
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
	               
	        System.out.println(response.prettyPrint());
	        
	        int statuscode = response.getStatusCode();	
	        System.out.println("Actual Status Code=" +statuscode);
//	       
	        
//	        String sMessag = response.jsonPath().get("message");
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
	*/