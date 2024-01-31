package com.solvd.saucedemo.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class CartItem extends AbstractUIObject{

    @FindBy(css = ".inventory_item_name")
    private ExtendedWebElement itemName;

    @FindBy(css = ".cart_button")
    private ExtendedWebElement deleteBtn;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    
    public String getItemName() {
        return itemName.getText();
    }
}
