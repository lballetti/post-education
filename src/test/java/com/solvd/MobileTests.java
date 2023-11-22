package com.solvd;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.solvd.common.HomepageBase;
import com.solvd.common.ProductsPageBase;
import com.solvd.utils.MobileContextUtils;
import com.solvd.utils.MobileContextUtils.View;
import com.zebrunner.carina.core.IAbstractTest;

public class MobileTests implements IAbstractTest{
    
    private static final Logger logger = LoggerFactory.getLogger(MobileTests.class);
 
    @Test(testName = "new Tab test")
    public void searchItemsTest(){
        HomepageBase homepage = initPage(HomepageBase.class, getDriver());
        homepage.open();
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(View.NATIVE);
        getDriver().findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Switch or close tabs\"]")).click();
        getDriver().findElement(By.xpath("//android.widget.ImageView[@content-desc=\"New tab\"]")).click();
        contextHelper.switchMobileContext(View.WEB);
        getDriver().get("https://www.automationexercise.com/");
        ProductsPageBase productsPage = homepage.getHeader().clickProducts();
        productsPage.logItems();
        logger.info("searchItemsTest PASSED");
    }
}
