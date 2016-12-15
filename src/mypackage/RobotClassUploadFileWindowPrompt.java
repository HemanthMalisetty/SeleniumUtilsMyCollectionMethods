/**
 * 
 */
package mypackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
//import com.thoughtworks.selenium.webdriven.commands.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * @author tsvetomir
 *
 */
public class RobotClassUploadFileWindowPrompt {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.megafileupload.com");
		driver.findElement(By.cssSelector(".slider-btn.slider-btn-upload")).click();
		driver.findElement(By.cssSelector(".internal")).click();
		// Sleep for 5 secons
		Thread.sleep(5000);
		// Set the file name in clipboard
		StringSelection ss = new StringSelection("C:\\eula.1028.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// Perform native keystrokes for keystrokes for CONTROL+V and ENTER keys
		Robot robot = new Robot();
		//robot.keyPress(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// Thread.sleep(5000) HELPED IT TO WORK!!!!!!!!!
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);			
		
		driver.findElement(By.cssSelector(".btn.btn-green.btn-lg")).click();

	}
}
