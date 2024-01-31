package com.solvd.saucedemo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class ItemBox extends AbstractUIObject {

    @FindBy(css = ".inventory_item_name")
    private ExtendedWebElement itemName;

    @FindBy(css = ".pricebar button")
    private ExtendedWebElement addToCartBtn;

    public ItemBox(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    
    public void addToCart(){
        addToCartBtn.click();
    }

    public String getItemName() {
        return itemName.getText();
    }
}
