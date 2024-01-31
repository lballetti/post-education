package com.solvd.saucedemo.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemo.gui.common.HomePageBase;
import com.solvd.saucedemo.gui.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase{

    @FindBy(css = "#user-name")
    private ExtendedWebElement usernameInput;

    @FindBy(css = "#password")
    private ExtendedWebElement passwordInput;

    @FindBy(css = "#login-button")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HomePageBase login(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
        loginButton.click();
        return initPage(HomePageBase.class, getDriver());
    }
    
}
