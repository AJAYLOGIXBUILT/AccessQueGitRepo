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
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		//options.addArguments("start-maximized");
		//hromeDriver driver = new ChromeDriver(options);
		
		//Dont maximize Chrome by below line, because has no displa	y
		//driver.manage().window().maximize();
		
		//river.get("https://services.accessque.com");

		System.out.println("HI,ACCESSQUE SITE LOGIN FORM OPEN IN BROWSER!");
		//driver.quit();
		
	}

}
