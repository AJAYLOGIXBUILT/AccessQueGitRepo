package PackageAccessQue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimplePrint
{
	//WebDriver driver;
	@Test
	public static void main(String[] args)  
	{
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		WebDriver mydriver = new ChromeDriver(options);
		
		//options.addArguments("headless");
		//options.addArguments("start-maximized");
		//hromeDriver driver = new ChromeDriver(options);
		
		mydriver.get("https://services.accessque.com");

		System.out.println("HI,ACCESSQUE SITE LOGIN FORM OPEN IN BROWSER!");
		//driver.quit();
		
	}

}
