package com.solvd.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends BasePage{

    @FindBy(css = ".features_items div.col-sm-4")
    private List<WebElement> products;

    @FindBy(css = "#cartModal a")
    private WebElement viewCartModalButton;

    public Homepage(WebDriver driver) {
        super(driver);
    }
    
    public CartPage addToCartandView(int n){
        click(products.get(n).findElement(By.cssSelector(".productinfo .add-to-cart")), "Add to cart button of element "+ n);
        click(viewCartModalButton, "View Cart Modal Button");
        return new CartPage(getDriver());
    }

}
