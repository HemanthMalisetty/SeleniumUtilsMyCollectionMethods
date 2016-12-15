package mypackage;

import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class ImageLink {
 
    public static void main(String[] args) {
        String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";
        //WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
 
        driver.get(baseUrl);
        //click on the "Facebook" logo on the upper left portion
        // The selector is from Chrome Copy selector
        driver.findElement(By.cssSelector("#blueBarDOMInspector > div > div > div > div > div.lfloat._ohe > h1 > a > i")).click();
 
        //verify that we are now back on Facebook's homepage
        if (driver.getTitle().equals("Facebook - Log In or Sign Up")) {
            System.out.println("We are back at Facebook's homepage");
        } else {
            System.out.println("We are NOT in Facebook's homepage");
        }
        
    }
}