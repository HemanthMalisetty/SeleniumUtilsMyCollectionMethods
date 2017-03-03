import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by cccce on 03/03/2017.
 */
public class ActionsReutersNavigation {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        // increase timeouts for the tests to work
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("http://www.reuters.com");
        //driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement lnk2 = driver.findElement(By.id("nav-item-2"));
        WebElement lnk3 = driver.findElement(By.id("nav-item-3"));
        WebElement lnk4 = driver.findElement(By.id("nav-item-4"));
        WebElement lnk5 = driver.findElement(By.id("nav-item-5"));
        WebElement lnk6 = driver.findElement(By.id("nav-item-6"));
        WebElement lnk7 = driver.findElement(By.id("nav-item-7"));
        WebElement lnk8 = driver.findElement(By.id("nav-item-8"));
        WebElement lnk9 = driver.findElement(By.id("nav-item-9"));

        WebElement subNavLnk = driver.findElement(By.xpath(".//*[@id='subnav-9']/div/ul[2]/li[1]/a"));



        action.moveToElement(lnk2);
        //build().perform() returns empty object and we can do other tasks
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(lnk3);
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(lnk4);
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(lnk5);
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(lnk6);
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(lnk7);
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(lnk8);
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(lnk9);
        action.build().perform();
        Thread.sleep(1000);

        action.moveToElement(subNavLnk);
        action.build().perform();
        Thread.sleep(1000);

    }


}
