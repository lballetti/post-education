package com.solvd.ios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.mobile.BrowserPageBase;
import com.solvd.utils.MobileContextUtils;
import com.solvd.utils.MobileContextUtils.View;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BrowserPageBase.class)
public class BrowserPage extends BrowserPageBase{

    MobileContextUtils contextHelper;

    @FindBy(xpath = "name = 'Tabs Button'")
    @Predicate
    private ExtendedWebElement tabsBtn;

    @FindBy(xpath = "name = 'New tab Button'")
    @Predicate
    private ExtendedWebElement newTabBtn;

    public BrowserPage(WebDriver driver) {
        super(driver);
        contextHelper = new MobileContextUtils();
    }

    @Override
    public void newTab(){
        
        contextHelper.switchMobileContext(View.NATIVE);
        tabsBtn.click();
        newTabBtn.click();
        contextHelper.switchMobileContext(View.WEB_iOS);
    }
}
