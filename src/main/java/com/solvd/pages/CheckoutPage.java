package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class CheckoutPage extends BasePage{

    @FindBy(css = "a.check_out")
    private ExtendedWebElement checkoutBtn;

    protected CheckoutPage(WebDriver driver) {
        super(driver);
    }
    
    public PaymentPage clickPlaceOrder(){
        click(checkoutBtn);
        return new PaymentPage(getDriver());
    }
}
