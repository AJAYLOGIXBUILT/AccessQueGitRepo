package PackageAccessQue;

import java.util.List;

import org.json.JSONObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

import groovyjarjarasm.asm.commons.Method;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class simpleclass
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
         		
		
		//String credEvln=mydriver.findElement(By.xpath("//td[text()=' Credential Evaluation ']")).getText();
		String credEvln=mydriver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
		String mystring =" Credential Evaluation ";
		
		System.out.println(credEvln);
		System.out.println(mystring);
		
		//if(mystring.equals(credEvln))
		///	{
			
			WebElement clkc= mydriver.findElement(By.xpath("//tbody/tr[2]/td[4]/button[1]/img[1]"));
			clkc.click();
			
			
			WebElement BachlorTrnscpt= mydriver.findElement(By.xpath("//button[contains(text(),' Select Files ')]"));
			BachlorTrnscpt.sendKeys("C:\\Users\\Admin\\Desktop\\Aston-Martin.jpg");
			Thread.sleep(2000);
			//BachlorTrnscpt.click();
     		//Thread.sleep(4000);
     		
     		BachlorTrnscpt.sendKeys("C:\\Users\\Admin\\Desktop\\Aston-Martin.jpg"); //Uploading the file using sendKeys
    		Thread.sleep(4000);
    		
    		mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
    		Thread.sleep(6000);	
    		
    		System.out.println("BACHELOR  TRANSCRIPT DOC uploaded Successfully");
    		mydriver.close(); 
        	 	
			
		}
		
}
/*
         
		List<WebElement> totalRow=mydriver.findElements(By.xpath("//td[text()=' Credential Evaluation ']/following-sibling::td//input"));
 		System.out.println("TOTAL ROW TO UPLOAD DOCS = " +totalRow.size());
 		
 		
 		
 		Assert.assertEquals(totalRow.size(), 5);
 		//boolean status=false;	
 		
 		for(WebElement myele:totalRow)
 		{
 			String mmystring=myele.getText();
 			//System.out.println(mmystring);
 			
 			mydriver.close();
 			
 			WebElement credEvln=mydriver.findElement(By.xpath("//td[text()=' Credential Evaluation ']"));
 			String mystring =credEvln.getText();
 			Thread.sleep(4000);
 			String expectedstring ="Credential Evaluation";
 			
 			if(mystring.equals(expectedstring))
 			{							
         
         
 				WebElement credEvln=mydriver.findElement(By.xpath("//td[text()=' Credential Evaluation ']"));
 				Assert.assertTrue(MsterTrn.isDisplayed());
 				
 			}

 		}
 		
 		*/
	