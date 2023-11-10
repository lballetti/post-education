package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends BasePage {

    //Login form
    @FindBy(css = "[data-qa='login-email']")
    private WebElement emailLoginInput;
    @FindBy(css = "[data-qa='login-password']")
    private WebElement passwordLoginInput;
    @FindBy(css = "[data-qa='login-button']")
    private WebElement loginButton;
    @FindBy(css = ".login-form p")
    private WebElement errorMessage;

    //Sign up form
    @FindBy(css = "[data-qa='signup-name']")
    private WebElement signupNameInput;
    @FindBy(css = "[data-qa='signup-email']")
    private WebElement signupEmailInput;
    @FindBy(css = "[data-qa='signup-button']")
    private WebElement signupButton;

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage signup(String name, String email){
        sendKeys(signupNameInput, "Signup name Input", name);
        sendKeys(signupEmailInput, "Signup email Input", email);
        click(signupButton, "Signup button");
        return new SignupPage(getDriver());
    }

    public void login(String email, String password){
        sendKeys(emailLoginInput, "Login Email Input", email);
        sendKeys(passwordLoginInput, "Login Password Input", password);
        click(loginButton, "Login Button");
    }

    public boolean IsErrorShown(){
        refreshElements();
        return errorMessage.isDisplayed();
    }

}
