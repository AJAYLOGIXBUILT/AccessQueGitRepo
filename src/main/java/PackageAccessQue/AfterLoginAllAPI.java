package PackageAccessQue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.LogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.j2objc.annotations.ReflectionSupport.Level;

public class AfterLoginAllAPI 
{

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		
		WebDriver mydriver = new ChromeDriver();
		mydriver.manage().window().maximize();
		Thread.sleep(2000);
		
				
		HttpURLConnection c=(HttpURLConnection)new URL("https://www.gradbusinesstest.accessque.com/document").openConnection();
				c.setRequestMethod("HEAD");
				c.connect();
				//int r = c.getResponseCode();
				String res=c.getResponseMessage();
				System.out.println(res);


	}
}
