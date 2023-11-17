package com.solvd.common;

import org.openqa.selenium.WebDriver;

import com.solvd.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class ProductsPageBase extends AbstractPage{

    public ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void logItems();

    public abstract ProductsPageBase search(String s);

    public abstract boolean isProductPresent(String name);

    public abstract Header getHeader();
}
