package com.solvd.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.MessagePageBase;
import com.solvd.common.PaymentPageBase;
import com.solvd.components.Header;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PaymentPageBase.class)
public class PaymentPage extends PaymentPageBase{

    @FindBy(id = "header")
    private Header header;
    
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

    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    
    @Override
    public void setCardName(String cardName){
        nameOnCardInput.type(cardName);
    }

    @Override
    public void setCardNumber(String cardNumber){
        cardNumberInput.type(cardNumber);
    }

    @Override
    public void setCVC(int cvc){
        cvcInput.type(cvc+"");
    }

    @Override
    public void setExpiryMonth(int month){
        expiryMonthInput.type(month+"");
    }

    @Override
    public void setExpiryYear(int year){
        expiryYearInput.type(year+"");
    }

    @Override
    public MessagePageBase clickPay(){
        payBtn.click();
        payBtn.click();
        return initPage(MessagePageBase.class, driver);
    }

    @Override
    public void fillWithStandardData(){
        setCardName("Riroy");
        setCardNumber("2351783928493847");
        setCVC(123);
        setExpiryMonth(11);
        setExpiryYear(2024);
    }

    @Override
    public Header getHeader() {
        return header;
    }
}
