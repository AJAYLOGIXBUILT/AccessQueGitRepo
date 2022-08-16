package PackageAccessQue;

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

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
				
		
		WebDriver driver;
	    Properties prop;

	    public AfterLoginAllAPI2() 
	    {

	        prop = null;
	        try {
	            FileInputStream ip = new FileInputStream("E:\\Nitin_Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");

	            prop.load(ip);

	        } catch (FileNotFoundException e) {

	            e.printStackTrace();
	        } catch (IOException e) {

	            e.printStackTrace();
	        }   

	    }

	    public static void initialization(){

	        String browserName = prop.getProperty("browser");
	        String chromePath = prop.getProperty("chromePath");
	        String FFPath = prop.getProperty("FFPath");

	        if(browserName.equals("chrome")){

	            System.setProperty("webdriver.chrome.driver", chromePath);
	            driver = new ChromeDriver();
	        }else if(browserName.equals("FireFox")){

	            System.setProperty("webdriver.chrome.driver", FFPath);
	            driver = new FirefoxDriver();
	        }

	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	        driver.get(prop.getProperty("url"));

	    }


	}
}
