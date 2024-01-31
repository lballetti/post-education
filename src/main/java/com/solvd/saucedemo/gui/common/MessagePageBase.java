package com.solvd.saucedemo.gui.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class MessagePageBase extends AbstractPage{

    protected MessagePageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract boolean isOrderSuccessful();
}
