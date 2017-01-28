package mypackage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	
	public static WebElement dragItem1;
	public static WebElement dragItem2;
	
	public static void main(String[] args) throws InterruptedException{
		//System.setProperty("webdriver.chrome.driver", "c:\\developer\\SeleniumDrivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
		driver.navigate().to("http://www.executeautomation.com/demosite/Dragging.html");
		
		dragItem1 = driver.findElement(By.id("item1"));
		dragItem2 = driver.findElement(By.id("item4"));
		dragAndDrop(driver, dragItem1, dragItem2);
		
	}
	
	//Actions always first build() then perform() because only perform does not work in Firefox
	public static void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement dstElement){
		
		Actions action = new Actions(driver);
		action.dragAndDrop(srcElement, dstElement);
		action.build();
		action.perform();
	}
	
	
	

}
