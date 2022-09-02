package PackageAccessQue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gradBussinessLive
{
	public static void main(String args[]) throws InterruptedException
	{
		
		//System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				WebDriver graddriver = new ChromeDriver();
				graddriver.manage().window().maximize();
				Thread.sleep(3000);
				
				//graddriver.get("https://www.gradbusinesstest.accessque.com/redirect/03712c30-e6b3-4243-8eb7-ee10d99fbdb8/MSCS/N");

				//2nd lead created by ME 
				//graddriver.get("https://www.gradbusinesstest.accessque.com/redirect/49c44628-1423-46e0-bf97-568bd4e34a07/MSCS/N");

				//3rd Leads created 
				graddriver.get("https://www.gradbusiness.campbellsville.edu/document/724fed04-9c5d-4e45-b793-de6a86710f0c/MSCS/N");
				Thread.sleep(3000);
				
				
				//Click on ADD FILE BUTTON and Uploaded BACHELOR TRANSCRPT Doc 
				WebElement BacTrn=graddriver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[1]/img[1]"));
				BacTrn.click();
				Thread.sleep(4000);
				
				WebElement BachlorTrnscpt= graddriver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
				BachlorTrnscpt.sendKeys("E:\\A\\Dummy_Images\\mex2.jpg"); //Uploading the file using sendKeys
				Thread.sleep(4000);
				//Click on Upload button 
				graddriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
				Thread.sleep(6000);	
				System.out.println("BACHELOR  TRANSCRIPT DOC uploaded Successfully");
				
				//Refresh page 
				graddriver.navigate().refresh();
				Thread.sleep(2000);	
					
				
				//Click on ADD FILE BUTTON and Uploaded I20 Doc 
				WebElement i2o1=graddriver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[1]/img[1]"));
				i2o1.click();
				Thread.sleep(4000);								
				
				String newWindow = graddriver.getWindowHandle();
				graddriver.switchTo().window(newWindow);
				//Switching to new window
				graddriver.findElement(By.xpath("//input[@id='filesInput']")).click();
				Thread.sleep(2000);
				//Switching back to default/main window
				graddriver.switchTo().defaultContent();
				Thread.sleep(2000);
				
				
				
				graddriver.findElement(By.xpath("//body/ngb-modal-window[1]/div[1]/div[1]")).click();
				Thread.sleep(15000);
								
				WebElement i20Doc= graddriver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]"));
				i20Doc.sendKeys("E:\\A\\Dummy_Images\\green.jpg"); 
				Thread.sleep(4000);
				
				//Click on Upload button 
				graddriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
				Thread.sleep(6000);	
				System.out.println("i20 DOC is Uploaded Successfully");
				
				graddriver.close();
				
				
				//Click on ADD FILE BUTTON and Uploaded Credential Evaluation file 
				WebElement CredEve=graddriver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[1]/img[1]"));
				CredEve.click();
				Thread.sleep(2000);
				WebElement CredEvoDoc = graddriver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
				CredEvoDoc.sendKeys("E:\\A\\Dummy_Images\\mex2.jpg"); //Uploading the file using sendKeys
				Thread.sleep(4000);				
				//Click on Upload button 
				graddriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
				System.out.println(" Credential Evaluation Documents Uploaded Successfully");
				Thread.sleep(6000);
				
				
				
				
				
				
				//Click on ADD FILE BUTTON and Upload MASTER TRANSCRPT Doc 
				WebElement masTrn=graddriver.findElement(By.xpath("//tbody/tr[3]/td[4]/button[1]/img[1]"));
				masTrn.click();
				Thread.sleep(4000);
				WebElement MastrTrnscpt= graddriver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]"));
				MastrTrnscpt.sendKeys("E:\\A\\Dummy_Images\\mex2.jpg"); //Uploading the file using sendKeys
				Thread.sleep(4000);
				//Click on Upload button 
				graddriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
				Thread.sleep(6000);						
				System.out.println("MASTER TRANSCRIPT DOC uploaded Successfully");
				
				
				//Click on ADD FILE BUTTON and Uploade BACHELOR TRANSCRPT Doc 
				WebElement BacTrn=graddriver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[1]/img[1]"));
				BacTrn.click();
				Thread.sleep(4000);
				WebElement BachlorTrnscpt= graddriver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
				BachlorTrnscpt.sendKeys("E:\\A\\Dummy_Images\\mex2.jpg"); //Uploading the file using sendKeys
				Thread.sleep(4000);
				//Click on Upload button 
				graddriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
				Thread.sleep(6000);	
				System.out.println("BACHELOR  TRANSCRIPT DOC uploaded Successfully");
				
				
						
				
				//Click on Upload button 
				graddriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
				Thread.sleep(4000);
				
				//To DELETE uploaded FIle 
				//mydriver.findElement(By.xpath("//body/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/button[1]/img[1]")).click();
				//Thread.sleep(2000);
				
		
		
	}
	
	
	
}
