package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessagePage extends BasePage{

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueBtn;

    @FindBy(css = "h2.title")
    private WebElement messageTitle;

    protected MessagePage(WebDriver driver) {
        super(driver);
    }
    
    public String getTitle(){
        return messageTitle.getText();
    }

    public Homepage clickContinue(){
        click(continueBtn, "Continue button");
        return new Homepage(getDriver());
    }
}
