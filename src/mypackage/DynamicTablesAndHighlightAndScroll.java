import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by cccce on 02/12/2017.
 */
public class DynamicTablesAndHighlightAndScroll {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "c://developer//seleniumDrivers//geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.skyscanner.com");
        driver.findElement(By.id("js-depart-input")).click();
        System.out.println("********click Depart field");
        scroll(15,100);
        //zoomMinus();
        Thread.sleep(1000);
        String expectedMonth = "December 2017";
        String currentMonth = driver.findElement(By.cssSelector("div.depart span.current")).getText();
        if(expectedMonth.equals(currentMonth)){
            System.out.println("Month is already selected!");
        } else {
            for(int i = 1; i < 12; i++){
                driver.findElement(By.cssSelector("div.depart button.next")).click();
                Thread.sleep(500);
                currentMonth = driver.findElement(By.cssSelector("div.depart span.current")).getText();
                if(expectedMonth.equals(currentMonth)){
                    System.out.println("Month Selected!");
                    break;
                }
            }
        }
        Thread.sleep(1000);
        WebElement datePicker = driver.findElement(By.cssSelector("div.depart div.container-body table tbody"));
        List<WebElement> dates = datePicker.findElements(By.tagName("td"));
        for(WebElement date : dates){
            String calDate = date.getAttribute(("data-id"));
            if(calDate.equals("2017-12-30")){
                flash(date, driver);
                date.click();
                break;
            }
        }


                //driver.findElement(By.cssSelector("div.depart button[class*='next']")).click();
        //System.out.println("****click Next Month button");
        Thread.sleep(2000);
        //driver.close();
        driver.quit();


    }



    public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  3; i++) {
            changeColor("rgb(0,200,0)", element, js);
            changeColor(bgcolor, element, js);
        }
    }
    public static void changeColor(String color, WebElement element,  JavascriptExecutor js) {
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
    }




    // Scroll

    /**
     * Scroll in current window.
     *
     * @param x - How many pixel scroll left or right. A negative value is left.
     * @param y - How many pixel scroll up or down. A negative value is up.
     */
    public static void scroll(final int x, final int y) {
        final JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i <= x; i = i + 50) {
            js.executeScript("scroll(" + i + ",0)");
        }
        for (int j = 0; j <= y; j = j + 50) {
            js.executeScript("scroll(0," + j + ")");
        }
    }


    /**
     * Zoom current window -1.
     */
    public static void zoomMinus() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).perform();
        actions = new Actions(driver);
        actions.keyUp(Keys.CONTROL).perform();
    }



}
