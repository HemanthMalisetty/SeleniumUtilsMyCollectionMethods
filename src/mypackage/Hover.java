import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Hover {
	
	/**
	 * // Dynamically generating elements not visible
		// Implement the hover over MoveToElement here, or even better implement it in AutomationHomePage and have it as
		// a public static method getter instead of a variable
		// otherwise the element is not visible
		// FindBy not applicable to local variable//
		// Use Waits for dynamic drop downs
		// 
		 * 
		 * 
		 * 
		 * 
		 * Selenium 3 and 3.0.1 can't perform moveToElement or JavaScript focus() function
		 * Use Selenium 2.48.2 in build path to fix this issue, even with the newest drivers
		 * 
		 * 
		 * 
		 * 
		 * 
		 * @return
		 */
		/*public static WebElement getCasualDressesLinkInWomenSubMenu(){
			WebElement casual_dresses;
			WebElement women_link = driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[1]/a"));
			Actions builder = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, 10);

			builder.moveToElement(women_link).build().perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Casual Dresses")));
			casual_dresses = driver.findElement(By.linkText("Casual Dresses"));
			return casual_dresses;
		} 
	 */
			
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "c:\\developer\\SeleniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
		driver.navigate().to("http://www.executeautomation.com/demosite/index.html");
		Thread.sleep(3000);
		
		
		WebElement menuItemAutomationTools = driver.findElement(By.id("Automation Tools"));
		hoverOver(driver, menuItemAutomationTools);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//String script = "focus();";
		//menuItemAutomationTools.click();
		//js.executeScript(script, menuItemAutomationTools);
		
		WebElement subMenuItemSelenium = driver.findElement(By.id("Selenium"));
		hoverOver(driver, subMenuItemSelenium);
		//subMenuItemSelenium.click();
		//js.executeScript(script, subMenuItemSelenium);
		
		driver.findElement(By.id("Selenium WebDriver")).click();
		
	}
	
	public static void hoverOver(WebDriver driver, WebElement element){
		
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		action.moveToElement(element).build().perform();
		
	}
	

}