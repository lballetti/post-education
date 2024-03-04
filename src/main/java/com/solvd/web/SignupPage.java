package com.solvd.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.MessagePageBase;
import com.solvd.common.SignupPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SignupPageBase.class)
public class SignupPage extends SignupPageBase{

    @FindBy(css = "[data-qa='password']")
    private ExtendedWebElement passInput;

    @FindBy(css = "[data-qa='first_name']")
    private ExtendedWebElement firstName;

    @FindBy(css = "[data-qa='last_name']")
    private ExtendedWebElement lastName;

    @FindBy(css = "[data-qa='address']")
    private ExtendedWebElement address;

    @FindBy(css = "[data-qa='state']")
    private ExtendedWebElement state;

    @FindBy(css = "[data-qa='city']")
    private ExtendedWebElement city;

    @FindBy(css = "[data-qa='zipcode']")
    private ExtendedWebElement zip;
    
    @FindBy(css = "[data-qa='mobile_number']")
    private ExtendedWebElement mobileNumber;

    @FindBy(css = "[data-qa='create-account']")
    private ExtendedWebElement createAccBtn;

    public SignupPage(WebDriver driver) {
        super(driver);
    }
    
    @Override
    public MessagePageBase fillWithStandardData(){
        passInput.type("deletepass");
        firstName.type("delete");
        lastName.type("account");
        address.type("Fake Street 123");
        state.type("Ohio");
        city.type( "Paris");
        zip.type( "123456");
        mobileNumber.type( "654321");
        createAccBtn.click();
        return initPage(MessagePageBase.class, driver);
    }

}
