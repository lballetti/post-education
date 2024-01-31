package com.solvd;

import org.openqa.selenium.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.solvd.saucedemo.gui.common.CartPageBase;
import com.solvd.saucedemo.gui.common.HomePageBase;
import com.solvd.saucedemo.gui.common.InfoPageBase;
import com.solvd.saucedemo.gui.common.MessagePageBase;
import com.solvd.saucedemo.gui.common.OverviewPageBase;
import com.zebrunner.carina.core.IAbstractTest;

public class SaucedemoTests implements IAbstractTest{
    
    private static final Logger logger = LoggerFactory.getLogger(SaucedemoTests.class);

    @BeforeMethod
    public void beforeClassMethod(){
        getDriver().get("https://www.saucedemo.com/");
        getDriver().manage().addCookie(new Cookie("session-username","standard_user"));
        logger.info("cookie loaded");
    }

    @Test
    public void checkoutTest(){
        getDriver().get("https://www.saucedemo.com/inventory.html");
        HomePageBase homePage = initPage(HomePageBase.class, getDriver());
        homePage.addItemToCart("Sauce Labs Backpack");
        CartPageBase cartPage = homePage.clickCart();
        InfoPageBase infoPage = cartPage.checkout();
        OverviewPageBase overviewPage = infoPage.finishOrder();
        MessagePageBase messagePage = overviewPage.order();
        Assert.assertTrue(messagePage.isOrderSuccessful(), "Order was not successful!");
    }

}
