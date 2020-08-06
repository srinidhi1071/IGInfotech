package iginterview.genericlib;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import static io.restassured.RestAssured.*;

public class BaseLib {

	@BeforeMethod
	public void setUp() {
		baseURI  = "http://demo4032024.mockable.io/";
		
	}
	
}
