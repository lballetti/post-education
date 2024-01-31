package com.solvd.saucedemo.gui.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.saucedemo.gui.common.CartPageBase;
import com.solvd.saucedemo.gui.common.InfoPageBase;
import com.solvd.saucedemo.gui.components.CartItem;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase{

    @FindBy(css = "#checkout")
    private ExtendedWebElement checkoutBtn;

    @FindBy(css = ".cart_item")
    private List<CartItem> cartItems;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public InfoPageBase checkout() {
        checkoutBtn.click();
        return initPage(InfoPageBase.class, getDriver());
    }

    @Override
    public boolean isItemInCart(String itemName) {
        return cartItems.stream().anyMatch(x->x.getItemName().equals(itemName));
    }
    
}
