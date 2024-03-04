package com.solvd.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = "div.cart_info tbody tr")
    private List<WebElement> cartItems;

    @FindBy(css = "a.check_out")
    private WebElement checkoutBtn;

    protected CartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteFromCart(int n) {
        click(cartItems.get(n).findElement(By.cssSelector("a.cart_quantity_delete")), "Cart Item Delete Button");
    }

    public List<WebElement> getCartItems() {
        refreshElements();
        return cartItems;
    }

    public CheckoutPage clickCheckout() {
        click(checkoutBtn, "Checkout Button");
        return new CheckoutPage(getDriver());
    }

}
