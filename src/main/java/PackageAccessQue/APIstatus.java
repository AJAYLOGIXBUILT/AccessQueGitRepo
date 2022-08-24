package PackageAccessQue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class APIstatus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		
		WebDriver mydriver = new ChromeDriver();
				
		//mydriver.get("https://accessque.com");
		mydriver.get("https://services.accessque.com/home");
		Thread.sleep(4000);
		
		mydriver.manage().window().maximize();
		
		mydriver.getTitle();
		Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor)mydriver;
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"<passed/failed>\", \"reason\": \"<reason>\"}}");

		
	}

}
