package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class AuthPage extends BasePage {

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

    public SignupPage signup(String name, String email){
        signupNameInput.type(name);
        signupEmailInput.type(email);
        click(signupButton);
        return new SignupPage(getDriver());
    }

    public void login(String email, String password){
        emailLoginInput.type(email);
        passwordLoginInput.type(password);
        click(loginButton);
    }

    public boolean IsErrorShown(){
        return errorMessage.isVisible();
    }

}
