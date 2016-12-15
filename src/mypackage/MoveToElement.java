package mypackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {
	
	static WebDriver driver;
	
	public static void main(String[] arg){
		String baseUrl = "Http://www.newtours.demoaut.com/";
		driver = new FirefoxDriver();
		
		driver.get(baseUrl);
		WebElement link_Home = driver.findElement(By.linkText("Home"));
		WebElement td_Home = driver.findElement(By.xpath("/html/body/div"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr/td"
                + "/table/tbody/tr"));
		System.out.println("before .build() the color is: " + td_Home.getCssValue("background-color"));
		
		highlightelement(driver, link_Home);
		
		Actions builder = new Actions(driver);
		Action mouseOverHome = builder.moveToElement(link_Home).build();
		
		String bgColor = td_Home.getCssValue("background-color");
		System.out.println("after .build() Before hover: " + bgColor);
		mouseOverHome.perform();
		bgColor = td_Home.getCssValue("background-color");
		System.out.println("after .perform() After hover: " + bgColor);
		//Instead this can be Assertion in a TestNG case for all the links on a page test suite just copy and paste
		
	}
	
	public static void highlightelement(WebDriver driver, WebElement element) {		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2p solid red;');",element);
			try{
				Thread.sleep(500);
			}
			catch (InterruptedException e){
				System.out.println(e.getMessage());
			}
			
			js.executeScript("arguments[0].setAttribute('style', 'border: solid 2px white')", element);

	}

}
