import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by cccce on 03/03/2017.
 */
public class ActionsGoogle2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        //driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement lnkPrivacy = driver.findElement(By.linkText("Privacy"));
        WebElement lnkTerms = driver.findElement(By.linkText("Terms"));
        WebElement lnkSettings = driver.findElement(By.linkText("Settings"));
        WebElement searchBox = driver.findElement(By.id("lst-ib"));
        WebElement searchButton = driver.findElement(By.id("_fZl"));

        action.moveToElement(lnkPrivacy);
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(lnkTerms);
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(lnkSettings);
        action.build().perform();
        Thread.sleep(1000);

        searchBox.sendKeys("news");

        searchButton.click();
        //searchBox.submit();
        //Actions pressKey = new Actions(driver);
        //pressKey.keyDown(Keys.ENTER);
        //Actions releaseKey = new Actions(driver);
        //releaseKey.keyUp(Keys.ENTER);
    }



}
