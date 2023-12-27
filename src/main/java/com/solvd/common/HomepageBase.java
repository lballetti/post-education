package com.solvd.common;

import org.openqa.selenium.WebDriver;

import com.solvd.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class HomepageBase extends AbstractPage{

    public HomepageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase addToCartandView(int n);

    public abstract CartPageBase addToCartandView(String name);
    
    public abstract Header getHeader();
}
