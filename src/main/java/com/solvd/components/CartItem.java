package com.solvd.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class CartItem extends AbstractUIObject implements ICustomTypePageFactory{

    @FindBy(css = "a.cart_quantity_delete")
    private ExtendedWebElement deleteBtn;

    @FindBy(css = ".cart_description h4")
    private ExtendedWebElement itemName;

    @FindBy(css = ".cart_price")
    private ExtendedWebElement price;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    
    public void delete(){
        deleteBtn.click();
    }

    public String getName(){
        return itemName.getText();
    }

    public String getPrice(){
        return price.getText();
    }
    
}
