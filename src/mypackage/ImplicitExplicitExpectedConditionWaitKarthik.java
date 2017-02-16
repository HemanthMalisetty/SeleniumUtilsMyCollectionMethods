import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by cccce on 02/14/2017.
 */
public class ImplicitExplicitExpectedConditionWaitKarthik {

    static WebDriver driver = null;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.gecko.driver", "c://developer//seleniumDrivers//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void googleSearchEASite(){
        driver.navigate().to("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Execute automation");
        driver.findElement(By.name("btnG")).click();
        //explicitWait(driver, "Automation Testing Automated");
        driver.findElement(By.partialLinkText("Automation Testing Automated")).click();
        explicitWaitByText(driver, "Performance");
        driver.findElement(By.linkText("Performance Testing")).click();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    //explicitWaitByText
    public static void explicitWaitByText(WebDriver driver, String text){
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text)));
    }

    //explicitWaitByElement
    public static void explicitWaitByWebElement(WebDriver driver, WebElement element){
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(element));
    }

}
