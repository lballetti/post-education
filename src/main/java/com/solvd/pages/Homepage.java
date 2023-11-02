package com.solvd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    private WebDriver driver;

    @FindBy(css = ".search-container input")
    private WebElement searchBox;
    @FindBy(css = "[data-id= gnav-search-submit-button]")
    private WebElement searchButton;
    
    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Searchpage search(String s){
        searchBox.sendKeys(s);
        searchButton.click();
        return new Searchpage(driver);
    }
}
