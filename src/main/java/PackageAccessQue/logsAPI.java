package PackageAccessQue;


import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logsAPI
{
	//public void loginbro()
	//{
	//ChromeOptions options = new ChromeOptions();
	//options.addArguments("headless");
	// Must maximize Chrome by `start-maximized`
	//options.addArguments("start-maximized");
	
		WebDriver driver;

	    @BeforeTest
	    static void setupAll()
	    {
	        WebDriverManager.chromedriver().setup();
	    }
		
	    @BeforeEach
	    void setup() {
	        driver = new ChromeDriver();
	    }
		
	    @AfterEach
	    void teardown() {
	        driver.quit();
	    }

	    @Test
	    void test() 
	    {
	        // Your test logic here
	    }
	 // close browser
		webDriver.quit();
	}
	

	}

}

/*

public static void main(String[] args) throws InterruptedException, MalformedURLException 
{
	// TODO Auto-generated method stub
//	System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
	ChromeDriver mydriver = new ChromeDriver();
	mydriver.manage().window().maximize();
			
	//TEST ACCESSQUE 
	//mydriver.get("https://services.accessque.com/home");
	mydriver.get("https://accessque.com/account/login");
	Thread.sleep(3000);
			
	mydriver.findElement(By.xpath("//a[contains(text(),'Member Login')]")).click();
	Thread.sleep(2000);
	
	WebElement email = mydriver.findElement(By.xpath("//input[@id='email']"));
	email.clear();
	email.sendKeys("ramana@universityhub.com");
	//email.sendKeys("admin.uh@accessque.com");
	Thread.sleep(2000);
	
	WebElement psd = mydriver.findElement(By.xpath("//input[@id='password']"));
	psd.clear();
	psd.sendKeys("Ramana@123");
	//psd.sendKeys("University@Hub1");
	Thread.sleep(2000);
	
	mydriver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();
	Thread.sleep(7000);
}
	
}
*/
