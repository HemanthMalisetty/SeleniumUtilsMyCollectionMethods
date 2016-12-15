/**
 * 
 */
package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author tsvetomir
 *
 */
public class DownloadingFilesWithWget {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://download.cnet.com/ccleaner/");
		
		WebElement downloadButton = driver.findElement(By.cssSelector(".dln-a"));
		String sourceLocation = downloadButton.getAttribute("data-href");
		
		String wget_command = "cmd /c -P c:/wget --no-check-certificate " + sourceLocation;
		try{
			Process exec = Runtime.getRuntime().exec(wget_command);
			int exitVal = exec.waitFor();
			System.out.println("Exit value: " + exitVal);
		}
		catch(InterruptedException | IOException ex){
			System.out.println(ex.toString());
		}
		}

}
