package PackageAccessQue;

import org.asynchttpclient.Response;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdmiLoginLIVE 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		
		WebDriver mydriver = new ChromeDriver();
				
		//mydriver.get("https://accessque.com");
		mydriver.get("https://services.accessque.com/home");
		
		mydriver.manage().window().maximize();
		
		mydriver.getTitle();
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
		Thread.sleep(2000);
				
		Alert myalert= mydriver.switchTo().alert();
		String alrtms =mydriver.switchTo().alert().getText();
		System.out.println(alrtms);
		myalert.accept();	
		//admin
		//mydriver.navigate().refresh();								
		System.out.println("ADMIN LOGIN SUCCESSFULLY");
		mydriver.close();

	}	
}



