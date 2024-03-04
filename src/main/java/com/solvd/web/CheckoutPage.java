package com.solvd.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.CheckoutPageBase;
import com.solvd.common.PaymentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase{

    @FindBy(css = "a.check_out")
    private ExtendedWebElement checkoutBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
        
    @Override
    public PaymentPageBase clickPlaceOrder(){
        checkoutBtn.click();
        return initPage(PaymentPageBase.class, driver);
    }


}
