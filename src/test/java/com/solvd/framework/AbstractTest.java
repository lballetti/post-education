package com.solvd.framework;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {
    
    private ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    protected Properties properties = new Properties();
    protected String url;
    private static final Logger logger = LoggerFactory.getLogger(AbstractTest.class);

    public WebDriver getDriver() {
        return driverThread.get();
    }
    public void setDriver(WebDriver driver) {
        driverThread.set(driver);
    }
    public AbstractTest(){
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
            url = properties.getProperty("url");
            logger.debug("Properties loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to load config.properties" + e);
        }
    }

    @BeforeMethod
    public void beforeMethodMethod(){
        setUpDriver(properties.getProperty("browserName"));
    }

    @AfterClass
    public void afterTest(){
        getDriver().close();
        driverThread.remove();
    }

    public void setUpDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            setDriver(new ChromeDriver());
        }else if (browserName.equalsIgnoreCase("safari")){
            setDriver(new SafariDriver());
        }else if (browserName.equalsIgnoreCase("firefox")) {
            setDriver(new FirefoxDriver());
        }
    }
}
