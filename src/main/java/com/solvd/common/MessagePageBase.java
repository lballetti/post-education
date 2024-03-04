package com.solvd.common;

import org.openqa.selenium.WebDriver;


public abstract class MessagePageBase extends SitePageBase{

    public MessagePageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract String getTitle();

    public abstract HomePageBase clickContinue();

}
