package com.solvd.common;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends SitePageBase{

    public CartPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract  void deleteFromCart(int n);

    public abstract void deleteFromCart(String name);

    public abstract CheckoutPageBase clickCheckout();

    public abstract boolean isItemPresent(String name);

}
