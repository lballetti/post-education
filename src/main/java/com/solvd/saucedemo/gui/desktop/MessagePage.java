package com.solvd.saucedemo.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemo.gui.common.MessagePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = MessagePageBase.class)
public class MessagePage extends MessagePageBase{

    @FindBy(css = ".complete-header")
    private ExtendedWebElement messageHeader;

    public MessagePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOrderSuccessful() {
        return messageHeader.getText().equals("Thank you for your order!");
    }
    
}
