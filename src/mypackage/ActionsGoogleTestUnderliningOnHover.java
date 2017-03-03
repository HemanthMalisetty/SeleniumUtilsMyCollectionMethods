import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by cccce on 03/02/2017.
 */
public class ActionsGoogleTestUnderliningOnHover {



    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        //driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement lnkPrivacy = driver.findElement(By.linkText("Privacy"));
        action.moveToElement(lnkPrivacy);
        action.build().perform();
        Thread.sleep(1000);
        WebElement lnkTerms = driver.findElement(By.linkText("Terms"));
        Actions action1 = new Actions(driver);
        action1.moveToElement(lnkTerms);
        action1.build().perform();
        Thread.sleep(1000);
        WebElement lnkSettings = driver.findElement(By.linkText("Settings"));
        Actions action2 = new Actions(driver);
        action2.moveToElement(lnkSettings);
        action2.build().perform();
        Thread.sleep(1000);
        WebElement searchBox = driver.findElement(By.id("lst-ib"));
        searchBox.sendKeys("news");
        WebElement searchButton = driver.findElement(By.id("_fZl"));
        searchButton.click();
        //searchBox.submit();
        //Actions pressKey = new Actions(driver);
        //pressKey.keyDown(Keys.ENTER);
        //Actions releaseKey = new Actions(driver);
        //releaseKey.keyUp(Keys.ENTER);
    }

}
