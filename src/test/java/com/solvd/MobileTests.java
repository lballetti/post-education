package com.solvd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.solvd.common.HomepageBase;
import com.solvd.common.ProductsPageBase;
import com.solvd.common.mobile.BrowserPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

public class MobileTests implements IAbstractTest, IMobileUtils{
    
    private static final Logger logger = LoggerFactory.getLogger(MobileTests.class);
 
    @Test(testName = "new Tab test")
    public void searchNewTabAndroidTest(){
        HomepageBase homepage = initPage(HomepageBase.class, getDriver());
        homepage.open();
        BrowserPageBase browserPageBase = initPage(BrowserPageBase.class, getDriver());
        browserPageBase.newTab();
        getDriver().get("https://www.automationexercise.com/");
        ProductsPageBase productsPage = homepage.getHeader().clickProducts();
        productsPage.logItems();
        logger.info("searchItemsTest PASSED");
    }
}