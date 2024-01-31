package com.solvd.saucedemo.gui.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class InfoPageBase  extends AbstractPage{

    protected InfoPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract OverviewPageBase finishOrder();
}
