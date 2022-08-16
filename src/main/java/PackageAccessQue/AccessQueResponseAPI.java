package PackageAccessQue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.idealized.Network;

import com.google.common.base.Optional;

public class AccessQueResponseAPI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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
				
		
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
       
        ChromeDriver mydriverss = new ChromeDriver(options);
       
        DevTools devTools = mydriverss.getDevTools();
        devTools.createSession();
        devTools.send(Network.clclearBrowserCache());
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.of(100000000)));
        devTools.send(Network.setCacheDisabled(true));
                
        mydriverss.get("https://services.accessque.com/home");
		
		

	}

}
