package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.solvd.components.SigninComponent;

public class Homepage extends AbstractPage{
    
    @FindBy(css = ".search-container input")
    private WebElement searchBox;

    @FindBy(css = "[data-id= gnav-search-submit-button]")
    private WebElement searchButton;

    @FindBy(css = "button.signin-header-action")
    private WebElement signinButton;
    
    public Homepage(WebDriver driver){
        super(driver);
        getDriver().get("https://www.etsy.com");
    }

    public Searchpage search(String s){
        sendKeys(searchBox, "Search Box", s);
        click(searchButton, "Search Button");
        return new Searchpage(getDriver());
    }

    public SigninComponent clickSignin(){
        click(signinButton, "Sign in button");
        return new SigninComponent(getDriver());
    }
}
