package com.solvd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.solvd.common.LoginPageBase;
import com.solvd.common.CartPageBase;
import com.solvd.common.CheckoutPageBase;
import com.solvd.common.HomePageBase;
import com.solvd.common.MessagePageBase;
import com.solvd.common.PaymentPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class LoggedinTests implements IAbstractTest{
    
    private static final Logger logger = LoggerFactory.getLogger(LoggedinTests.class);

    @BeforeMethod
    public void beforeClassMethod(){
        HomePageBase homepage = initPage(HomePageBase.class, getDriver());
        homepage.open();
        LoginPageBase loginPage = homepage.getHeaderMenu().clickAuth();
        loginPage.getLoginForm().login("riroy86360@jybra.com", "Thisistestingaccount1.");
    }

    @Test
    public void checkoutTest(){
        HomePageBase homepage = initPage(HomePageBase.class, getDriver());
        CartPageBase cartPage = homepage.addToCartandView(0);
        CheckoutPageBase checkoutPage = cartPage.clickCheckout();
        PaymentPageBase paymentPage = checkoutPage.clickPlaceOrder();
        paymentPage.setCardName("Riroy");
        paymentPage.setCardNumber("2351783928493847");
        paymentPage.setCVC(123);
        paymentPage.setExpiryMonth(11);
        paymentPage.setExpiryYear(2024);
        MessagePageBase messagePage = paymentPage.clickPay();
        Assert.assertEquals(messagePage.getTitle(), "ORDER PLACED!");
        logger.info("checkoutTest PASSED");
    }

    @Test
    public void removeItemFromCartTest(){
        HomePageBase homepage = initPage(HomePageBase.class, getDriver());
        CartPageBase cartPage = homepage.addToCartandView("Men Tshirt");
        cartPage.deleteFromCart("Men Tshirt");
        Assert.assertTrue(cartPage.isItemPresent("Men Tshirt"));
    }

}
