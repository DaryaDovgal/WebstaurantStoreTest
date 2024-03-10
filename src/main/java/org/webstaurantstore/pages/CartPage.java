package org.webstaurantstore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@id='cartItemCountSpan']/..")
    private WebElement cartButton;

    @FindBy(xpath = "//h1[text()='Cart']")
    private WebElement cartLabel;

    @FindBy(xpath = "//span[text()='Cart']")
    private WebElement cartBreadcrumb;

    @FindBy(xpath = "//button[text()='Empty Cart']")
    private WebElement emptyCartButton;

    @FindBy(xpath = "//button[text()='Empty'and'Cart']")
    private WebElement confirmEmptyCartButton;

    @FindBy(xpath = "//p[text()='Your cart is empty.']")
    private WebElement cartIsEmptyMessage;

    /*
    Navigates to Shopping Cart
     */
    public void navigateToCart(){
        scrollToElement(cartButton);
        Assert.assertTrue(isVisibleWithTimeout(cartButton, 30));
        cartButton.click();
    }

    /*
    Verifies whether Page is loaded by checking elements visibility
     */
    public void verifyPageLoaded(){
        Assert.assertTrue(isVisibleWithTimeout(cartLabel, 30));
        Assert.assertTrue(isVisibleWithTimeout(cartBreadcrumb, 30));
        Assert.assertTrue(isVisibleWithTimeout(cartButton, 30));
        System.out.println("Shopping Cart successfully loaded");
    }

    /*
    Cleans up Shopping Cart
     */
    public void emptyCart(){
        Assert.assertTrue(isVisibleWithTimeout(emptyCartButton, 15));
        emptyCartButton.click();
        Assert.assertTrue(isVisibleWithTimeout(confirmEmptyCartButton, 15));
        confirmEmptyCartButton.click();
        Assert.assertTrue(isVisibleWithTimeout(cartIsEmptyMessage, 30));
        System.out.println("Shopping Cart successfully cleaned up");
    }
}
