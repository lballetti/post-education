package com.solvd.common.mobile;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class BrowserPageBase extends AbstractPage{
    
    protected BrowserPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void newTab();
}
