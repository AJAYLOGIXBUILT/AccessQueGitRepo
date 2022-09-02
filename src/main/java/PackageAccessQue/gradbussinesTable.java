package PackageAccessQue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class gradbussinesTable
{
   public static void main(String[] args) throws InterruptedException
   {
	   WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);

		driver.manage().deleteAllCookies();
		Thread.sleep(3000);
		
		//mydriver.get("https://accessque.com");
		driver.get("https://www.gradbusinesstest.accessque.com/redirect/49c44628-1423-46e0-bf97-568bd4e34a07/MSCS/N");
		driver.manage().window().maximize();
		Thread.sleep(4000);
         
         // identify table
         WebElement t = driver.findElement(By.xpath("//tbody"));
         
         // count rows with size() method
         List<WebElement> rws = t.findElements(By.xpath("//tbody//tr"));
         int rws_cnt = rws.size();
         System.out.println("TABLE ROW COUNTS =  "+rws_cnt);
         
         //iterate rows of table
         for (int i = 0;i < rws_cnt; i++)
         {
        	 // count columns with size() method
        	 List<WebElement> cols = rws.get(i).findElements(By.xpath("//tbody//tr//td[2]"));
        	 int cols_cnt = cols.size();
        	 System.out.println("COL COUNT ="+cols_cnt);
        	 
        	 String documentName = cols.get(i).getText();
        	 System.out.println("Document Name is : " + documentName);
        	
        	 String credEvln=driver.findElement(By.xpath("//td[text()=' Credential Evaluation ']")).getText();
        	 
        	        	 
        	// if(documentName.equals(credEvln))
        	 //{        		
        		 WebElement clkc = driver.findElement(By.xpath("//tbody/tr[2]/td[4]/button[1]/img[1]"));
     			 clkc.click();
        	 //}
        	 
        	 //Assert.assertEquals(credEvln, true);
        	 //Assert.assertTrue(credEvln.isDisplayed());
        	 
        	WebElement BachlorTrnscpt= driver.findElement(By.xpath("//button[contains(text(),' Select Files ')]"));
        	BachlorTrnscpt.sendKeys("C:\\Users\\Admin\\Desktop\\Aston-Martin.jpg"); 
        	
        	//BachlorTrnscpt.click();
     		Thread.sleep(4000);
     		
     		BachlorTrnscpt.sendKeys("C:\\Users\\Admin\\Desktop\\Aston-Martin.jpg"); //Uploading the file using sendKeys
    		Thread.sleep(4000);
    		
    		driver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
    		Thread.sleep(6000);	
    		
    		System.out.println("BACHELOR  TRANSCRIPT DOC uploaded Successfully");
    		driver.close(); 
        	 
        	 
        	/*
        	 //iterate cols of table
         	for (int j = 0;j < cols_cnt; j++) 
         	{
         		// get cell text with getText()
         		String c = cols.get(j).getText();
         		System.out.println("Document Name are: " + c);
         		//abc.push(c)
         		//new array,here push c
         		
         	}
         	*/
         	//break;
         	
         	/*
         	if(cols_cnt>0)
         	{
        		//model open
         		WebElement BachlorTrnscpt= driver.findElement(By.xpath("//button[contains(text(),' Select Files ')]"));
        		BachlorTrnscpt.click();
        		Thread.sleep(4000);
        		
        		BachlorTrnscpt.sendKeys("C:\\Users\\Admin\\Desktop\\Aston-Martin.jpg"); //Uploading the file using sendKeys
        		Thread.sleep(4000);
        		
        		driver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
        		Thread.sleep(6000);	
        		
        		System.out.println("BACHELOR  TRANSCRIPT DOC uploaded Successfully");
        		driver.close(); 
         		*/
        	
         	
         }
      driver.quit();
      
   }
   
}