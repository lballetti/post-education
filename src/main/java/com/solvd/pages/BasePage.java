package com.solvd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class BasePage extends AbstractPage {


    // Header locators 
    // ----------------------------------------------------------------
    // Unauthenticated
    @FindBy(css = ".logo a")
    private ExtendedWebElement logo;
    @FindBy(css = ".nav i.fa-home")
    private ExtendedWebElement homeBtn;
    @FindBy(css = "a[href='/products']")
    private ExtendedWebElement productsBtn;
    @FindBy(css = ".nav i.fa-shopping-cart")
    private ExtendedWebElement cartBtn;
    @FindBy(css = ".nav i.fa-lock")
    private ExtendedWebElement authBtn;
    @FindBy(css = ".nav i.fa-envelope")
    private ExtendedWebElement contactBtn;

    // Authenticated
    @FindBy(css = ".nav i.fa-user")
    private ExtendedWebElement loggedinMessage;
    @FindBy(css = ".nav i.fa-trash-o")
    private ExtendedWebElement deleteAccount;

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogo() {
        click(logo);
    }

    public Homepage clickHome() {
        click(homeBtn);
        return new Homepage(getDriver());
    }

    public ProductsPage clickProducts() {
        click(productsBtn);
        return new ProductsPage(getDriver());
    }

    public CartPage clickCart() {
        click(cartBtn);
        return new CartPage(getDriver());
    }

    public AuthPage clickAuth() {
        click(authBtn);
        return new AuthPage(getDriver());
    }

    public void clickContact() {
        click(contactBtn);
    }

    public MessagePage clickDeleteAcc(){
        click(deleteAccount);
        return new MessagePage(getDriver());
    }

    public boolean isLoggedin(){
        return loggedinMessage.isVisible();
    }

    protected void click(ExtendedWebElement element) {
        
        element.click();
        deleteAds();
    }

    private void deleteAds(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
        driver.findElement(By.xpath("//html")).click();
    }
}
