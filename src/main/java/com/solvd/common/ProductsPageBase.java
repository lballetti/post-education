package com.solvd.common;

import org.openqa.selenium.WebDriver;


public abstract class ProductsPageBase extends SitePageBase{

    public ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void logItems();

    public abstract ProductsPageBase search(String s);

    public abstract boolean isProductPresent(String name);

}
