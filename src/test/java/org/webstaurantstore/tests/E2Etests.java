package org.webstaurantstore.tests;

import org.testng.annotations.Test;
import org.webstaurantstore.utils.DataUtils;

public class E2Etests extends BaseTest {

    public static String product = DataUtils.getProperty("SEARCH_PRODUCT");
    public static String targetWord = DataUtils.getProperty("TARGET_WORD");

    /*
    Assessment test scenario: navigate to Webstaurant Store, search for given Product, check titles in
    Search Results (ON FIRST PAGE), add last Product to Cart, empty Cart
     */
    @Test (priority = 1)
    public void assessmentTestFirstResultPage() {
        homePage.verifyPageLoaded();
        homePage.searchProduct(product);
        searchPage.verifyPageLoaded();
        searchPage.verifyProductsTitlesFirstPage(targetWord);
        searchPage.addLastProductToCart();
        cartPage.navigateToCart();
        cartPage.verifyPageLoaded();
        cartPage.emptyCart();
    }

    /*
    Assessment test scenario: navigate to Webstaurant Store, search for given Product, check titles in
    Search Results (ALL PAGES), add last Product to Cart, empty Cart
    */
    @Test (priority = 2)
    public void assessmentTestAllResultPages() {
        homePage.verifyPageLoaded();
        homePage.searchProduct(product);
        searchPage.verifyPageLoaded();
        searchPage.verifyProductsTitlesAllPages(targetWord);
        searchPage.addLastProductToCart();
        cartPage.navigateToCart();
        cartPage.verifyPageLoaded();
        cartPage.emptyCart();
    }




}
