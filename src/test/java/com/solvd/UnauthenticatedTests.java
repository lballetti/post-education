package com.solvd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.common.AuthPageBase;
import com.solvd.common.HomepageBase;
import com.solvd.common.MessagePageBase;
import com.solvd.common.ProductsPageBase;
import com.solvd.common.SignupPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class UnauthenticatedTests implements IAbstractTest{

    private static final Logger logger = LoggerFactory.getLogger(UnauthenticatedTests.class);
 
    @Test(testName = "searchItemsTest")
    public void searchItemsTest(){
        HomepageBase homepage = initPage(HomepageBase.class, getDriver());
        homepage.open();
        homepage.getHeader().clickProducts();
        ProductsPageBase productsPage = homepage.getHeader().clickProducts();
        productsPage.logItems();
        logger.info("searchItemsTest PASSED");
    }

    @Test(testName = "loginInvalidTest")
    public void loginInvalidTest(){
        HomepageBase homepage = initPage(HomepageBase.class, getDriver());
        homepage.open();
        AuthPageBase authPage = homepage.getHeader().clickAuth();
        authPage.login("riroy86360@jybra.com", "Failpass");
        Assert.assertTrue(authPage.IsErrorShown());
        logger.info("loginInvalidTest PASSED");
    }

    @Test(testName = "searchProductsTest")
    public void searchProductTest(){
        HomepageBase homepage = initPage(HomepageBase.class, getDriver());
        homepage.open();
        homepage.getHeader().clickProducts();
        ProductsPageBase productsPage = homepage.getHeader().clickProducts();
        productsPage = productsPage.search("polo");
        Assert.assertTrue(productsPage.isProductPresent("Premium Polo T-Shirts"));
        logger.info("searchProductTest PASSED");
    }

    @Test(testName = "signupAndDelete")
    public void signupAndDeleteTest(){
        HomepageBase homepage = initPage(HomepageBase.class, getDriver());
        homepage.open();
        AuthPageBase authPage = homepage.getHeader().clickAuth();
        SignupPageBase signupPage= authPage.signup("deletableAccount", "deletableAccount@delete.acc");
        MessagePageBase messagePage = signupPage.fillWithStandardData();
        Assert.assertEquals(messagePage.getTitle(),"ACCOUNT CREATED!");
        homepage = messagePage.getHeader().clickHome();
        messagePage.getHeader().clickHome();
        messagePage = homepage.getHeader().clickDeleteAcc();
        Assert.assertEquals(messagePage.getTitle(), "ACCOUNT DELETED!");
        logger.info("signupAndDeleteTest PASSED");
    }

    // @Test(testName = "failTest")
    // public void failTest(){
    //     HomepageBase homepage = initPage(HomepageBase.class, getDriver());
    //     homepage.open();
    //     AuthPageBase authPage = homepage.getHeader().clickAuth();
    //     Assert.assertTrue(authPage.IsErrorShown());
    // }
}
