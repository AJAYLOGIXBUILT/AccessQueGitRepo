package PackageAccessQue;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TigerNetApplicationFormSubmit 
{

	@Test
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException, NoSuchFieldException, SecurityException
	{		
		//System.setProperty("webdriver.chrome.driver","E:\\A\\SOFTWARE\\ChromeDriver\\ChromeDriver104\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver mydriver = new ChromeDriver();
		
		

		mydriver.manage().deleteAllCookies();
		Thread.sleep(3000);

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
		System.out.println("INSTRUCTION STEP EXECUTED SUCCESSFULLY ");

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
		Thread.sleep(2000);


		WebElement mobile =mydriver.findElement(By.xpath("//input[@id='Textbox58479ac0-4bbd-4ba7-ac6e-d540f59431fc']"));
		mobile.clear();
		mobile.sendKeys("8527834284");  //8527834283 mobile number is EMPTY NOW
		Thread.sleep(2000);
		

		WebElement email =mydriver.findElement(By.xpath("//input[@id='Textbox6e7315dc-8c5a-4c08-9362-81e627e6e5e3']"));
		email.sendKeys("testajaytestuser@spambox.xyz");
		Thread.sleep(2000);

		WebElement CnfEmail =mydriver.findElement(By.xpath("//input[@id='Textbox0d380c62-aa89-470b-a459-aba5dd90ff44']"));
		CnfEmail.sendKeys("testajaytestuser@spambox.xyz");  //testajaytestuser@spambox.xyz
		Thread.sleep(2000);

		WebElement nxt1 =mydriver.findElement(By.xpath("//input[@id='Buttoncea6edc9-beb4-4465-8b12-40a49715fb73']"));
		nxt1.click();
		System.out.println("NAME INFORMATION EXECUTED SUCCESSFULLY ");
		Thread.sleep(5000);		
		
		
		
		//BIO GRAPHIC TEST 
		JavascriptExecutor jss = (JavascriptExecutor) mydriver;
		jss.executeScript("window.scrollBy(0,450)");

		//NO  Citizen  
		WebElement radioBtnElementNO = mydriver.findElement(By.xpath("//input[@id='RadioButton5c3cce52-6b61-4a76-ae3c-95af1f8566a7|N']"));
		radioBtnElementNO.click();			
		boolean selectCitizenNO = radioBtnElementNO.isSelected();
		
		//NO  reside in the US
		WebElement residUSANo = mydriver.findElement(By.xpath("//input[@id='RadioButton8fde6ddc-8d10-4e69-aeba-cd7df3a21073|N']"));
		residUSANo.click();			
		//boolean selectCitizenYES = residUSA.isSelected();

	
		if(selectCitizenNO == true) 
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
			Thread.sleep(2000);

			mydriver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")).click();
			Thread.sleep(2000);

			//---------------------------------------
			//Select Year first month and date 
			Select years =new Select(mydriver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/div[1]/select[1]")));
			years.selectByValue("1995");
			Thread.sleep(2000);

			String Currentmonthname = mydriver.findElement(By.xpath("//span[contains(text(),'September')]")).getText();
			String expectedTitle = "September"; //We can change here according to month

			//Assert.assertEquals(Currentmonthname,"August");

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
				System.out.println("CURRENT MONTH IS NOT SEPTEMBER");
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
			System.out.println("BIOGRAPHICAL INFORMATION  EXECUTED SUCCESSFULLY ");
		
		
			//ADDRESS INFORMATION STEP 5 TAB
			JavascriptExecutor jssk = (JavascriptExecutor) mydriver;
			jssk.executeScript("window.scrollBy(0,500)");
			//Thread.sleep(2000);
			
			//Select mycounty = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown3df7778f-9746-4fcb-9662-f3a17638ef47']")));
			Select mycounty = new Select (mydriver.findElement(By.id("DropDown81d63c5c-2f28-4b68-9f1f-7479f282d777")));
			mycounty.selectByVisibleText("INDIA");
			Thread.sleep(2000);
			
			// Address 
			WebElement myaddress =mydriver.findElement(By.id("Textbox932eaa17-ff3a-4977-9f63-1b343b732edf"));
			myaddress.sendKeys("99th floor, ANTALIA BUILDING ,NEW DELHI.");
			Thread.sleep(2000);
			
			//City name
			 WebElement mycty=mydriver.findElement(By.id("Textbox56639ea0-e8a0-4e11-8e37-15dfde660076"));
			 mycty.sendKeys("New Delhi");
			 Thread.sleep(2000);
			 mycty.sendKeys(Keys.ARROW_DOWN);
			 Thread.sleep(2000);
			 mycty.sendKeys(Keys.ENTER);
			 Thread.sleep(2000);
			 
			//Select mystate = new Select (mydriver.findElement(By.xpath("//select[@id='DropDown8958e8b9-43b0-46e5-878a-488bfe9b3f0c']")));
			WebElement mystate=mydriver.findElement(By.id("Textbox1602acde-763e-404d-ab39-b8ab8412d1ac"));
			mystate.sendKeys("California");
			Thread.sleep(2000);
			mystate.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			mystate.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			

			WebElement zip =mydriver.findElement(By.id("Textbox8103f6fb-43c9-4a2b-b86d-13c2d0d7749c"));
			zip.sendKeys("110012");
			Thread.sleep(2000);

			WebElement nxt44 =mydriver.findElement(By.id("Button1b35b75f-159d-4c05-bc65-290e2ba86f8a"));
			nxt44.click();
			Thread.sleep(5000);	
			
			System.out.println("ADDRESS INFORMATION EXECUTED SUCCESSFULLY ");
			
			
			//CANDIDACY STEP 5 TAB
			JavascriptExecutor jss45 = (JavascriptExecutor) mydriver;
			jss45.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);		

			Select attend = new Select (mydriver.findElement(By.xpath("//select[@id='DropDownd503d966-8bbd-41f1-b75d-0704cff78abb']")));
			attend.selectByVisibleText("Louisville");
			Thread.sleep(2000);

			Select stdytYear = new Select (mydriver.findElement(By.id("DropDown9a89fba0-a4d3-4f5a-a24d-d681fcbc5a57")));
			stdytYear.selectByVisibleText("2022");
			Thread.sleep(3000);

			Select term = new Select (mydriver.findElement(By.id("DropDown68679a50-b91d-4ca8-8b24-d6725a5ca7c0")));
			term.selectByVisibleText("Graduate Term 6 2022-2023 -- Begin Date 05/08/2023");
			Thread.sleep(2000);

			Select program = new Select (mydriver.findElement(By.id("DropDowna6311d4e-65a3-4f69-ac2c-8514a00902e9")));
			program.selectByVisibleText("Master of Science in Information Technology Mgmt *CPT Eligible*");
			Thread.sleep(2000);

			WebElement locat=mydriver.findElement(By.xpath("//input[@id='RadioButton65949256-479f-49b0-acf4-f3cdda34f2b2|L']"));
			locat.click();
			Thread.sleep(2000);
			
			WebElement nxt55 =mydriver.findElement(By.xpath("//input[@id='Buttonccde2265-e973-484c-b410-5d6ffccf6b2b']"));
			nxt55.click();
			System.out.println("CANDIDACY EXECUTED SUCCESSFULLY ");
			Thread.sleep(5000);	
		
			
			
			
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
			
			//CLICK on NEXT  buttn
			WebElement next66=mydriver.findElement(By.xpath("//input[@id='Button407c1a9c-52e0-458a-9f74-09e8a3294cbb']"));
			next66.click();
			Thread.sleep(5000);
			
			mydriver.switchTo().alert().accept();
			Thread.sleep(1000);
					
			//INTERNATIONAL INFOMATION 
			JavascriptExecutor jss7 = (JavascriptExecutor) mydriver;
			jss7.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);
			
			Select ctzcntry = new Select (mydriver.findElement(By.id("DropDownd2844d6a-df40-4279-b531-afaba06b4792")));
			ctzcntry.selectByVisibleText("INDIA");
			Thread.sleep(2000);
			
			Select BirthCntry = new Select (mydriver.findElement(By.id("DropDown1d8fc564-41ef-4228-958e-5f24c47a53db")));
			BirthCntry.selectByVisibleText("INDIA");
			Thread.sleep(2000);
			
			WebElement cityBirth = mydriver.findElement(By.id("Textboxf679d336-f406-447f-9bec-1707765e6c73"));
			cityBirth.sendKeys("PUNE");
			Thread.sleep(2000);
			
			//NO VISA NOW
			WebElement novisa = mydriver.findElement(By.id("RadioButtona8d57992-c397-4a1a-9145-b9a1d5d989cc|N"));
			novisa.click();
			Thread.sleep(2000);
			
			WebElement SevisID = mydriver.findElement(By.id("Textbox31b08695-3c74-4b6d-97a4-65ed0346901f"));
			SevisID.sendKeys("N123456789");
			Thread.sleep(2000);
			
			WebElement noDepend = mydriver.findElement(By.id("RadioButton8e43e563-1bf0-4eb7-9852-9ae5f106842a|N"));
			noDepend.click();
			Thread.sleep(2000);
						
			WebElement agency = mydriver.findElement(By.id("RadioButton8367c5e1-b017-418d-a707-4289167cca8f|Y"));
			agency.click();
			Thread.sleep(2000);
			
			
			WebElement agencyName = mydriver.findElement(By.id("Textbox57b92e45-8a27-4d58-840f-6175d142e515"));
			agencyName.sendKeys("CampbellsVille Hydrabad Agency");
			Thread.sleep(2000);
			
			
			WebElement agencyLastName = mydriver.findElement(By.id("Textboxe1e1be7b-3512-42af-aa74-65047644a457"));
			agencyLastName.sendKeys("CAMPBELLSVILLE");
			Thread.sleep(2000);
			
			WebElement agencyfirstName = mydriver.findElement(By.id("Textboxc97b3089-f0b3-4aa5-8094-f595997841e7"));
			agencyfirstName.sendKeys("AGENCY");
			Thread.sleep(2000);
			
			
			WebElement contactNo = mydriver.findElement(By.id("Textboxdc6677c0-67a7-406d-b002-d677ec27d51e"));
			contactNo.sendKeys("9652949578");
			Thread.sleep(2000);
			
			
			WebElement recrtrEmail = mydriver.findElement(By.id("Textbox3f92817a-482b-4bd4-9af3-62751ba4e218"));
			recrtrEmail.sendKeys("agencyrecruiter1@spambox.xyz");
			Thread.sleep(2000);
			
			WebElement next77 = mydriver.findElement(By.id("Button6da4d09e-eca8-4dae-8dbf-87f62a630781"));
			next77.click();
			Thread.sleep(5000);
			System.out.println("ACADEMIC INFORMATION EXECUTED SUCCESSFULLY ");
						
			
			//ACKNOWLEDGEMENT STEPS 9 TAB
			WebElement felonyYES=mydriver.findElement(By.id("RadioButtonc3f1ad90-0e8c-4d05-b7c3-ab38a7856c7b|Y"));
			felonyYES.click();
			Thread.sleep(2000);	

			WebElement felonyExpln=mydriver.findElement(By.id("Essaycec01985-5827-447a-ab1e-f7a109ff409b"));
			felonyExpln.sendKeys("Philadelphia's new Ordinance prohibits any covered employer, either in an application or during a first interview,");
			Thread.sleep(2000);	

			WebElement checkbox=mydriver.findElement(By.xpath("//input[@id='CheckBox5dfbfbd0-429d-4582-ab64-e5a053f051cb|By checking this box, I have thoroughly read and acknowledge that the financial documentation I have submitted meets the requirements as defined to me in item 1.(A) and (B).']"));
			checkbox.click();
			Thread.sleep(2000);	

			WebElement felonyAgree=mydriver.findElement(By.id("CheckBoxd75d027e-b984-489a-9d22-0f8eb1a39919|Y"));
			felonyAgree.click();
			Thread.sleep(2000);	
			
			//CLOSE HERE 
			//mydriver.close();
			
			WebElement FinalSubmit=mydriver.findElement(By.id("Buttonb336e053-6ddd-4b0d-af49-711fb146e3a0"));
			FinalSubmit.click();
			//Thread.sleep(15000);
			
				try
				{
					WebElement actulerror=mydriver.findElement(By.xpath("//body/div[@id='siteWrapper']/form[@id='MAINFORM']/div[@id='mainLayout']/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]"));		
					System.out.println("ERROR MESSAGE ="+actulerror);
					String erromessg="Please answer all required questions before submitting the form.";
				
					if(actulerror.equals(erromessg))
					{
						System.out.println("SOME OF REQUIRED FIELDS ARE MISSING INSIDE FORM,PLEASE CHECK ALL REQUIRED FIELDS ONCE TO MOVE ON NEXT PAGE !");
						//CLOSE HERE 
						//mydriver.close();
					}
				}
				catch(Exception e)
				{
					System.out.println("SOME REQUIRED FIELDS ARE MISSING,PLEASE CHECK ONCE !"); 
				}
		
				Thread.sleep(15000);
			}
		
		
		//REDIRCTED ON GRADBUSINESS 		
		String strUrl = mydriver.getCurrentUrl();
		System.out.println("GRABUSINESS URL IS ="+strUrl);
		System.out.println("APPLICATION FORM SUBMITTED SUCCESSFULLY");
		Thread.sleep(15000);	
		
		//3rd leads URL live
		//GRABUSINESS URL IS =https://tigernet.campbellsville.edu/ICS/Apply/Apply_Now.jnz?portlet=EX_FormFlow_-_Forms&screen=FormView&screenType=change&form=49c44628-1423-46e0-bf97-568bd4e34a07
	
		//Call gradbussiness method	
		//MyNewSite calltograd=new MyNewSite();
		//calltograd.gradUploadFile();
	
		//uploadFileBachlor(); 
		Thread.sleep(2000);
		System.out.println("GRADBUSSINESS METHOD CALLED SUCCESSFULLY");
		
		//GRABUSINESS URL IS =https://tigernet.campbellsville.edu/ICS/Apply/Apply_Now.jnz?portlet=EX_FormFlow_-_Forms&screen=FormView&screenType=change&form=49c44628-1423-46e0-bf97-568bd4e34a07
		//GUID =49c44628-1423-46e0-bf97-568bd4e34a07
		
		//mydriver.get("https://www.gradbusiness.campbellsville.edu/redirect/519dd26b-9ad9-4f6c-9a94-771a8d5fb992/ITM/N");
	//mydriver.get("https://www.gradbusiness.campbellsville.edu/redirect/84d08f99-2c5d-4961-889b-6c76d5fe3007/ITM/N");
		//89400ce8-e3ac-4f6e-87eb-dda5a9c8b4a9
		//MyNewSite mns = new MyNewSite();
		//mns.gradUploadFile(mydriver);
		
		mydriver.navigate().refresh();
		
		
		//SessionId gradsession = ((RemoteWebDriver) mydriver).getSessionId();
	    //System.out.println("Session Id is for method1: " + gradsession);
	    Thread.sleep(3000);
		
		//REDIRCTED ON GRADBUSINESS 		
		String strUrl1 = mydriver.getCurrentUrl();
		System.out.println("GRABUSINESS URL IS ="+strUrl1);
		Thread.sleep(4000);
				
			ArrayList<String> arlTest = new ArrayList<String>();
			  //Size of arrayList
			  System.out.println("Size of ArrayList Before: " + arlTest.size());
			  //Lets add some elements to it
			  arlTest.add("Bachelors Transcript");
			  arlTest.add("Credential Evaluation");
			  arlTest.add("Masters Transcript");
			  arlTest.add("English Proficiency ");
			  arlTest.add("I-20");

			  System.out.println(arlTest);
			  System.out.println("NEW Size of ArrayList After: " + arlTest.size());
			  
			  //for(WebElement myele:arlTest)
			  for (int j = 0;j <1 ; j++)
			  {
				//try
				//{
					//System.out.println("List of Array elements: " + arlTest.get(j));
									
					//Click on ADD FILE BUTTON and Uploaded BECHELOR DOC file 
					//WebElement BacTrn=mydriver.findElement(By.xpath("//td[text()=' Bachelors Transcript ']//following-sibling::td/following-sibling::td/button"));
				  String bechlorText=mydriver.findElement(By.xpath("//td[text()=' Bachelors Transcript ']")).getText();
				  String ActBechText ="Bachelors Transcript";
				  if(bechlorText.equals(ActBechText))
				  {
							mydriver.findElement(By.xpath("//td[text()=' Bachelors Transcript ']//following-sibling::td/following-sibling::td/button[1]//img")).click();
							Thread.sleep(4000);
							//mydriver.findElement(By.xpath("//td[contains(text(),' Bachelors Transcript ')]//following-sibling::td//button[1]")).click();
						
							WebElement BachlorTrnscpt= mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
							BachlorTrnscpt.sendKeys("E:\\A\\Dummy_Images\\mex2.jpg"); //Uploading the file using sendKeys
							Thread.sleep(5000);
							//Click on Upload button 
							mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
							Thread.sleep(5000);
							
							System.out.println("Bachelor Documents Uploaded Successfully");
							mydriver.navigate().refresh();
							Thread.sleep(2000);
						
						}
						
						String credText=mydriver.findElement(By.xpath("//td[text()=' Credential Evaluation ']")).getText();
						String actCredText ="Credential Evaluation";
						if(credText.equals(actCredText))
						{
						
							//Click on ADD FILE BUTTON and Uploaded Credential Evaluation file 
							WebElement CredEve=mydriver.findElement(By.xpath("//td[text()=' Credential Evaluation ']//following-sibling::td/following-sibling::td/button[1]//img"));
							CredEve.click();
							Thread.sleep(2000);
							//WebElement CredEvoDoc = mydriver.findElement(By.xpath("/html[1]/body[1]/ngb-modal-window[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]"));
							WebElement CredEvoDoc = mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
							CredEvoDoc.sendKeys("E:\\A\\Dummy_Images\\b4.jpg"); //Uploading the file using sendKeys
							Thread.sleep(5000);				
							//Click on Upload button 
							mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
							Thread.sleep(5000);
							System.out.println("Credential Evaluation Documents Uploaded Successfully");
							mydriver.navigate().refresh();
							Thread.sleep(2000);
						}
							
						
						String mstText=mydriver.findElement(By.xpath("//td[text()=' Masters Transcript ']")).getText();
						String ActMstText ="Masters Transcript";
						if(mstText.equals(ActMstText))
						{
						
							//Click on ADD FILE BUTTON and Upload MASTER TRANSCRPT Doc 
							WebElement masTrn=mydriver.findElement(By.xpath("//td[text()=' Masters Transcript ']//following-sibling::td/following-sibling::td/button[1]//img"));
							masTrn.click();
							Thread.sleep(4000);
							WebElement MastrTrnscpt= mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
							MastrTrnscpt.sendKeys("E:\\A\\Dummy_Images\\B1.jpg"); //Uploading the file using sendKeys
							Thread.sleep(5000);		
							//Click on Upload button 
							mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
							Thread.sleep(5000);
							
							System.out.println("MASTER TRANSCRIPT DOC uploaded Successfully");
							mydriver.navigate().refresh();
							Thread.sleep(2000);
						}			
						
						
						String i20Text=mydriver.findElement(By.xpath("//td[text()=' I-20 ']")).getText();
						String Acti20Text ="I-20";
						if(i20Text.equals(Acti20Text))
						{	
							//Click on ADD FILE BUTTON and Upload I20 Doc 
							WebElement i20doc=mydriver.findElement(By.xpath("//td[text()=' I-20 ']//following-sibling::td/following-sibling::td/button[1]//img"));
							i20doc.click();
							Thread.sleep(4000);
							WebElement i20document= mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
							i20document.sendKeys("E:\\A\\Dummy_Images\\A.jpg"); //Uploading the file using sendKeys
							Thread.sleep(5000);		
							//Click on Upload button 
							mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
							Thread.sleep(5000);
							System.out.println("I-20 DOC uploaded Successfully");
							mydriver.navigate().refresh();
							Thread.sleep(3000);
							
							
							//SCROLL DOWN INNER TABLE 
							JavascriptExecutor js1=(JavascriptExecutor)mydriver;
							js1.executeScript("document.querySelector(\"tbody\").scrollTop=1500");
							
						}
						
						String EngText=mydriver.findElement(By.xpath("//td[text()=' English Proficiency  ']")).getText();
						String ActEngText ="English Proficiency";
						if(EngText.equals(ActEngText))
						{		
						
							//Click on ADD FILE BUTTON and Upload ENGLISH Doc 
							WebElement ENGLISH=mydriver.findElement(By.xpath("//td[text()=' English Proficiency  ']//following-sibling::td/following-sibling::td/button[1]//img"));
							ENGLISH.click();
							Thread.sleep(4000);
							WebElement englishDoc= mydriver.findElement(By.xpath("//div//input[@id='filesInput']"));
							englishDoc.sendKeys("E:\\A\\Dummy_Images\\Aus1.jpg"); //Uploading the file using sendKeys
							Thread.sleep(5000);		
							//Click on Upload button 
							mydriver.findElement(By.xpath("//button[contains(text(),'Upload')]")).click();
							Thread.sleep(5000);	
							System.out.println("ENGLISH PROFICIENCY DOC uploaded Successfully");
							mydriver.navigate().refresh();
							Thread.sleep(2000);
							
							//SCROLL DOWN INNER TABLE 
							JavascriptExecutor js1=(JavascriptExecutor)mydriver;
							js1.executeScript("document.querySelector(\"tbody\").scrollTop=1500");
						}
						
					}			
					/*catch(Exception e)
					{
						System.out.println("SOMEINTHING ERROR "+e);				
						//System.out.println("SOMEINTHING COUNT"+j);
					}*/
			  
			}	
}
	
	
	

	
	
	

	
	
		


