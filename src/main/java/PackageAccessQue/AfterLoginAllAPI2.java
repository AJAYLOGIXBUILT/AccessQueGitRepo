package PackageAccessQue;

public class AfterLoginAllAPI2 {

	public class LoginPageTest extends TestBase{

	    LoginPage loginPage;
	    HomePage homepage;

	    public LoginPageTest(){

	        super();
	    }

	    @BeforeMethod
	    public void setUp(){

	        initialization();
	        loginPage = new LoginPage();

	    }

	    @Test(priority=1)
	    public void loginPageTitleTest(){

	        String title = loginPage.validateLoginPageTitle();
	        Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");

	    }

	    @Test(priority=2)
	    public void crmLogoImageTest(){

	        boolean flag = loginPage.validateCRMImage();

	        Assert.assertTrue(flag,"Image not found");
	    }

	    @Test(priority=3)
	    public void loginTest(){

	        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    }


	    @AfterMethod
	    public void tearDown(){

	        driver.quit();
	    }

	}