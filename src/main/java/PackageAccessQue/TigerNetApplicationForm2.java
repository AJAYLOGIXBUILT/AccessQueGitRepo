package PackageAccessQue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.mashape.unirest.http.Unirest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.devtools.v104.network.Network;


public class TigerNetApplicationForm2 
{
	static WebDriver mydriver;

	@Test
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException
	{		
		//System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver mydriver = new ChromeDriver();

		//mydriver.get("https://accessque.com");
		mydriver.get("https://tigernet.campbellsville.edu/ICS/Apply/");
		mydriver.manage().window().maximize();
		Thread.sleep(3000);

		//Click on GRADUATE 
		mydriver.findElement(By.xpath("//body/div[@id='siteWrapper']/form[@id='MAINFORM']/div[@id='mainLayout']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[2]/li[1]/label[1]")).click();
		Thread.sleep(2000);

		//Click on CU REGINAL sub menu
		mydriver.findElement(By.xpath("//body/div[@id='siteWrapper']/form[@id='MAINFORM']/div[@id='mainLayout']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[2]/li[1]/ul[1]/li[2]/a[1]/div[1]")).click();
		Thread.sleep(3000);

		//Scroll down page 
		JavascriptExecutor js = (JavascriptExecutor) mydriver;
		js.executeScript("window.scrollBy(0,500)");

		//Click on CHECKBOX UNDERSTAND 
		mydriver.findElement(By.xpath("//input[@id='CheckBoxfd4f1b9a-6608-4ba9-ac0d-75bdb1b24117|Y']")).click();
		Thread.sleep(1000);

		//Click on START button 
		mydriver.findElement(By.xpath("//input[@id='Buttonf1ea8547-d4dd-442e-bcb9-8d338d676810']")).click();
		Thread.sleep(3000);

		//mydriver.close();		
		//NAME INFORMATION STEP 2 TAB

		WebElement fname =mydriver.findElement(By.xpath("//input[@id='Textbox2d2a1492-53dc-45ce-bfe7-2313a924c3b3']"));
		fname.sendKeys("TESTQA");

		WebElement lname =mydriver.findElement(By.xpath("//input[@id='Textboxc970d803-7f5d-4362-9dff-2bb8624363ba']"));
		lname.sendKeys("TEST");


		WebElement midname =mydriver.findElement(By.xpath("//input[@id='Textbox88c2720a-bf3e-4669-9609-e452d75495a0']"));
		midname.sendKeys("Q");

		// select Prefilx
		Select Prefx =new Select (mydriver.findElement(By.xpath("//select[@id='DropDown9f04df00-3567-49b0-97f8-dc40f9d5be69']")));
		Prefx.selectByVisibleText("Mr.");
		Thread.sleep(2000);

		//Preferred name 
		WebElement prefname =mydriver.findElement(By.xpath("//input[@id='Textbox1743a95f-c7b0-49c6-a3b7-02aaa6dd8758']"));
		prefname.sendKeys("TESTER");



		WebElement mobile =mydriver.findElement(By.xpath("//input[@id='Textbox58479ac0-4bbd-4ba7-ac6e-d540f59431fc']"));
		mobile.sendKeys("9090909090");

		WebElement email =mydriver.findElement(By.xpath("//input[@id='Textbox6e7315dc-8c5a-4c08-9362-81e627e6e5e3']"));
		email.sendKeys("ajaytestuser@spambox.xyz");
		Thread.sleep(2000);

		WebElement CnfEmail =mydriver.findElement(By.xpath("//input[@id='Textbox0d380c62-aa89-470b-a459-aba5dd90ff44']"));
		CnfEmail.sendKeys("ajaytestuser@spambox.xyz");
		Thread.sleep(2000);

		WebElement nxt1 =mydriver.findElement(By.xpath("//input[@id='Buttoncea6edc9-beb4-4465-8b12-40a49715fb73']"));
		nxt1.click();
		Thread.sleep(4000);

		//BIO GRPAHIC INFORMATION 
		bioGraphicInfo();
		Thread.sleep(4000);

		//ADDRESS INFORMATION STEP 4 TAB -//----YAHA TAK 
		myaddressInfo();
		Thread.sleep(5000);

		//CANDACY  CODE WILL BE HERE
		candacyInfo();
		Thread.sleep(5000);

		//ACEDEMIC INFO  CODE WILL BE HERE
		academicInfo();
		Thread.sleep(5000);

		acknowlegmentinfo();
		Thread.sleep(2000);
		
	}	
	//mydriver.close();


	public static void bioGraphicInfo() throws InterruptedException
	{
		//BIOGRAPHICAL INFRORMATION STEP 3 TAB		
		JavascriptExecutor jss = (JavascriptExecutor) mydriver;
		jss.executeScript("window.scrollBy(0,500)");

		//YES Citizen  
		WebElement radioBtnElementYES = mydriver.findElement(By.xpath("//input[@id='RadioButton5c3cce52-6b61-4a76-ae3c-95af1f8566a7|C']"));
		radioBtnElementYES.click();			
		boolean selectCitizenYES = radioBtnElementYES.isSelected();


		/*
		 * //NO Citizen WebElement radioBtnElementNO = mydriver.findElement(By.xpath(
		 * "//input[@id='RadioButton2aea8b98-72e1-4c81-91eb-ff8468507ff1|C']"));
		 * radioBtnElementNO.click(); boolean selectCitizenNO =
		 * radioBtnElementNO.isSelected();
		 * 
		 * System.out.println("CITIZEN="+selectCitizenYES+"     "+selectCitizenNO);
		 */

		if(selectCitizenYES == true) 
		{
			//radioBtnElement.click();
			WebElement SSNo =mydriver.findElement(By.xpath("//input[@id='Textbox58c2ae5d-ecde-48d0-b1f7-867f9cd870ad']"));
			SSNo.clear();
			SSNo.sendKeys("177123821");
			Thread.sleep(1000);


			WebElement male=mydriver.findElement(By.xpath("//input[@id='RadioButtonac1211ac-fb41-4627-a202-3e5bd155fc2f|M']"));
			male.click();
			Thread.sleep(1000);		


			//Click on calendar icon and open the Date Picker
			mydriver.findElement(By.xpath("//body/div[@id='siteWrapper']/form[@id='MAINFORM']/div[@id='mainLayout']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[3]/div[7]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")).click();
			Thread.sleep(1000);

			mydriver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")).click();
			Thread.sleep(1000);

			//---------------------------------------
			//Select Year first month and date 
			Select years =new Select(mydriver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")));
			years.selectByValue("1995");
			Thread.sleep(1000);


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

			//Select Region
			Select region = new Select(mydriver.findElement(By.xpath("//select[@id='DropDown91a32bdd-8596-4706-9438-3080cdc1465d']")));
			region.selectByValue("HIND");
			Thread.sleep(1000);


			//Marrital status 
			mydriver.findElement(By.xpath("//input[@id='RadioButton25065886-c716-4c7a-a1a4-505a80051f09|S']")).click();
			Thread.sleep(2000);


			WebElement Ethnicity=mydriver.findElement(By.xpath("//input[@id='RadioButton7adb9218-bee9-48da-9368-8d4c0bab3447|-2']"));
			Ethnicity.click();
			Thread.sleep(1000);

			WebElement Race =mydriver.findElement(By.xpath("//input[@id='CheckBox1c9f9c3b-765a-4c6c-80f3-c1f4269eecd1|-2']"));
			Race.click();

			WebElement nxt2 =mydriver.findElement(By.xpath("//input[@id='Buttonc552ba30-1154-4d7a-a450-4e99a9e72748']"));
			nxt2.click();
			Thread.sleep(5000);

		}
	}



		//ADDRESS INFORMATION CODE 
		public static void myaddressInfo() throws InterruptedException
		{
			//ADDRESS INFORMATION STEP 5 TAB
			JavascriptExecutor jssk = (JavascriptExecutor) mydriver;
			jssk.executeScript("window.scrollBy(0,500)");
			//Thread.sleep(2000);


			WebElement zip =mydriver.findElement(By.id("Textboxadf511a3-77b2-4d02-ac28-8cdd3f8b569e"));
			zip.sendKeys("440044");
			Thread.sleep(2000);

			WebElement myaddress =mydriver.findElement(By.id("Textbox57d1aeb3-0e22-46cc-844b-db10949092e7"));
			myaddress.sendKeys("99th floor, ANTALIA BUILDING ,NEW DELHI.");
			Thread.sleep(2000);

			WebElement mycity =mydriver.findElement(By.id("Textbox6061e8e5-33ea-43cd-9c22-8b69277d5e39"));
			mycity.sendKeys("Los Angeles");
			Thread.sleep(2000);

			//Select mystate = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown8958e8b9-43b0-46e5-878a-488bfe9b3f0c']")));
			Select mystate = new Select (mydriver.findElement(By.id("DropDownfb9ed6ce-a5c2-4a93-90f4-f0a4d68182ba")));
			mystate.selectByVisibleText("California");
			Thread.sleep(2000);

			//Select mycounty = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown3df7778f-9746-4fcb-9662-f3a17638ef47']")));
			Select mycounty = new Select (mydriver.findElement(By.id("DropDowne12d4e28-934e-4186-920f-c6797ba8039b")));
			mycounty.selectByVisibleText("UNITED STATES OF AMERICA");
			Thread.sleep(2000);


			WebElement nxt44 =mydriver.findElement(By.xpath("//input[@id='Buttonfa3a08f3-737a-45d8-94a5-57fd5cea39db']"));
			nxt44.click();
			Thread.sleep(5000);		

		}


		public static void  candacyInfo() throws InterruptedException
		{
			//CANDIDACY STEP 5 TAB
			JavascriptExecutor jss45 = (JavascriptExecutor) mydriver;
			jss45.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);		

			Select attend = new Select (mydriver.findElement(By.xpath("//select[@id='DropDownd503d966-8bbd-41f1-b75d-0704cff78abb']")));
			attend.selectByVisibleText("Louisville");
			Thread.sleep(2000);

			Select stdytYear = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown9a89fba0-a4d3-4f5a-a24d-d681fcbc5a57']")));
			stdytYear.selectByVisibleText("2023");
			Thread.sleep(3000);

			Select term = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown68679a50-b91d-4ca8-8b24-d6725a5ca7c0']")));
			term.selectByVisibleText("Graduate Term 6 2022-2023 -- Begin Date 05/08/2023");
			Thread.sleep(2000);

			Select program = new Select (mydriver.findElement(By.xpath("//select[@id='DropDowna6311d4e-65a3-4f69-ac2c-8514a00902e9']")));
			program.selectByVisibleText("M.S. in Computer Science *CPT Eligible*");
			Thread.sleep(2000);

			WebElement locat=mydriver.findElement(By.xpath("//input[@id='RadioButton65949256-479f-49b0-acf4-f3cdda34f2b2|L']"));
			locat.click();


			WebElement nxt55 =mydriver.findElement(By.xpath("//input[@id='Buttonccde2265-e973-484c-b410-5d6ffccf6b2b']"));
			nxt55.click();
			Thread.sleep(5000);	

		}


		public static void academicInfo() throws InterruptedException
		{
			//ACADAMIC INFORMATION on STEP 6 TAB
			JavascriptExecutor jss4 = (JavascriptExecutor) mydriver;
			jss4.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);

			Select stateInfo = new Select (mydriver.findElement(By.id("DropDownade2807b-75aa-4367-9acf-956d9f1c7730")));
			stateInfo.selectByVisibleText("California");
			Thread.sleep(2000);

			WebElement intstitute =mydriver.findElement(By.id("Textboxc58eb8d0-2814-4ab8-b747-591d97967e2c"));
			intstitute.sendKeys("IIT NEW DELHI");
			Thread.sleep(2000);

			Select degree = new Select (mydriver.findElement(By.id("DropDown55fad9d7-4629-441f-bb3e-c22cd621d57e")));
			degree.selectByVisibleText("Bachelor of Science");
			Thread.sleep(2000);

			//CLICK on ADD buttn
			WebElement graduate=mydriver.findElement(By.xpath("//input[@id='Buttonff9fcd29-f46d-49cb-8c11-91ca798ddb18']"));
			graduate.click();
			Thread.sleep(1000);

			//CLICK on ADD buttn
			WebElement next66=mydriver.findElement(By.xpath("//input[@id='Button407c1a9c-52e0-458a-9f74-09e8a3294cbb']"));
			next66.click();
			Thread.sleep(5000);
		}	

		public static void acknowlegmentinfo() throws InterruptedException
		{
			//ACKNOWLEDGEMENT STEPS 9 TAB


			WebElement felonyYES=mydriver.findElement(By.xpath("//input[@id='RadioButtonc3f1ad90-0e8c-4d05-b7c3-ab38a7856c7b|Y']"));
			felonyYES.click();
			Thread.sleep(2000);	

			WebElement felonyExpln=mydriver.findElement(By.xpath("//textarea[@id='Essaycec01985-5827-447a-ab1e-f7a109ff409b']"));
			felonyExpln.sendKeys("Philadelphia's new Ordinance prohibits any covered employer, either in an application or during a first interview,");
			Thread.sleep(2000);	

			WebElement checkbox=mydriver.findElement(By.xpath("//input[@id='CheckBox5dfbfbd0-429d-4582-ab64-e5a053f051cb|By checking this box, I have thoroughly read and acknowledge that the financial documentation I have submitted meets the requirements as defined to me in item 1.(A) and (B).']"));
			checkbox.click();
			Thread.sleep(2000);	


			WebElement felonyAgree=mydriver.findElement(By.xpath("//input[@id='CheckBoxd75d027e-b984-489a-9d22-0f8eb1a39919|Y']"));
			felonyAgree.click();
			Thread.sleep(2000);	


			WebElement FinaSubmit=mydriver.findElement(By.xpath("//input[@id='Buttonb336e053-6ddd-4b0d-af49-711fb146e3a0']"));
			FinaSubmit.click();
			Thread.sleep(8000);	

			//REDIRCTED FROM HERE ON GRADBUSINESS 		
			String strUrl = mydriver.getCurrentUrl();
			System.out.println("GRABUSINESS URL IS ="+strUrl);
			Thread.sleep(8000);	

		}	
	}
