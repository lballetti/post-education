package com.solvd.common;

import org.openqa.selenium.WebDriver;


public abstract class HomePageBase extends SitePageBase{

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase addToCartandView(int n);

    public abstract CartPageBase addToCartandView(String name);
    
}
