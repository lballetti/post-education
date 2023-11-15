package com.solvd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.solvd.pages.AuthPage;
import com.solvd.pages.CartPage;
import com.solvd.pages.CheckoutPage;
import com.solvd.pages.Homepage;
import com.solvd.pages.MessagePage;
import com.solvd.pages.PaymentPage;
import com.zebrunner.carina.core.IAbstractTest;

public class AuthenticatedTests implements IAbstractTest{
    
    private static final Logger logger = LoggerFactory.getLogger(AuthenticatedTests.class);
    private Homepage homepage;

    @BeforeMethod
    public void beforeClassMethod(){
        homepage = new Homepage(getDriver());
        homepage.open();
        AuthPage authPage = homepage.clickAuth();
        authPage.login("riroy86360@jybra.com", "Thisistestingaccount1.");
    }

    @Test
    public void checkoutTest(){
        CartPage cartPage = homepage.addToCartandView(0);
        CheckoutPage checkoutPage = cartPage.clickCheckout();
        PaymentPage paymentPage = checkoutPage.clickPlaceOrder();
        paymentPage.setCardName("Riroy");
        paymentPage.setCardNumber("2351783928493847");
        paymentPage.setCVC(123);
        paymentPage.setExpiryMonth(11);
        paymentPage.setExpiryYear(2024);
        MessagePage messagePage = paymentPage.clickPay();
        Assert.assertEquals(messagePage.getTitle(), "ORDER PLACED!");
        logger.info("checkoutTest PASSED");
    }

    @Test
    public void removeItemFromCartTest(){
        CartPage cartPage = homepage.addToCartandView("Men Tshirt");
        cartPage.deleteFromCart("Men Tshirt");
        Assert.assertTrue(cartPage.isItemPresent("Men Tshirt"));
    }

}
