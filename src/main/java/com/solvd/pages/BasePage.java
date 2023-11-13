package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.solvd.framework.AbstractPage;

public class BasePage extends AbstractPage {

    // Header locators 
    // ----------------------------------------------------------------
    // Unauthenticated
    @FindBy(css = ".logo a")
    private WebElement logo;
    @FindBy(css = ".nav i.fa-home")
    private WebElement homeBtn;
    @FindBy(css = "a[href='/products']")
    private WebElement productsBtn;
    @FindBy(css = ".nav i.fa-shopping-cart")
    private WebElement cartBtn;
    @FindBy(css = ".nav i.fa-lock")
    private WebElement authBtn;
    @FindBy(css = ".nav i.fa-envelope")
    private WebElement contactBtn;

    // Authenticated
    @FindBy(css = ".nav i.fa-user")
    private WebElement loggedinMessage;
    @FindBy(css = ".nav i.fa-trash-o")
    private WebElement deleteAccount;

    protected BasePage(WebDriver driver) {
        super(driver);
    }

    public void clickLogo() {
        click(logo, "Logo");
    }

    public Homepage clickHome() {
        click(homeBtn, "Home button");
        return new Homepage(getDriver());
    }

    public ProductsPage clickProducts() {
        click(productsBtn, "Products button");
        return new ProductsPage(getDriver());
    }

    public void clickCart() {
        click(cartBtn, "Cart button");
    }

    public AuthPage clickAuth() {
        click(authBtn, "Signup/login button");
        return new AuthPage(getDriver());
    }

    public void clickContact() {
        click(contactBtn, "Contact us button");
    }

    public MessagePage clickDeleteAcc(){
        click(deleteAccount, "Delete Account Button");
        return new MessagePage(getDriver());
    }

    public boolean isLoggedin(){
        refreshElements();
        return loggedinMessage.isDisplayed();
    }
}
