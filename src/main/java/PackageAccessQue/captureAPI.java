package PackageAccessQue;


import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class captureAPI 
{

	//System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
	//WebDriverManager.chromedriver().setup();
	//WebDriver mydriver = new ChromeDriver();
			
	ChromeDriver ajDriver = new ChromeDriver();
	ajDriver.manage().window().maximize();
	
	ChromeOptions chromeOptions = new ChromeOptions();
/*	chromeOptions.setCapability("browserVersion", "104");
	chromeOptions.setCapability("platformName", "Windows 10");*/

			
	
	
	//USING CRHOME DEVTOOLS access 		
	DevTools devTools= ((ChromeDriver)ajDriver).getDevTools();
	devTools.createSession();
	
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		
		//devTools.addListener(Network.requestWillBeSent(),
				devTools.addListener(Network.responseReceived(),response->
				{
					System.out.println("REQUEST URL IS " +response.getRequest().getUrl());
					System.out.println("REQUEST TYPES  IS " +response.getRequest().getMethod());
				});
		
		
	}
}
