package com.solvd.saucedemo.gui.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class LoginPageBase extends AbstractPage{

    protected LoginPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract HomePageBase login(String username, String password);

}
