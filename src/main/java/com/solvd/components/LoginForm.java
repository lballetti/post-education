package com.solvd.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class LoginForm extends AbstractUIObject implements ICustomTypePageFactory {

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(css = "[data-qa='login-email']")
    private ExtendedWebElement emailLoginInput;
    @FindBy(css = "[data-qa='login-password']")
    private ExtendedWebElement passwordLoginInput;
    @FindBy(css = "[data-qa='login-button']")
    private ExtendedWebElement loginButton;
    @FindBy(css = ".login-form p")
    private ExtendedWebElement errorMessage;

    public void login(String email, String password) {
        emailLoginInput.type(email);
        passwordLoginInput.type(password);
        loginButton.click();
    }

    public boolean IsErrorShown() {
        return errorMessage.isVisible();
    }
}
