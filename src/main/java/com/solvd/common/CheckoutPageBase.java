package com.solvd.common;

import org.openqa.selenium.WebDriver;


public abstract class CheckoutPageBase extends SitePageBase{

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract PaymentPageBase clickPlaceOrder();

}
