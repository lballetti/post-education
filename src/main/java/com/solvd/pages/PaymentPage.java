package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{
    
    @FindBy(css = "[data-qa='name-on-card']")
    private WebElement nameOnCardInput;

    @FindBy(css = "[data-qa='card-number']")
    private WebElement cardNumberInput;

    @FindBy(css = "[data-qa='cvc']")
    private WebElement cvcInput;

    @FindBy(css = "[data-qa='expiry-month']")
    private WebElement expiryMonthInput;

    @FindBy(css = "[data-qa='expiry-year']")
    private WebElement expiryYearInput;

    @FindBy(css = "data-qa='pay-button']")
    private WebElement payBtn;

    protected PaymentPage(WebDriver driver) {
        super(driver);
    }
    
    public void setCardName(String cardName){
        sendKeys(nameOnCardInput, "Name on Card Input", cardName);
    }

    public void setCardNumber(String cardNumber){
        sendKeys(cardNumberInput, "Card Number Input", cardNumber);
    }

    public void setCVC(int cvc){
        sendKeys(cvcInput, "cvc Input", cvc+"");
    }

    public void setExpiryMonth(int month){
        sendKeys(expiryMonthInput, "Expiry month Input", month+"");
    }

    public void setExpiryYear(int year){
        sendKeys(expiryYearInput, "Expiry Year Input", year+"");
    }

    public MessagePage clickPay(){
        click(payBtn, "Pay Button");
        return new MessagePage(getDriver());
    }
}
