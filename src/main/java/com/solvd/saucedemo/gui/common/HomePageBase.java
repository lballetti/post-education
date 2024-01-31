package com.solvd.saucedemo.gui.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomePageBase extends AbstractPage{

    protected HomePageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract void addItemToCart(String name);

    public abstract CartPageBase clickCart();
}
