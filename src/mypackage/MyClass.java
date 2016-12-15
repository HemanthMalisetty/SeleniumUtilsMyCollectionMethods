package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class MyClass {

	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		String alertMessage = "";
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("http://jsbin.com/usidix/1");
		driver.findElement(By.cssSelector("html body input")).click();
		alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		System.out.println(alertMessage);
		driver.quit();
	}
	
}
