package com.solvd.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.CheckoutPageBase;
import com.solvd.common.PaymentPageBase;
import com.solvd.components.Header;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase{

    @FindBy(id = "header")
    private Header header;

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

    @Override
    public Header getHeader() {
        return header;
    }
}
