package com.solvd.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.components.CartItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class CartPage extends BasePage{

    @FindBy(css = "div.cart_info tbody tr")
    private List<CartItem> cartItems;

    @FindBy(css = "a.check_out")
    private ExtendedWebElement checkoutBtn;

    protected CartPage(WebDriver driver) {
        super(driver);
    }
    
    public void deleteFromCart(int n) {
        cartItems.get(n).delete();
    }

    public void deleteFromCart(String name) {
        cartItems.stream()
                .filter(x-> x.getName().equals(name))
                .findFirst()
                .get()
                .delete();
    }

    public CheckoutPage clickCheckout(){
        click(checkoutBtn);
        return new CheckoutPage(getDriver());
    }

    public boolean isItemPresent(String name){
        return cartItems.stream()
                .filter(x-> x.getName().equals(name))
                .findAny()
                .get() != null;
    }
}
