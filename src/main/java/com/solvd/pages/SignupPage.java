package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {

    @FindBy(css = "[data-qa='password']")
    private WebElement passInput;

    @FindBy(css = "[data-qa='first_name']")
    private WebElement firstName;

    @FindBy(css = "[data-qa='last_name']")
    private WebElement lastName;

    @FindBy(css = "[data-qa='address']")
    private WebElement address;

    @FindBy(css = "[data-qa='state']")
    private WebElement state;

    @FindBy(css = "[data-qa='city']")
    private WebElement city;

    @FindBy(css = "[data-qa='zipcode']")
    private WebElement zip;

    @FindBy(css = "[data-qa='mobile_number']")
    private WebElement mobileNumber;

    @FindBy(css = "[data-qa='create-account']")
    private WebElement createAccBtn;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public MessagePage fillWithStandardData() {
        sendKeys(passInput, "Password Input", "deletepass");
        sendKeys(firstName, "First name input", "delete");
        sendKeys(lastName, "Last name input", "account");
        sendKeys(address, "Address input", "Fake Street 123");
        sendKeys(state, "State input", "Ohio");
        sendKeys(city, "City input", "Paris");
        sendKeys(zip, "Zipcode input", "123456");
        sendKeys(mobileNumber, "Mobile Number input", "654321");
        click(createAccBtn, "Create Account Button");
        return new MessagePage(getDriver());
    }
}
