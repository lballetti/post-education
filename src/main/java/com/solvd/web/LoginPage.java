package com.solvd.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.LoginPageBase;
import com.solvd.components.LoginForm;
import com.solvd.components.SignupForm;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(css = ".login-form")
    private LoginForm loginForm;
    @FindBy(css = ".signup-form")
    private SignupForm signupForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }



    @Override
    public SignupForm getSignupForm() {
        return signupForm;
    }

    @Override
    public LoginForm getLoginForm() {
        return loginForm;
    }
}
