package com.solvd.common;

import org.openqa.selenium.WebDriver;

import com.solvd.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class CheckoutPageBase extends AbstractPage{

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract PaymentPageBase clickPlaceOrder();

    public abstract Header getHeader();
}
