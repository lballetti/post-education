package com.solvd.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.components.ItemBox;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;



public class ProductsPage extends BasePage{

    private static final Logger logger = LoggerFactory.getLogger(ProductsPage.class);

    @FindBy(css = ".features_items div.col-sm-4")
    private List<ItemBox> products;

    @FindBy(css = "input#search_product")
    private ExtendedWebElement searchInput;

    @FindBy(css = "button#submit_search")
    private ExtendedWebElement submitSearchBtn;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void logItems(){
        for (ItemBox product : products) {
            logger.info(product.getProductName());
        }
    }

    public ProductsPage search(String s){
        searchInput.type(s);
        click(submitSearchBtn);
        return new ProductsPage(getDriver());
    }

    public boolean isProductPresent(String name){
        return products.stream()
                .filter(x-> x.getProductName().contains(name))
                .findAny()
                .get() != null;
    }
}
