package com.solvd.common;

import org.openqa.selenium.WebDriver;

import com.solvd.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class MessagePageBase extends AbstractPage{

    public MessagePageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract String getTitle();

    public abstract HomepageBase clickContinue();

    public abstract Header getHeader();
}
