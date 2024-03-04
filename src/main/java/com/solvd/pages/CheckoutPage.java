package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(css = "a.check_out")
    private WebElement checkoutBtn;

    protected CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage clickPlaceOrder() {
        click(checkoutBtn, "Place Order button");
        return new PaymentPage(getDriver());
    }
}
