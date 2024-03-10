package org.webstaurantstore.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.webstaurantstore.driver.Driver;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = Driver.SetUp();
        PageFactory.initElements(driver, this);
    }

    /*
    Waits for element visibility within given timeout
     */
    public static boolean isVisibleWithTimeout(WebElement element, int timeout){
        try{
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            System.out.println("Element [" + element.toString() + "] is not visible after timeout " + timeout + " seconds.");
            return false;
        }
    }

    /*
    Scrolls the given element into view
     */
    public static void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
