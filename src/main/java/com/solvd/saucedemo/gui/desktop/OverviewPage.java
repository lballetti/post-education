package com.solvd.saucedemo.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemo.gui.common.MessagePageBase;
import com.solvd.saucedemo.gui.common.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = OverviewPageBase.class)
public class OverviewPage extends OverviewPageBase{

    @FindBy(css = "#finish")
    private ExtendedWebElement finishBtn;
    
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MessagePageBase order() {
        finishBtn.click();
        return initPage(MessagePageBase.class, getDriver());
    }
    
}
