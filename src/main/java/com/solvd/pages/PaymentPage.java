package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class PaymentPage extends BasePage{
    
    @FindBy(css = "[data-qa='name-on-card']")
    private ExtendedWebElement nameOnCardInput;

    @FindBy(css = "[data-qa='card-number']")
    private ExtendedWebElement cardNumberInput;

    @FindBy(css = "[data-qa='cvc']")
    private ExtendedWebElement cvcInput;

    @FindBy(css = "[data-qa='expiry-month']")
    private ExtendedWebElement expiryMonthInput;

    @FindBy(css = "[data-qa='expiry-year']")
    private ExtendedWebElement expiryYearInput;

    @FindBy(css = "data-qa='pay-button']")
    private ExtendedWebElement payBtn;

    protected PaymentPage(WebDriver driver) {
        super(driver);
    }
    
    public void setCardName(String cardName){
        nameOnCardInput.type(cardName);
    }

    public void setCardNumber(String cardNumber){
        cardNumberInput.type(cardNumber);
    }

    public void setCVC(int cvc){
        cvcInput.type(cvc+"");
    }

    public void setExpiryMonth(int month){
        expiryMonthInput.type(month+"");
    }

    public void setExpiryYear(int year){
        expiryYearInput.type(year+"");
    }

    public MessagePage clickPay(){
        click(payBtn);
        return new MessagePage(getDriver());
    }
}
