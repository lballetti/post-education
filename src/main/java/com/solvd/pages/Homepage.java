package com.solvd.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.components.ItemBox;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class Homepage extends BasePage {

    @FindBy(css = ".features_items div.col-sm-4")
    private List<ItemBox> products;

    @FindBy(css = "#cartModal a")
    private ExtendedWebElement viewCartModalButton;

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public CartPage addToCartandView(int n) {
        products.get(n).addToCart();
        click(viewCartModalButton);
        return new CartPage(getDriver());
    }

    public CartPage addToCartandView(String name) {
        products.stream()
                .filter(x-> x.getName().equals(name))
                .findFirst()
                .get()
                .addToCart();

        click(viewCartModalButton);
        return new CartPage(getDriver());
    }

}
