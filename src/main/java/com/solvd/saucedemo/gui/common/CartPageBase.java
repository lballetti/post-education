package com.solvd.saucedemo.gui.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CartPageBase extends AbstractPage{

    protected CartPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract InfoPageBase checkout();

    public abstract boolean isItemInCart(String itemName);
}
