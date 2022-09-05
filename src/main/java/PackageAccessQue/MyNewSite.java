package PackageAccessQue;

import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Pattern;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyNewSite extends allPagesAPIresponse
{
	@Test
	public void gradUploadFile() throws InterruptedException, MalformedURLException, IOException, NoSuchFieldException, SecurityException
	{		
		//NEED TO TEST JENKIN SERVER
		//System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver mydriver = new ChromeDriver();
		//mydriver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		//mydriver.get("https://accessque.com");
		//mydriver.get("https://www.gradbusinesstest.accessque.com/redirect/49c44628-1423-46e0-bf97-568bd4e34a07/MSCS/N");
		//mydriver.get("https://www.gradbusiness.campbellsville.edu/redirect/519dd26b-9ad9-4f6c-9a94-771a8d5fb992/ITM/N");
		mydriver.manage().window().maximize();
		Thread.sleep(3000);
		mydriver.navigate().refresh();
		
		SessionId gradsession = ((RemoteWebDriver) mydriver).getSessionId();
	     System.out.println("Session Id is for method1: " + gradsession);
	     Thread.sleep(3000);
			
		//REDIRCTED ON GRADBUSINESS 		
		String strUrl = mydriver.getCurrentUrl();
		System.out.println("GRABUSINESS URL IS ="+strUrl);
		Thread.sleep(4000);
				
		
		
		ArrayList<String> arlTest = new ArrayList<String>();
		  //Size of arrayList
		  System.out.println("Size of ArrayList Before: " + arlTest.size());
		  //Lets add some elements to it
		  arlTest.add("Bachelors Transcript");
		  arlTest.add("Credential Evaluation");
		  arlTest.add("Masters Transcript");
		  arlTest.add("English Proficiency ");
		  arlTest.add("I-20");

		  System.out.println(arlTest);
		  System.out.println("NEW Size of ArrayList After: " + arlTest.size());
		  
		  //for(WebElement myele:arlTest)
		  for (int j = 0;j <1 ; j++)
		  {
			//try
			//{
				//System.out.println("List of Array elements: " + arlTest.get(j));
								
				//Click on ADD FILE BUTTON and Uploaded BECHELOR DOC file 
				//WebElement BacTrn=mydriver.findElement(By.xpath("//td[text()=' Bachelors Transcript ']//following-sibling::td/following-sibling::td/button"));
				String bechlorText=mydriver.findElement(By.xpath("//td[text()=' Bachelors Transcript ']")).getText();
				String ActBechText ="Bachelors Transcript";
					if(bechlorText.equals(ActBechText))
					{
						mydriver.findElement(By.xpath("//td[text()=' Bachelors Transcript ']//following-sibling::td/following-sibling::td/button[1]//img")).click();
						Thread.sleep(4000);
						//mydriver.findElement(By.xpath("//td[contains(text(),' Bachelors Transcript ')]//following-sibling::td//button[1]")).click();
					
						WebElement BachlorTrnscpt= mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
						BachlorTrnscpt.sendKeys("E:\\A\\Dummy_Images\\mex2.jpg"); //Uploading the file using sendKeys
						Thread.sleep(5000);
						//Click on Upload button 
						mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
						Thread.sleep(5000);
						
						System.out.println("Bachelor Documents Uploaded Successfully");
						mydriver.navigate().refresh();
						Thread.sleep(2000);
					
					}
					
					String credText=mydriver.findElement(By.xpath("//td[text()=' Credential Evaluation ']")).getText();
					String actCredText ="Credential Evaluation";
					if(credText.equals(actCredText))
					{
					
						//Click on ADD FILE BUTTON and Uploaded Credential Evaluation file 
						WebElement CredEve=mydriver.findElement(By.xpath("//td[text()=' Credential Evaluation ']//following-sibling::td/following-sibling::td/button[1]//img"));
						CredEve.click();
						Thread.sleep(2000);
						//WebElement CredEvoDoc = mydriver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
						WebElement CredEvoDoc = mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
						CredEvoDoc.sendKeys("E:\\A\\Dummy_Images\\b4.jpg"); //Uploading the file using sendKeys
						Thread.sleep(5000);				
						//Click on Upload button 
						mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
						Thread.sleep(5000);
						System.out.println("Credential Evaluation Documents Uploaded Successfully");
						mydriver.navigate().refresh();
						Thread.sleep(2000);
					}
						
					
					String mstText=mydriver.findElement(By.xpath("//td[text()=' Masters Transcript ']")).getText();
					String ActMstText ="Masters Transcript";
					if(mstText.equals(ActMstText))
					{
					
						//Click on ADD FILE BUTTON and Upload MASTER TRANSCRPT Doc 
						WebElement masTrn=mydriver.findElement(By.xpath("//td[text()=' Masters Transcript ']//following-sibling::td/following-sibling::td/button[1]//img"));
						masTrn.click();
						Thread.sleep(4000);
						WebElement MastrTrnscpt= mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
						MastrTrnscpt.sendKeys("E:\\A\\Dummy_Images\\B1.jpg"); //Uploading the file using sendKeys
						Thread.sleep(5000);		
						//Click on Upload button 
						mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
						Thread.sleep(5000);
						
						System.out.println("MASTER TRANSCRIPT DOC uploaded Successfully");
						mydriver.navigate().refresh();
						Thread.sleep(2000);
					}			
					
					
					String i20Text=mydriver.findElement(By.xpath("//td[text()=' I-20 ']")).getText();
					String Acti20Text ="I-20";
					if(i20Text.equals(Acti20Text))
					{	
						//Click on ADD FILE BUTTON and Upload I20 Doc 
						WebElement i20doc=mydriver.findElement(By.xpath("//td[text()=' I-20 ']//following-sibling::td/following-sibling::td/button[1]//img"));
						i20doc.click();
						Thread.sleep(4000);
						WebElement i20document= mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
						i20document.sendKeys("E:\\A\\Dummy_Images\\A.jpg"); //Uploading the file using sendKeys
						Thread.sleep(5000);		
						//Click on Upload button 
						mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
						Thread.sleep(5000);
						System.out.println("I-20 DOC uploaded Successfully");
						mydriver.navigate().refresh();
						Thread.sleep(3000);
						
						
						//SCROLL DOWN INNER TABLE 
						JavascriptExecutor js=(JavascriptExecutor)mydriver;
						js.executeScript("document.querySelector(\"tbody\").scrollTop=1500");
						
					}
					
					String EngText=mydriver.findElement(By.xpath("//td[text()=' English Proficiency  ']")).getText();
					String ActEngText ="English Proficiency";
					if(EngText.equals(ActEngText))
					{		
					
						//Click on ADD FILE BUTTON and Upload ENGLISH Doc 
						WebElement ENGLISH=mydriver.findElement(By.xpath("//td[text()=' English Proficiency  ']//following-sibling::td/following-sibling::td/button[1]//img"));
						ENGLISH.click();
						Thread.sleep(4000);
						WebElement englishDoc= mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
						englishDoc.sendKeys("E:\\A\\Dummy_Images\\Aus1.jpg"); //Uploading the file using sendKeys
						Thread.sleep(5000);		
						//Click on Upload button 
						mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
						Thread.sleep(5000);	
						System.out.println("ENGLISH PROFICIENCY DOC uploaded Successfully");
						mydriver.navigate().refresh();
						Thread.sleep(2000);
						
						//SCROLL DOWN INNER TABLE 
						JavascriptExecutor js=(JavascriptExecutor)mydriver;
						js.executeScript("document.querySelector(\"tbody\").scrollTop=1500");
						
						
						
						
						
					}
				//}			
				/*catch(Exception e)
				{
					System.out.println("SOMEINTHING ERROR "+e);				
					//System.out.println("SOMEINTHING COUNT"+j);
				}*/
		  }
		  
			
			allPagesAPIresponse accQAPI = new allPagesAPIresponse();
			accQAPI.TC01_AgentSIgnIn();
			Thread.sleep(3000);

		  // mydriver.close();
	}
			
}	
		



