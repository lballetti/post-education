package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class MessagePage extends BasePage{

    @FindBy(css = "[data-qa='continue-button']")
    private ExtendedWebElement continueBtn;

    @FindBy(css = "h2.title")
    private ExtendedWebElement messageTitle;

    protected MessagePage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle(){
        return messageTitle.getText();
    }

    public Homepage clickContinue(){
        click(continueBtn);
        return new Homepage(getDriver());
    }
}
