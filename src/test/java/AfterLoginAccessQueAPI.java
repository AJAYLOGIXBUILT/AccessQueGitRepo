import org.asynchttpclient.Response;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ResponseOptions;
public class AfterLoginAccessQueAPI
{

	@Test
	public void loginTest()
	{
		
		Response myresponse = RestAssured.get("https://services.accessque.com/api/v1/templateByName/passwordverification");
		//Response myresponse = (Response) RestAssured.get("https://services.accessque.com/api/v1/templateByName/passwordverification");
		
		System.out.println(myresponse.getContentType());
		System.out.println(myresponse.toString());
		//System.out.println(myresponse.getBody().asString());
		System.out.println(myresponse.getStatusCode());
		System.out.println(myresponse.toString());
		
		System.out.println(myresponse.getCookies());
		System.out.println(myresponse.getHeaders());
		
		
		System.out.println(myresponse.getHeader("content-type"));
		
		
		
	}
	
	
}





/*
  @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        this.chromeDriver = new ChromeDriver();
        devTools = chromeDriver.getDevTools();
        devTools.createSession();
    }

    @Test
    public void getRequestsAndResponseUrls() throws InterruptedException {
        devTools.send(new Command<>("Network.enable", ImmutableMap.of()));
;
        devTools.addListener(Network.responseReceived(), l -> {
            System.out.print("Response URL: ");
            System.out.println(l.getResponse().getUrl());
        });
        devTools.addListener(Network.requestWillBeSent(), l -> {
            System.out.print("Request URL: ");
            System.out.println(l.getRequest().getUrl());
        });

        chromeDriver.get("https://edition.cnn.com/");

        // While Thread.sleep you you will see requests and responses appearing in console. 
        Thread.sleep(10000);
    }
    
    */





/*
 * import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v91.network.*;
            :
            
    DevTools devTools = ((ChromiumDriver) driver).getDevTools();
    devTools.createSession();
    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
    
    devTools.addListener(Network.requestWillBeSent(), entry -> {
                System.out.println("Request (id) URL      : (" + entry.getRequestId() + ") " 
                        + entry.getRequest().getUrl()
                        + " (" + entry.getRequest().getMethod() + ")");
            });
    
    devTools.addListener(Network.responseReceived(), entry -> {
                System.out.println("Response (Req id) URL : (" + entry.getRequestId() + ") " 
                        + entry.getResponse().getUrl()
                        + " (" + entry.getResponse().getStatus() + ")");
            }); 
    
    driver.get("someurl");  // on so on ... 

 */


