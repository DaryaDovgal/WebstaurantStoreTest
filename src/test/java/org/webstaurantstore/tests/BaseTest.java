package org.webstaurantstore.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.webstaurantstore.driver.Driver;
import org.webstaurantstore.pages.CartPage;
import org.webstaurantstore.pages.HomePage;
import org.webstaurantstore.pages.SearchPage;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected SearchPage searchPage;
    protected CartPage cartPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = Driver.SetUp();
        initPages();
    }

    public void initPages(){
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        Driver.TearDown();
    }
}
