package com.solvd.common;

import org.openqa.selenium.WebDriver;

public abstract class PaymentPageBase extends SitePageBase{

    public PaymentPageBase(WebDriver driver) {
        super(driver);
    }
    
    public abstract void setCardName(String cardName);

    public abstract void setCardNumber(String cardNumber);

    public abstract void setCVC(int cvc);

    public abstract void setExpiryMonth(int month);

    public abstract void setExpiryYear(int year);

    public abstract void fillWithStandardData();

    public abstract MessagePageBase clickPay();
}
