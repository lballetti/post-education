package com.solvd.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Searchpage extends AbstractPage{

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
        super(driver);
    }

    public Searchpage setFilter(String ...filters){
        click(filterButton, "Open Filters button");
        for(String filter : filters){
            getDriver().findElement(By.xpath("//label[contains(text(),'" + filter +"')]")).click();
        }
        click(applyFilter, "Apply Filter button");
        click(filterButton, "Open Filters button");
        click(applyFilter, "Apply Filter button");
        return new Searchpage(getDriver());
    }

    public List<WebElement> getSearchResults() {
        // searchResults = getDriver().findElements(By.cssSelector("div[data-search-results] li"));
        return searchResults;
    }
}
