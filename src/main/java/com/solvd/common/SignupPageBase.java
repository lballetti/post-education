package com.solvd.common;

import org.openqa.selenium.WebDriver;

public abstract class SignupPageBase extends SitePageBase{

    public SignupPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract MessagePageBase fillWithStandardData();
}
