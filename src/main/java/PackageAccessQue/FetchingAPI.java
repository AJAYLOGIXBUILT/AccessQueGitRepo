package PackageAccessQue;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.idealized.Network;

import org.openqa.selenium.devtools.CdpEndpointFinder;
import org.openqa.selenium.devtools.CdpInfo;
import org.openqa.selenium.devtools.CdpVersionFinder;
import org.openqa.selenium.devtools.Connection;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class FetchingAPI
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		
		//System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("browserVersion", "104");
		chromeOptions.setCapability("platformName", "Windows 10");
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://services.accessque.com");
				
		ChromeDriver ajDriver = new ChromeDriver();
		ajDriver.manage().window().maximize();
		
				
		
		DevTools devTools = ajDriver.getDevTools();		
		devTools.createSession();
		
		devTools.send(log.enable());
        
                        
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.clearBrowserCache());
        		
	  //To send Command to ChromeDevTools 
        devTools.addListener(Network.responseReceived(), response->
		{
			
			Response resp = response.getResponse();
			System.out.println(resp.getUrl());
			System.out.println(resp.getStatus());
			
			//System.out.println("Response (Req id) URL : (" +resp.getRequestId() + ") "  resp.getResponse().getUrl()+ " (" + resp.getResponse().getStatus() + ")");
	    }); 
	    
	    ajDriver.get("https://services.accessque.com"); 
	    ajDriver.findElement(By.xpath("//body/app-root[1]/app-landingpage[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
	    
	    
		
		
	}

}
