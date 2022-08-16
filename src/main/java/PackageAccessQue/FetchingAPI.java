package PackageAccessQue;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.idealized.Network;
 
public class FetchingAPI
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
		
		
		ChromeDriver ajDriver = new ChromeDriver();
		ajDriver.get("https://services.accessque.com");
	    Thread.sleep(2000);
	    
	    DevTools mytools=ajDriver.getDevTools();
	    
	    
	    ajDriver.getDevTools().send(Network.clearBrowserCache());
	   
	    ajDriver.get("https://services.accessque.com");
	    Thread.sleep(5000);
		
		DevTools 				 
	    //To send Command to ChromeDevTools 
		devToolss.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
	    
	    /*devTools.addListener(Network.requestWillBeSent(), entry -> {
	                System.out.println("Request (id) URL      : (" + entry.getRequestId() + ") " 
	                        + entry.getRequest().getUrl()
	                        + " (" + entry.getRequest().getMethod() + ")");
	            });*/
	    
		devToolss.addListener(Network.responseReceived(), response->
		{
			
			Response resp = response.getResponse();
			System.out.println(resp.getUrl());
			System.out.println(resp.getStatus());
			
			//System.out.println("Response (Req id) URL : (" +resp.getRequestId() + ") "  resp.getResponse().getUrl()+ " (" + resp.getResponse().getStatus() + ")");
	    }); 
	    
		ajdriver.get("https://services.accessque.com"); 
		
		
	}

}
