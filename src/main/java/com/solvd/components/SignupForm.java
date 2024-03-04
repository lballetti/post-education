package com.solvd.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class SignupForm extends AbstractUIObject implements ICustomTypePageFactory {

    public SignupForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(css = "[data-qa='signup-name']")
    private ExtendedWebElement signupNameInput;
    @FindBy(css = "[data-qa='signup-email']")
    private ExtendedWebElement signupEmailInput;
    @FindBy(css = "[data-qa='signup-button']")
    private ExtendedWebElement signupButton;

    public SignupPageBase signup(String name, String email) {
        signupNameInput.type(name);
        signupEmailInput.type(email);
        signupButton.click();
        return initPage(SignupPageBase.class, driver);
    }
}
