package PackageAccessQue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TigerNetApplicationForm 
{
	
	@Test
	public static void main(String[] args) throws InterruptedException
	{		
		//System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver mydriver = new ChromeDriver();
				
		//mydriver.get("https://accessque.com");
		mydriver.get("https://tigernet.campbellsville.edu/ICS/Apply/");
		mydriver.manage().window().maximize();
		Thread.sleep(3000);
		
		mydriver.findElement(By.xpath("//body/div[@id='siteWrapper']/form[@id='MAINFORM']/div[@id='mainLayout']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[2]/li[1]/label[1]")).click();
		Thread.sleep(2000);
				
		mydriver.findElement(By.xpath("//body/div[@id='siteWrapper']/form[@id='MAINFORM']/div[@id='mainLayout']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[2]/li[1]/ul[1]/li[1]/a[1]/div[1]")).click();
		Thread.sleep(3000);
		
        JavascriptExecutor js = (JavascriptExecutor) mydriver;
		js.executeScript("window.scrollBy(0,450)");
		
		
		mydriver.findElement(By.xpath("//input[@id='CheckBox2947d5c1-5d40-4f45-92d8-303eeedafcad|Y']")).click();
		Thread.sleep(1000);
		
		mydriver.findElement(By.xpath("//input[@id='Button691e8b08-2f58-40ec-b864-aca7e58b2928']")).click();
		Thread.sleep(3000);
		
		//mydriver.close();		
		//NAME INFORMATION STEP 2 TAB
		
		WebElement fname =mydriver.findElement(By.xpath("//input[@id='Textbox1a693b98-224c-4773-93a9-e529538f7adc']"));
		fname.sendKeys("QA");
		
		WebElement lname =mydriver.findElement(By.xpath("//input[@id='Textbox01cd5d7a-d97a-4486-bf62-2f211086340c']"));
		lname.sendKeys("TESTER");

		
		WebElement midname =mydriver.findElement(By.xpath("//input[@id='Textbox28596d2e-5a32-4522-bcd1-39c977ad8182']"));
		midname.sendKeys("Q");
		
		// select Prefilx
		Select Prefx =new Select (mydriver.findElement(By.xpath("//select[@id='DropDown50180f12-36be-40d9-a6b3-c125baa47b14']")));
		Prefx.selectByVisibleText("Mr.");
		Thread.sleep(2000);
		
		WebElement prefname =mydriver.findElement(By.xpath("//input[@id='Textboxcb0caf52-ddec-4a70-9b0b-d7fe3857bfc1']"));
		prefname.sendKeys("TESTER");
				
		WebElement mobile =mydriver.findElement(By.xpath("//input[@id='Textbox88e622ce-df23-43e8-a242-2601d5bde31d']"));
		mobile.sendKeys("9090909090");
		
		WebElement email =mydriver.findElement(By.xpath("//input[@id='Textbox87fe3607-c35c-462e-ba7c-89177e1741b3']"));
		email.sendKeys("ajaytestuser@spambox.xyz");
		Thread.sleep(2000);
		
		WebElement CnfEmail =mydriver.findElement(By.xpath("//input[@id='Textbox5711a5b6-37a3-46c8-8412-be21850fb3ca']"));
		CnfEmail.sendKeys("ajaytestuser@spambox.xyz");
		Thread.sleep(2000);
		
		WebElement nxt1 =mydriver.findElement(By.xpath("//input[@id='Button7a3f1af0-fafc-463a-afcb-1042dba8add7']"));
		nxt1.click();
		Thread.sleep(4000);
		
		//BIOGRAPHICAL INFRORMATION STEP 3 TAB
		
		JavascriptExecutor jss = (JavascriptExecutor) mydriver;
		jss.executeScript("window.scrollBy(0,450)");
		
		// USA CITIZEN YES  
		WebElement ctzn=mydriver.findElement(By.xpath("//input[@id='RadioButton2aea8b98-72e1-4c81-91eb-ff8468507ff1|C']"));
		ctzn.click();
		Thread.sleep(1000);
		
		//WebElement ctzn=mydriver.findElement(By.xpath("//input[@id='RadioButton2aea8b98-72e1-4c81-91eb-ff8468507ff1|N']"));
		//ctzn.click();
		
		WebElement SSNo =mydriver.findElement(By.xpath("//input[@id='Textbox8ec8076d-120c-480d-803c-287c466af729']"));
		SSNo.clear();
		SSNo.sendKeys("177123821");
		Thread.sleep(1000);
		
		WebElement male=mydriver.findElement(By.xpath("//input[@id='RadioButtone13705b4-abf7-464f-a33c-2ae2f11acd39|M']"));
		male.click();
		Thread.sleep(1000);		
		
		
		//Click on calendar icon and open the Date Picker
		mydriver.findElement(By.xpath("//body/div[@id='siteWrapper']/form[@id='MAINFORM']/div[@id='mainLayout']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[3]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")).click();
		Thread.sleep(1000);

		mydriver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")).click();
		Thread.sleep(1000);
		
		//Select Year first 
		Select years =new Select(mydriver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")));
		years.selectByValue("1995");
		Thread.sleep(1000);
		
		//----------------------------------------
		String Currentmonthname = mydriver.findElement(By.xpath("//span[contains(text(),'August')]")).getText();
		String expectedTitle = "August"; //We can change here according to month
				
		//Assert.assertEquals(Currentmonthname,"August");
		
		System.out.println("MONTH NAME =" +Currentmonthname);
		
		if(Currentmonthname.equals(expectedTitle))
		{
			System.out.println("MONTH NAME =" +Currentmonthname);
			//Click once to go back on JULY 
			mydriver.findElement(By.xpath("//span[contains(text(),'Prev')]")).click();
			
			//Select Date 
			mydriver.findElement(By.xpath("//a[contains(text(),'17')]")).click();
			Thread.sleep(1000);
			
		}
		else
		{
			System.out.println("CURRENT MONTH IS NOT AUGUST");
		}	
		
		//----------------------------------------
		
					
		//Marrital status 
		mydriver.findElement(By.xpath("//input[@id='RadioButton456ffce8-b076-4d9f-8ff5-3b3b93def15f|S']")).click();
		Thread.sleep(2000);
		
		//mydriver.findElement(By.xpath("//select[@id='DropDowne0def3d0-45b2-45fb-9207-baae3573e682']")).click();
		Select region = new Select(mydriver.findElement(By.xpath("//select[@id='DropDowne0def3d0-45b2-45fb-9207-baae3573e682']")));
		region.selectByValue("HIND");
		Thread.sleep(1000);
		
		WebElement Ethnicity=mydriver.findElement(By.xpath("//input[@id='RadioButton849963e4-a422-45de-ab26-652b97f75b3c|-2']"));
		Ethnicity.click();
		Thread.sleep(1000);
		
		WebElement Race =mydriver.findElement(By.xpath("//input[@id='CheckBox65904fca-dd77-492d-8cff-417cde544d87|-2']"));
		Race.click();
		
		WebElement nxt2 =mydriver.findElement(By.xpath("//input[@id='Button884d1f48-8859-4a6c-9b3f-1c13e436f1b3']"));
		nxt2.click();
		Thread.sleep(4000);
		
		//ADDRESS INFORMATION STEP 4 TAB
		JavascriptExecutor jssk = (JavascriptExecutor) mydriver;
		jssk.executeScript("window.scrollBy(0,400)");
		//Thread.sleep(2000);
		
		//Select mycounty = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown3df7778f-9746-4fcb-9662-f3a17638ef47']")));
		Select mycounty = new Select (mydriver.findElement(By.id("DropDown3df7778f-9746-4fcb-9662-f3a17638ef47")));
		mycounty.selectByVisibleText("UNITED STATES OF AMERICA");
		Thread.sleep(2000);
		
		//Select mystate = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown8958e8b9-43b0-46e5-878a-488bfe9b3f0c']")));
		Select mystate = new Select (mydriver.findElement(By.id("DropDown8958e8b9-43b0-46e5-878a-488bfe9b3f0c")));
		mystate.selectByVisibleText("California");
		Thread.sleep(2000);
		
		WebElement mycity =mydriver.findElement(By.xpath("//input[@id='Textbox2960223c-1f16-40ff-b422-64b06118b9b7']"));
		mycity.sendKeys("Los Angeles");
		Thread.sleep(2000);
	
		WebElement myaddress =mydriver.findElement(By.xpath("//input[@id='Textbox3dec4b57-8915-4c94-a81c-6ffdf2a0192a']"));
		myaddress.sendKeys("65th floor, LODHA BUILDING , MUMVAI.");
		Thread.sleep(2000);
		
		WebElement zip =mydriver.findElement(By.xpath("//input[@id='Textbox3dec4b57-8915-4c94-a81c-6ffdf2a0192a']"));
		zip.sendKeys("400047");
		Thread.sleep(2000);
		
		WebElement nxt3 =mydriver.findElement(By.xpath("//input[@id='Button4683f16b-6d19-4174-a1e7-bc57b8692e86']"));
		nxt3.click();
		Thread.sleep(4000);
		
		//CANDIDACY STEP 5 TAB
		JavascriptExecutor jss45 = (JavascriptExecutor) mydriver;
		jss45.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);		
		
		Select enrollyear = new Select (mydriver.findElement(By.xpath("//select[@id='DropDownb0889429-231a-4008-89b7-baba3dfe3b85']")));
		enrollyear.selectByVisibleText("August 2022 - July 2023");
		Thread.sleep(2000);
		
		Select enrollTerm = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown041b0863-977b-4ab7-bf18-8873d89aa0dd']")));
		enrollTerm.selectByVisibleText("Graduate Term 6 2022-2023 -- Begin Date 05/08/2023");
		Thread.sleep(2000);
				
		Select Programenroll = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown54b48398-e0c6-4822-a687-d919c6caf4aa']")));
		Programenroll.selectByVisibleText("Master of Science in Information Technology Mgmt");
		Thread.sleep(2000);
		
		WebElement agency=mydriver.findElement(By.xpath("//input[@id='RadioButtonb5eb5e32-310c-4a8a-a056-88a521942150|Y']"));
		agency.click();
		
		
		WebElement nxt4 =mydriver.findElement(By.xpath("//input[@id='Buttone3c2d967-59c3-4fc9-a662-5f0f6888e9b7']"));
		nxt4.click();
		Thread.sleep(4000);
				
		//ACADAMIC INFORMATION
		JavascriptExecutor jss4 = (JavascriptExecutor) mydriver;
		jss4.executeScript("window.scrollBy(0,450)");
		Thread.sleep(1000);
				
		Select stateInfo = new Select (mydriver.findElement(By.id("DropDown9de5914a-37b2-4f92-9694-0f52761fa0ec")));
		stateInfo.selectByVisibleText("California");
		Thread.sleep(2000);
		
		WebElement intstitute =mydriver.findElement(By.id("Textbox72e1a8ca-dc3b-4a68-abb8-95ab17c968a7"));
		intstitute.sendKeys("IIT MUMBAI");
		Thread.sleep(2000);
		
		Select degree = new Select (mydriver.findElement(By.id("DropDown3ed5549d-307a-41ed-b577-2227e7c8ea92")));
		degree.selectByVisibleText("Bachelor of Science");
		Thread.sleep(2000);
				
		WebElement graduate=mydriver.findElement(By.xpath("//input[@id='RadioButtonee6865b3-673e-444d-a5c3-be76eebe4ace|Y']"));
		graduate.click();
		Thread.sleep(1000);
		
		//Graduation date 
		//Select Year first 		
		
		mydriver.findElement(By.xpath("//body/div[@id='siteWrapper']/form[@id='MAINFORM']/div[@id='mainLayout']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[7]/div[9]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")).click();
		Thread.sleep(1000);
		
		Select gyears =new Select(mydriver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")));
		gyears.selectByValue("2015");
		Thread.sleep(1000);
		
		//----------------------------------------
		String GCurrentmonthname = mydriver.findElement(By.xpath("//span[contains(text(),'August')]")).getText();
		String GexpectedTitle = "August"; //We can change here according to month
				
		//Assert.assertEquals(GCurrentmonthname,"August");
		System.out.println("MONTH NAME =" +GCurrentmonthname);
		
		if(GCurrentmonthname.equals(GexpectedTitle))
		{
			System.out.println("MONTH NAME =" +GCurrentmonthname);
			//Click once to go back on JULY 
			mydriver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Thread.sleep(1000);
			mydriver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Thread.sleep(1000);
			mydriver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Thread.sleep(1000);
			mydriver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Thread.sleep(1000);
						
			//Select Date 
			mydriver.findElement(By.xpath("//a[contains(text(),'31')]")).click();
			Thread.sleep(1000);			
		}
		else
		{
			System.out.println("CURRENT MONTH IS NOT AUGUST");
		}	
		
		//WebElement Addbtn=mydriver.findElement(By.xpath("//input[@id='Buttonc461c9c0-6aba-48d7-870f-50b75e61f62e']"));
		//Addbtn.click();
		
		//mydriver.close();
		
	}

	
}
