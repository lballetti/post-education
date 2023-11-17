package com.solvd.common;

import org.openqa.selenium.WebDriver;

import com.solvd.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class PaymentPageBase extends AbstractPage{

    public PaymentPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract void setCardName(String cardName);

    public abstract void setCardNumber(String cardNumber);

    public abstract void setCVC(int cvc);

    public abstract void setExpiryMonth(int month);

    public abstract void setExpiryYear(int year);

    public abstract MessagePageBase clickPay();

    public abstract Header getHeader();
}
