package com.solvd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.common.LoginPageBase;
import com.solvd.common.HomePageBase;
import com.solvd.common.MessagePageBase;
import com.solvd.common.ProductsPageBase;
import com.solvd.common.SignupPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class UnauthenticatedTests implements IAbstractTest{

    private static final Logger logger = LoggerFactory.getLogger(UnauthenticatedTests.class);
 
    @Test(testName = "searchItemsTest")
    public void searchItemsTest(){
        HomePageBase homepage = initPage(HomePageBase.class, getDriver());
        homepage.open();
        homepage.getHeaderMenu().clickProducts();
        ProductsPageBase productsPage = homepage.getHeaderMenu().clickProducts();
        productsPage.logItems();
        logger.info("searchItemsTest PASSED");
    }

    @Test(testName = "loginInvalidTest")
    public void loginInvalidTest(){
        HomePageBase homepage = initPage(HomePageBase.class, getDriver());
        homepage.open();
        LoginPageBase loginPage = homepage.getHeaderMenu().clickAuth();
        loginPage.getLoginForm().login("riroy86360@jybra.com", "Failpass");
        Assert.assertTrue(loginPage.getLoginForm().IsErrorShown());
        logger.info("loginInvalidTest PASSED");
    }

    @Test(testName = "searchProductsTest")
    public void searchProductTest(){
        HomePageBase homepage = initPage(HomePageBase.class, getDriver());
        homepage.open();
        homepage.getHeaderMenu().clickProducts();
        ProductsPageBase productsPage = homepage.getHeaderMenu().clickProducts();
        productsPage = productsPage.search("polo");
        Assert.assertTrue(productsPage.isProductPresent("Premium Polo T-Shirts"));
        logger.info("searchProductTest PASSED");
    }

    @Test(testName = "signupAndDelete")
    public void signupAndDeleteTest(){
        HomePageBase homepage = initPage(HomePageBase.class, getDriver());
        homepage.open();
        LoginPageBase loginPage = homepage.getHeaderMenu().clickAuth();
        SignupPageBase signupPage= loginPage.getSignupForm().signup("deletableAccount", "deletableAccount@delete.acc");
        MessagePageBase messagePage = signupPage.fillWithStandardData();
        Assert.assertEquals(messagePage.getTitle(),"ACCOUNT CREATED!");
        homepage = messagePage.getHeaderMenu().clickHome();        messagePage.getHeaderMenu().clickHome();
        messagePage = homepage.getHeaderMenu().clickDeleteAcc();
        Assert.assertEquals(messagePage.getTitle(), "ACCOUNT DELETED!");
        logger.info("signupAndDeleteTest PASSED");
    }

    // @Test(testName = "failTest")
    // public void failTest(){
    //     HomepageBase homepage = initPage(HomepageBase.class, getDriver());
    //     homepage.open();
    //     loginPageBase loginPage = homepage.getHeaderMenu().clickAuth();
    //     Assert.assertTrue(loginPage.IsErrorShown());
    // }
}
