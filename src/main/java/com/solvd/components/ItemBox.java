package com.solvd.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class ItemBox extends AbstractUIObject implements ICustomTypePageFactory{

    @FindBy(css = ".productinfo .add-to-cart")
    private ExtendedWebElement addToCartBtn;

    @FindBy(css = ".productinfo p")
    private ExtendedWebElement productName;

    public ItemBox(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    
    public void addToCart(){
        addToCartBtn.click();
    }

    public String getProductName() {
        return productName.getText();
    }

}
