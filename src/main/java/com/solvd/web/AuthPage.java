package com.solvd.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.AuthPageBase;
import com.solvd.common.SignupPageBase;
import com.solvd.components.Header;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

    @DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AuthPageBase.class)
public class AuthPage extends AuthPageBase {

    @FindBy(id = "header")
    private Header header;

    //Login form
    @FindBy(css = "[data-qa='login-email']")
    private ExtendedWebElement emailLoginInput;
    @FindBy(css = "[data-qa='login-password']")
    private ExtendedWebElement passwordLoginInput;
    @FindBy(css = "[data-qa='login-button']")
    private ExtendedWebElement loginButton;
    @FindBy(css = ".login-form p")
    private ExtendedWebElement errorMessage;

    //Sign up form
    @FindBy(css = "[data-qa='signup-name']")
    private ExtendedWebElement signupNameInput;
    @FindBy(css = "[data-qa='signup-email']")
    private ExtendedWebElement signupEmailInput;
    @FindBy(css = "[data-qa='signup-button']")
    private ExtendedWebElement signupButton;
    
    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignupPageBase signup(String name, String email){
        signupNameInput.type(name);
        signupEmailInput.type(email);
        signupButton.click();
        return initPage(SignupPageBase.class, driver);
    }

    @Override
    public void login(String email, String password){
        emailLoginInput.type(email);
        passwordLoginInput.type(password);
        loginButton.click();
    }

    @Override
    public boolean IsErrorShown(){
        return errorMessage.isVisible();
    }
    
    @Override
    public Header getHeader() {
        return header;
    }
}
