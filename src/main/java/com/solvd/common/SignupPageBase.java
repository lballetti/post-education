package com.solvd.common;

import org.openqa.selenium.WebDriver;

import com.solvd.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class SignupPageBase extends AbstractPage{

    public SignupPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract Header getHeader();
    
    public abstract MessagePageBase fillWithStandardData();
}
