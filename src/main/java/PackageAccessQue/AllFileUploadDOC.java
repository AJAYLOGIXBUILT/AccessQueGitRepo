package PackageAccessQue;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllFileUploadDOC 
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver mydriver = new ChromeDriver();
		Thread.sleep(3000);

		mydriver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		//mydriver.get("https://accessque.com");
		mydriver.get("https://www.gradbusinesstest.accessque.com/redirect/49c44628-1423-46e0-bf97-568bd4e34a07/MSCS/N");
		mydriver.manage().window().maximize();
		Thread.sleep(4000);
			
		//List<WebElement> totalRow=mydriver.findElements(By.xpath("//tbody//tr"));
		
		List<WebElement> totalRow = mydriver.findElements(By.xpath("//table//tbody//tr//td[2]"));
		
		////td[text()=' Credential Evaluation ']/following-sibling::td[2]//button
		System.out.println("TOTAL ROW TO UPLOAD DOCS = " +totalRow.size());
		
		//verify all row count is 5 or not
		Assert.assertEquals(totalRow.size(), 5);
		
		//boolean status=false;	
		
		for(WebElement myele:totalRow)
		{
			String mmystring=myele.getText();
			//System.out.println(mmystring);
			
			mydriver.close();
			
			WebElement BacTrn=mydriver.findElement(By.xpath("//td[text()=' Credential Evaluation ']"));
			String mystring =BacTrn.getText();
			Thread.sleep(4000);
			String expectedstring ="Credential Evaluation";
			
			if(mystring.equals(expectedstring))
			{							
				WebElement BachlorTrnscpt= mydriver.findElement(By.xpath("//button[contains(text(),' Select Files ')]"));
				BachlorTrnscpt.sendKeys("E:\\A\\Dummy_Images\\mex2.jpg"); //Uploading the file using sendKeys
				Thread.sleep(4000);
				
				//Select File
				//ngb-modal-window//div//div//div//div//div//input[@id='filesInput']
				
				//Click on Upload button 
				mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
				Thread.sleep(6000);	
				System.out.println("BACHELOR  TRANSCRIPT DOC uploaded Successfully");
				
				 File file = new File("E:\\A\\Dummy_Images\\sup.jpg");

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
			
			//status=true;
			//break;
		}
			//Assert.assertTrue(status);
		//mydriver.close();
	}
}	
		
	
