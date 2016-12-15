package mypackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class ChromeSoftAssertionVsHardAsserion {
	
	public static void main(String[] args) {		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.care2.com");
		System.out.println(driver.getCurrentUrl() + "1");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("www.care2.com"));		
		System.out.println(driver.getCurrentUrl() + "2");
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("http:www.care2.com/"));
		System.out.println(driver.getCurrentUrl() + "3");
		
	}

}
