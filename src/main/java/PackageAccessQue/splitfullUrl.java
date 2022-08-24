package PackageAccessQue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class splitfullUrl
{

	public static void main(String[] args) throws InterruptedException, MalformedURLException 
	{
		// TODO Auto-generated method stub
		
		
		//System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver mydriver = new ChromeDriver();
		mydriver.manage().window().maximize();
		Thread.sleep(3000);
		
		//graddriver.get("https://www.gradbusinesstest.accessque.com/redirect/03712c30-e6b3-4243-8eb7-ee10d99fbdb8/MSCS/N");

		//2nd lead created by ME 
		mydriver.get("https://www.gradbusinesstest.accessque.com/redirect/49c44628-1423-46e0-bf97-568bd4e34a07/MSCS/N");
		Thread.sleep(3000);
			
		
		
		//REDIRCTED ON GRADBUSINESS 		
				String strUrl = mydriver.getCurrentUrl();
				System.out.println("GRABUSINESS URL IS ="+strUrl);
				Thread.sleep(15000);	
				 
				String[] request_uri;
				if (strUrl.startsWith("https://"))
				{
				    request_uri = strUrl.split("&");
				} else {
					 request_uri = strUrl.split("/");
				}

				System.out.println (request_uri);
				
				
				/*
				 * //split //String gUID = strUrl.substring(strUrl.length() - 10);
				 * 
				 * URL aURL = new URL(strUrl); System.out.println("protocol = " +
				 * aURL.getProtocol()); System.out.println("authority = " +
				 * aURL.getAuthority()); System.out.println("host = " + aURL.getHost());
				 * System.out.println("port = " + aURL.getPort()); System.out.println("path = "
				 * + aURL.getPath()); System.out.println("query = " + aURL.getQuery());
				 * System.out.println("filename = " + aURL.getFile());
				 * System.out.println("ref = " + aURL.getRef());
				 */
	}

}
