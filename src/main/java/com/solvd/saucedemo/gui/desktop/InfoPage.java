package com.solvd.saucedemo.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemo.gui.common.InfoPageBase;
import com.solvd.saucedemo.gui.common.OverviewPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = InfoPageBase.class)
public class InfoPage extends InfoPageBase{

    @FindBy(css = "#first-name")
    private ExtendedWebElement firstNameInput;
    
    @FindBy(css = "#last-name")
    private ExtendedWebElement lastNameInput;

    @FindBy(css = "#postal-code")
    private ExtendedWebElement zipcodeInput;

    @FindBy(css = "#continue")
    private ExtendedWebElement continuebtn;

    public InfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public OverviewPageBase finishOrder() {
        firstNameInput.type("firstname");
        lastNameInput.type("lastname");
        zipcodeInput.type("zipcode");
        continuebtn.click();
        return initPage(OverviewPageBase.class, getDriver());
    }
    
}
