package com.solvd.framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPage {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
    private Wait<WebDriver> wait;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void click(WebElement element, String elementName) {
        try {
            deleteAds();
            driver.findElement(By.xpath("//html")).click();
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info("Clicked on " + elementName);
        } catch (Exception e) {
            logger.error("Error clicking on " + elementName, e);
        }
    }

    protected void sendKeys(WebElement element, String elementName, String text) {
        try {
            deleteAds();
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.sendKeys(text);
            logger.info("'" + text + "' written into " + elementName);
        } catch (Exception e) {
            logger.error("Error sending keys to " + elementName, e);
        }
    }

    protected void refreshElements() {
        PageFactory.initElements(driver, this);
    }

    private void deleteAds() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
    }
}
