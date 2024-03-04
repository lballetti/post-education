package com.solvd.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.LoginPageBase;
import com.solvd.common.CartPageBase;
import com.solvd.common.HomePageBase;
import com.solvd.common.MessagePageBase;
import com.solvd.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class Header extends AbstractUIObject implements ICustomTypePageFactory{
    
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

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickLogo() {
        click(logo);
    }

    public HomePageBase clickHome() {
        click(homeBtn);
        return initPage(HomePageBase.class, driver);
    }

    public ProductsPageBase clickProducts() {
        click(productsBtn);
        return initPage(ProductsPageBase.class, driver);
    }

    public CartPageBase clickCart() {
        click(cartBtn);
        return initPage(CartPageBase.class, driver);
    }

    public LoginPageBase clickAuth() {
        click(authBtn);
        return initPage(LoginPageBase.class, driver);
    }

    public void clickContact() {
        click(contactBtn);
    }

    public MessagePageBase clickDeleteAcc(){
        click(deleteAccount);
        return initPage(MessagePageBase.class, driver);
    }

    public boolean isLoggedin(){
        return loggedinMessage.isVisible();
    }

    protected void click(ExtendedWebElement element) {
        
        element.click();
        deleteAds();
    }

    protected void deleteAds(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate'); while (elements.length > 0) elements[0].remove()");
        driver.findElement(By.xpath("//html")).click();
    }
}
