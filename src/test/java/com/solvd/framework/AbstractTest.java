package com.solvd.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public abstract class AbstractTest {
    
    private ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driverThread.get();
    }
    public AbstractTest(){
    }

    @BeforeTest
    public void beforeTest(){
        driverThread.set(new ChromeDriver());
    }

    @AfterClass
    public void afterTest(){
        driverThread.remove();;
    }
}
