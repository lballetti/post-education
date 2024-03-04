package com.solvd.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.HomePageBase;
import com.solvd.common.MessagePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = MessagePageBase.class)
public class MessagePage extends MessagePageBase{

    @FindBy(css = "[data-qa='continue-button']")
    private ExtendedWebElement continueBtn;

    @FindBy(css = "h2.title")
    private ExtendedWebElement messageTitle;

    public MessagePage(WebDriver driver) {
        super(driver);
    }
    
    @Override
    public String getTitle(){
        return messageTitle.getText();
    }

    @Override
    public HomePageBase clickContinue(){
        continueBtn.click();
        return initPage(HomePageBase.class, driver);
    }


}
