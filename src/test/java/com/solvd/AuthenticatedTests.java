package com.solvd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.solvd.framework.AbstractTest;
import com.solvd.pages.LoginPage;
import com.solvd.pages.CartPage;
import com.solvd.pages.CheckoutPage;
import com.solvd.pages.HomePage;
import com.solvd.pages.MessagePage;
import com.solvd.pages.PaymentPage;

public class AuthenticatedTests extends AbstractTest {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticatedTests.class);
    private HomePage homepage;

    @BeforeMethod
    public void beforeClassMethod() {
        getDriver().get(url);
        homepage = new HomePage(getDriver());
        LoginPage authPage = homepage.clickLogin();
        authPage.login("riroy86360@jybra.com", "Thisistestingaccount1.");
    }

    @Test
    public void checkoutTest() {
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
    public void removeItemFromCartTest() {
        CartPage cartPage = homepage.addToCartandView(0);
        cartPage.deleteFromCart(0);
        Assert.assertTrue(cartPage.getCartItems().get(0).isDisplayed());
    }

}
