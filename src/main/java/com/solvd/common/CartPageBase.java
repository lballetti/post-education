package com.solvd.common;

import org.openqa.selenium.WebDriver;
import com.solvd.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CartPageBase extends AbstractPage{

    public CartPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract  void deleteFromCart(int n);

    public abstract void deleteFromCart(String name);

    public abstract CheckoutPageBase clickCheckout();

    public abstract boolean isItemPresent(String name);

    public abstract Header getHeader();
}
