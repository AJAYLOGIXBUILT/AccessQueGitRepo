package PackageAccessQue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.DataProvider;

public class LoginTestCases
{
	@Test(dataProvider="LoginCrdes")
	public void loginCondtions(String Scenario, String Email, String Passowrd) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver ajdriver= new ChromeDriver();

		ajdriver.get("https://services.accessque.com/account/login");
		ajdriver.manage().window().maximize();
		Thread.sleep(2000);

		ajdriver.findElement(By.id("email")).sendKeys(Email);
		ajdriver.findElement(By.id("password")).sendKeys(Passowrd);
		ajdriver.findElement(By.xpath("//button[contains(text(),'Log In')]")).click();

		//Login Test cases

		if(Scenario.equals("BothCorrect"))
		{

			WebElement leadDash = ajdriver.findElement(By.cssSelector("//label[contains(text(),'Projects')]"));
			Assert.assertTrue(leadDash.isDisplayed());

		}
		else if(Scenario.equals("BothINCorrect"))
		{
			String Errmsg = ajdriver.findElement(By.xpath("//ngb-alert[contains(text(),'Invalid Username or Password')]")).getText();
			Assert.assertEquals(Errmsg,"Invalid Username or Password");

		}

		else if(Scenario.equals("CorrectEMAIL"))
		{
			String Errmgs = ajdriver.findElement(By.xpath("//ngb-alert[contains(text(),'Invalid Username or Password')]")).getText();
			Assert.assertEquals(Errmgs,"Invalid Username or Password");

		}
		else
		{
			String Errmgs = ajdriver.findElement(By.xpath("//ngb-alert[contains(text(),'Invalid Username or Password')]")).getText();
			Assert.assertEquals(Errmgs,"Invalid Username or Password");

		}	
	}

	@DataProvider(name="LoginCrdes")
	public Object[][] getData()
	{
		return new Object[][]
		{
			{"BothCorrect","admin.uh@accessque.com","University@Hub1"},
			{"BothINCorrect","admih@accessque.com","UniversityHub1"},
			{"CorrectEMAIL","admin.uh@accessque.com","UniversityHub1"},
			{"CorrectPassword","admin@accessque.com","University@Hub1"}
		};
	}
}

