package com.solvd;

import org.openqa.selenium.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.solvd.common.AuthPageBase;
import com.solvd.common.CartPageBase;
import com.solvd.common.CheckoutPageBase;
import com.solvd.common.HomepageBase;
import com.solvd.common.MessagePageBase;
import com.solvd.common.PaymentPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class AuthenticatedTests implements IAbstractTest{
    
    private static final Logger logger = LoggerFactory.getLogger(AuthenticatedTests.class);

    Cookie cookie1;

    @BeforeClass
    public void beforeClassMethod(){
        HomepageBase homepage = initPage(HomepageBase.class, getDriver());
        homepage.open();
        AuthPageBase authPage = homepage.getHeader().clickAuth();
        authPage.login("riroy86360@jybra.com", "Thisistestingaccount1.");
        cookie1 = getDriver().manage().getCookieNamed("sessionid");
    }

    @BeforeMethod
    public void beforeMethodMethod(){
        getDriver().manage().addCookie(cookie1);
    }

    @Test
    public void checkoutTest(){
        HomepageBase homepage = initPage(HomepageBase.class, getDriver());
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
        HomepageBase homepage = initPage(HomepageBase.class, getDriver());
        CartPageBase cartPage = homepage.addToCartandView("Men Tshirt");
        cartPage.deleteFromCart("Men Tshirt");
        Assert.assertTrue(cartPage.isItemPresent("Men Tshirt"));
    }

}
