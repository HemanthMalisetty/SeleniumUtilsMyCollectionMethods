package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.examples.BusinessPlan;


public class NavigationMenuDrowpDownTestMoveToWorksWithChromeOnlyInSelenium3point1 {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\developer\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void clickOnDropDownLink() throws Exception{
		
		driver.get("http://www.reuters.com");
		
		WebElement businessMenuItem = driver.findElement(By.id("nav-item-2"));
		
		hoverWebelement(businessMenuItem);
		
		//businessMenuItem.click();
		
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		
		//wait.until(ExpectedConditions.elementToBeClickable(businessMenuItem));
		
		//Actions action = new Actions(driver);		
		//action.moveToElement(businessMenuItem);
		//action.build().perform();
		
		takeScreenshotMethod("C:\\developer");
		
	}
	
	@AfterClass
	public void tearDown(){
		
	}
	
	
	public void takeScreenshotMethod(String Destination)
			throws Exception {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(Destination));
	}
	
	public void hoverWebelement(WebElement HovertoWebElement)
			throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(HovertoWebElement).perform();
		Thread.sleep(2000);

	}

}
