package PackageAccessQue;

import org.asynchttpclient.Response;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AccessQueAdminLogin 
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		
		WebDriver mydriver = new ChromeDriver(options);
				
		//mydriver.get("https://accessque.com");
		mydriver.get("https://services.accessque.com/home");
		mydriver.manage().window().maximize();
		Thread.sleep(2000);
				
		mydriver.findElement(By.xpath("//a[contains(text(),'Member Login')]")).click();
		Thread.sleep(2000);
		
		WebElement email = mydriver.findElement(By.xpath("//input[@id='email']"));
		email.clear();
		email.sendKeys("admin.uh@accessque.com");
		Thread.sleep(2000);
		
		WebElement psd = mydriver.findElement(By.xpath("//input[@id='password']"));
		psd.clear();
		psd.sendKeys("University@Hub1");
		Thread.sleep(2000);
		
		mydriver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
		Thread.sleep(3000);
		
		//mydriver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("ADMIN LOGIN SUCCESSFULLY");
		//mydriver.close();

		//CU->Search particular Leads ->Fetch API -> get GUID":"75e86332-b7cc-4015-97a5-ebbc622f60a1 ->View leads ->Upload document 
		
		WebElement mysearch=mydriver.findElement(By.xpath("//thead/tr[1]/td[1]/div[1]/input[1]"));
		mysearch.sendKeys("ajaytestuser");
		Thread.sleep(4000);
				
		/*
		 * WebElement scroll=driver.findElement(By.css(".xyz")); JavascriptExecutor
		 * js=(JavascriptExecutor)driver;
		 * js.executeScript("document.querySelector(scroll).scrollLeft=1000");
		 * Thread.sleep(3000);
		 */
					
		/*
		 * js.executeScript("arguments[].scrollIntoView()",scrollleft);
		 * Thread.sleep(4000); mydriver.close();
		 */
		
		
		WebElement viewClk=mydriver.findElement(By.xpath("//tbody/tr[1]/td[11]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/button[1]/span[1]/img[1]"));
		viewClk.click();
		Thread.sleep(3000);
				
		WebElement DocValid=mydriver.findElement(By.xpath("//div[contains(text(),'Document Validation')]"));
		DocValid.click();
		Thread.sleep(3000);
		
		WebElement uplodclk=mydriver.findElement(By.xpath("//mat-tab-body/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/button[2]/img[1]"));
		uplodclk.click();
		Thread.sleep(2000);
		
		WebElement selectfile=mydriver.findElement(By.xpath("//button[contains(text(),'Select Files')]"));
		selectfile.click();
		Thread.sleep(2000);
		
		
		
		
		
	}	
}



