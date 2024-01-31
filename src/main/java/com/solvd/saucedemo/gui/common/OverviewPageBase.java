package com.solvd.saucedemo.gui.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class OverviewPageBase extends AbstractPage{

    protected OverviewPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract MessagePageBase order();
}
