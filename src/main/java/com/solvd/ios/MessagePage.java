package com.solvd.ios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.HomepageBase;
import com.solvd.common.MessagePageBase;
import com.solvd.components.Header;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MessagePageBase.class)
public class MessagePage extends MessagePageBase{

    @FindBy(id = "header")
    private Header header;

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
    public HomepageBase clickContinue(){
        continueBtn.click();
        return initPage(HomepageBase.class, driver);
    }

    @Override
    public Header getHeader() {
        return header;
    }
    
}
