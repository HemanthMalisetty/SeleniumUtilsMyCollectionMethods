package mypackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BuildingASeriesOfMultipleActions {
	public static void main(String[] args){
		String baseUrl = "http://www.facebook.com";
		WebDriver driver = new FirefoxDriver();
		
		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));
		
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello")
				.keyUp(txtUsername, Keys.SHIFT)
				.doubleClick(txtUsername)
				.contextClick()
				.build();
		
		seriesOfActions.perform();
	}
}
