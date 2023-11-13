package com.solvd;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.framework.AbstractTest;
import com.solvd.pages.AuthPage;
import com.solvd.pages.Homepage;
import com.solvd.pages.MessagePage;
import com.solvd.pages.ProductsPage;
import com.solvd.pages.SignupPage;

public class UnauthenticatedTests extends AbstractTest{

    private static final Logger logger = LoggerFactory.getLogger(UnauthenticatedTests.class);
 
    @Test(threadPoolSize = 2, testName = "searchItemsTest")
    public void searchItemsTest(){
        getDriver().get(url);
        Homepage homepage = new Homepage(getDriver());
        ProductsPage productsPage = homepage.clickProducts();
        productsPage.logItems();
        logger.info("searchItemsTest PASSED");
    }

    @Test(testName = "loginInvalidTest")
    public void loginInvalidTest(){
        getDriver().get(url);
        Homepage homepage = new Homepage(getDriver());
        AuthPage authPage = homepage.clickAuth();
        authPage.login("riroy86360@jybra.com", "Failpass");
        Assert.assertTrue(authPage.IsErrorShown());
        logger.info("loginInvalidTest PASSED");
    }

    @Test(testName = "searchProductsTest")
    public void searchProductTest(){
        getDriver().get(url);
        Homepage homepage = new Homepage(getDriver());
        ProductsPage productsPage = homepage.clickProducts();
        productsPage = productsPage.search("polo");
        Assert.assertTrue(productsPage.getProducts().get(0).findElement(By.cssSelector(".productinfo p")).getText().equals("Premium Polo T-Shirts"));
        logger.info("searchProductTest PASSED");
    }

    @Test(testName = "signupAndDelete")
    public void signupAndDeleteTest(){
        getDriver().get(url);
        Homepage homepage = new Homepage(getDriver());
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
        getDriver().get(url);
        Homepage homepage = new Homepage(getDriver());
        AuthPage authPage = homepage.clickAuth();
        Assert.assertEquals(false, true);
    }
}
