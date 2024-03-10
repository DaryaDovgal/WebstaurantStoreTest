package org.webstaurantstore.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.webstaurantstore.utils.DataUtils;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    /*
    Sets WebDriver up, navigates to the URL, maximizes window
    And gives 30 seconds of implicitly wait for page to load
     */
    public static WebDriver SetUp() {
        if (driver==null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(DataUtils.getProperty("BASE_URL"));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    /*
    Tears WebDriver down
     */
    public static void TearDown(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
