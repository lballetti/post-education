package com.solvd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.framework.AbstractTest;
import com.solvd.pages.Homepage;
import com.solvd.pages.Searchpage;

public class UnauthenticatedTests extends AbstractTest{

    private static final Logger logger = LoggerFactory.getLogger(UnauthenticatedTests.class);
 
    @Test
    public void searchItems(){
        getDriver().get(url);
        Homepage homepage = new Homepage(getDriver());
        Searchpage searchpage = homepage.search("dice");
        List<WebElement> elements = searchpage.getSearchResults();
        Assert.assertTrue(elements.size() == 64);
        for (WebElement webElement : elements) {
            logger.info(webElement.findElement(By.cssSelector("h3")).getAttribute("title"));
        }
        logger.info("Test finished");
    }

    @Test
    public void testFilter(){
        getDriver().get(url);
        Homepage homepage = new Homepage(getDriver());
        Searchpage searchpage = homepage.search("dice");
        searchpage = searchpage.setFilter("On sale");
        List<WebElement> elements = searchpage.getSearchResults();
        for (WebElement webElement : elements) {
            Assert.assertTrue(webElement.findElement(By.cssSelector(".search-collage-promotion-price")).getText().contains(" off)"));
        }
        logger.info("All items are on sale");
    }
}
