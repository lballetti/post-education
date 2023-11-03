package com.solvd.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.solvd.pages.AbstractPage;

public class SigninComponent extends AbstractPage{
    
    @FindBy(id = "join_neu_email_field")
    private WebElement emailField;

    @FindBy(id = "join_neu_password_field")
    private WebElement passwordField;

    @FindBy(css = "button[data-join-neu-button]")
    private WebElement loginButton;

    public SigninComponent(WebDriver driver){
        super(driver);
    }

    public void login(String email, String password){
        sendKeys(emailField, "Email field", email);
        sendKeys(passwordField, "Password field", password);
        click(loginButton, "Log in Button");
    }
}
