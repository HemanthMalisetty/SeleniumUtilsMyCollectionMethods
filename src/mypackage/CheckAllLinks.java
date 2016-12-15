package mypackage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckAllLinks {
	
	WebDriver driver;
	
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
		String baseUrl = "http://newtours.demoaut.com/";
		driver = new FirefoxDriver();
		String underConsTitle = "Under Construction: Mercury Tours";
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		int i = 0;
		
		//extract the link text of each link element
		for(WebElement e : linkElements){
			linkTexts[i] = e.getText();
			i++;		
		}
		
		//test each link
		for (String t : linkTexts) {
			driver.findElement(By.linkText(t)).click();
			if(driver.getTitle().equals(underConsTitle)){
				System.out.println("\"" + t + "\"" + " is under construction. ");
			}
			else{
				System.out.println("\"" + t + "\"" + " is working.");
			}
			driver.navigate().back();
		}
	}
	
	
	

}
