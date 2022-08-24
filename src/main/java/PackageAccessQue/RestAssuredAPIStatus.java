package PackageAccessQue;

import org.openqa.selenium.devtools.v104.network.model.Response;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;


public class RestAssuredAPIStatus
{
	String baseURI;
	//RequestSpecification given();
	
	 RequestSpecification request = RestAssured.given();
	 public RestAssuredAPIStatus()	
	{
		baseURI ="https://services.accessque.com";
	
	}

public void myapires()
{	
	given().accept(ContentType.JSON)
	.get(baseURI+"/uhleads")
	.then()
	.log()
	.body();
}

private RequestSpecification given() {
	// TODO Auto-generated method stub
	return null;
}

public static void main(String[] args)
{
	RestAssuredAPIStatus object =new RestAssuredAPIStatus();
	object.myapires();
}

}



/*
 * // TODO Auto-generated method stub
 * 
 * @Test public void Request1() { RequestSpecification request =
 * RestAssured.given(); request.baseUri("https://services.accessque.com");
 * request.basePath("/uhleads");
 * 
 * Response response = (Response) request.get();
 * 
 * 
 * //status code validation int statuscode = response.getStatus();
 * AssertJUnit.assertEquals(statuscode,200);
 * 
 * //print response in console window String
 * responsebody=((ResponseOptions<io.restassured.response.Response>)
 * response).getBody().asString();
 * System.out.println("Response Body is:"+responsebody);
 * 
 * 
 * }
 * 
 * @Test public void Request2() { RequestSpecification request =
 * RestAssured.given();
 * 
 * request.baseUri("https://restful-booker.herokuapp.com");
 * 
 * request.basePath("/Home");
 * 
 * Response response = (Response) request.get();
 * 
 * //status code validation int statuscode =
 * ((ResponseOptions<io.restassured.response.Response>)
 * response).getStatusCode(); AssertJUnit.assertEquals(statuscode,200);
 * 
 * //print response in console window String
 * responsebody=((ResponseOptions<io.restassured.response.Response>)
 * response).getBody().asString();
 * System.out.println("Response Body is:"+responsebody);
 * 
 * }
 * 
 * }
 */

