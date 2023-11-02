package com.solvd;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.solvd.pages.Homepage;
import com.solvd.pages.Searchpage;

public class UnauthenticatedTests {

    private static final Logger logger = LogManager.getLogger(UnauthenticatedTests.class);

    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
 
    @Test
    public void searchItems(){
        
        driver.get("https://www.etsy.com");
        Homepage homepage = new Homepage(driver);
        Searchpage searchpage = homepage.search("dice");
        List<WebElement> elements = searchpage.getSearchResults();
        Assert.assertTrue(elements.size() == 64);
        for (WebElement webElement : elements) {
            logger.info(webElement.findElement(By.cssSelector("h3")).getAttribute("title"));
        }

        logger.info("Test finished");
    }
}
