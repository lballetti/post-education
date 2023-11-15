package com.solvd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.pages.AuthPage;
import com.solvd.pages.Homepage;
import com.solvd.pages.MessagePage;
import com.solvd.pages.ProductsPage;
import com.solvd.pages.SignupPage;
import com.zebrunner.carina.core.IAbstractTest;

public class UnauthenticatedTests implements IAbstractTest{

    private static final Logger logger = LoggerFactory.getLogger(UnauthenticatedTests.class);
 
    @Test(testName = "searchItemsTest")
    public void searchItemsTest(){
        Homepage homepage = new Homepage(getDriver());
        homepage.open();
        homepage.clickProducts();
        ProductsPage productsPage = homepage.clickProducts();
        productsPage.logItems();
        logger.info("searchItemsTest PASSED");
    }

    @Test(testName = "loginInvalidTest")
    public void loginInvalidTest(){
        Homepage homepage = new Homepage(getDriver());
        homepage.open();
        AuthPage authPage = homepage.clickAuth();
        authPage.login("riroy86360@jybra.com", "Failpass");
        Assert.assertTrue(authPage.IsErrorShown());
        logger.info("loginInvalidTest PASSED");
    }

    @Test(testName = "searchProductsTest")
    public void searchProductTest(){
        Homepage homepage = new Homepage(getDriver());
        homepage.open();
        homepage.clickProducts();
        ProductsPage productsPage = homepage.clickProducts();
        productsPage = productsPage.search("polo");
        Assert.assertTrue(productsPage.isProductPresent("Premium Polo T-Shirts"));
        logger.info("searchProductTest PASSED");
    }

    @Test(testName = "signupAndDelete")
    public void signupAndDeleteTest(){
        Homepage homepage = new Homepage(getDriver());
        homepage.open();
        AuthPage authPage = homepage.clickAuth();
        SignupPage signupPage= authPage.signup("deletableAccount", "deletableAccount@delete.acc");
        MessagePage messagePage = signupPage.fillWithStandardData();
        Assert.assertEquals(messagePage.getTitle(),"ACCOUNT CREATED!");
        homepage = messagePage.clickHome();
        messagePage.clickHome();
        messagePage = homepage.clickDeleteAcc();
        Assert.assertEquals(messagePage.getTitle(), "ACCOUNT DELETED!");
        logger.info("signupAndDeleteTest PASSED");
    }

    @Test(testName = "failTest")
    public void failTest(){
        Homepage homepage = new Homepage(getDriver());
        homepage.open();
        AuthPage authPage = homepage.clickAuth();
        Assert.assertTrue(authPage.IsErrorShown());
    }
}
