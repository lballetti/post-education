package com.solvd.common;

import org.openqa.selenium.WebDriver;

import com.solvd.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class AuthPageBase extends AbstractPage{

    public AuthPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignupPageBase signup(String name, String email);
    
    public abstract void login(String email, String password);

    public abstract boolean IsErrorShown();

    public abstract Header getHeader() ;
}
