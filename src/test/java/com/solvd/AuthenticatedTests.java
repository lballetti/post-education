package com.solvd;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.solvd.framework.AbstractTest;
import com.solvd.pages.Homepage;

public class AuthenticatedTests extends AbstractTest{
    
    private static final Logger logger = LoggerFactory.getLogger(UnauthenticatedTests.class);

    //It gets detected as a bot
    @Test
    public void loginTest(){
        Homepage homepage = new Homepage(getDriver());
        homepage.clickSignin().login("riroy86360@jybra.com", "Thisistestingaccount1.");
        homepage.waitElement(By.cssSelector("h1.welcome-message-text:first-child"));
        Assert.assertTrue(getDriver().findElement(By.cssSelector("h1.welcome-message-text:first-child")).getText().contains("Welcome back, Jack!"));
        logger.info("Logged in successfully");
    }
}
