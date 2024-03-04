package com.solvd.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductsPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ProductsPage.class);

    @FindBy(css = ".features_items div.col-sm-4")
    private List<WebElement> products;

    @FindBy(css = "input#search_product")
    private WebElement searchInput;

    @FindBy(css = "button#submit_search")
    private WebElement submitSearch;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void logItems() {
        for (WebElement webElement : products) {
            logger.info(webElement.findElement(By.cssSelector(".productinfo p")).getText());
        }
    }

    public ProductsPage search(String s) {
        sendKeys(searchInput, "Search Input", s);
        click(submitSearch, "Search button");
        return new ProductsPage(getDriver());
    }

    public List<WebElement> getProducts() {
        return products;
    }
}
