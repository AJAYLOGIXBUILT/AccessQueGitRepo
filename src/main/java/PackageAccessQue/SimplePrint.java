package PackageAccessQue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimplePrint
{
	@Test
	public void opnebrowser() 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver ajdriver= new ChromeDriver();

		ajdriver.get("https://services.accessque.com");

		System.out.println("HI,ACCESSQUE SITE LOGIN FORM OPEN IN BROWSER!");
		ajdriver.quit();
		
	}

}






