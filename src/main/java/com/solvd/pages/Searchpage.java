package com.solvd.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Searchpage {
    
    private WebDriver driver;

    @FindBy(css = ".search-container input")
    private WebElement searchBox;
    @FindBy(css = "[data-id='gnav-search-submit-button']")
    private WebElement searchButton;
    @FindBy(css = "#search-filter-button")
    private WebElement filterButton;
    @FindBy(css = "button[data-filter-form-apply-button]")
    private WebElement applyFilter;
    @FindBy(css = "div[data-search-results] li")
    private List<WebElement> searchResults;
    
    public Searchpage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String s){
        searchBox.sendKeys(s);
        searchButton.click();
    }

    public void setFilter(String ...filters){
        filterButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        for(String filter : filters){
            driver.findElement(By.xpath("//label[contains(text(),'" + filter +"')]")).click();
        }
        applyFilter.click();
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }
}
