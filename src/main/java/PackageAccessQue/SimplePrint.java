package PackageAccessQue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimplePrint
{
	WebDriver driver;
	@Test
	public static void main(String[] args)  
	{
		
		//System.setProperty("webdriver.chrome.driver", "System.setProperty(\"webdriver.chrome.driver\",\"E:\\\\A\\\\SOFTWARE\\\\ChromeDriver\\\\ChromeDriver104\\\\chromedriver.exe\");");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		// Must maximize Chrome by `start-maximized`
		options.addArguments("start-maximized");

		//Dont maximize Chrome by below line, because has no display
		//driver.manage().window().maximize();
//		WebDriverManager.chromedriver().setup();
//		WebDriver ajdriver= new ChromeDriver();

		//driver.get("https://services.accessque.com");

		System.out.println("HI,ACCESSQUE SITE LOGIN FORM OPEN IN BROWSER!");
		//driver.quit();
		
	}

}






