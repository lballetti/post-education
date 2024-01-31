package com.solvd.saucedemo.gui.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemo.gui.common.CartPageBase;
import com.solvd.saucedemo.gui.common.HomePageBase;
import com.solvd.saucedemo.gui.components.ItemBox;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase{

    @FindBy(css = ".inventory_item")
    private List<ItemBox> items;

    @FindBy(css = ".shopping_cart_link")
    private ExtendedWebElement cartBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addItemToCart(String name) {
        items.stream()
                .filter(i -> i.getItemName().equals(name))
                .findFirst().get()
                .addToCart();
    }

    @Override
    public CartPageBase clickCart() {
        cartBtn.click();
        return initPage(CartPageBase.class, getDriver());
    }
    
}
