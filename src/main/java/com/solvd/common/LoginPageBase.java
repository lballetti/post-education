package com.solvd.common;

import org.openqa.selenium.WebDriver;

import com.solvd.components.LoginForm;
import com.solvd.components.SignupForm;

public abstract class LoginPageBase extends SitePageBase {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignupForm getSignupForm();

    public abstract LoginForm getLoginForm();

}
