package com.solvd.android;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.CartPageBase;
import com.solvd.common.CheckoutPageBase;
import com.solvd.components.CartItem;
import com.solvd.components.Header;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase{

    @FindBy(id = "header")
    private Header header;

    @FindBy(css = "div.cart_info tbody tr")
    private List<CartItem> cartItems;

    @FindBy(css = "a.check_out")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void deleteFromCart(int n) {
        cartItems.get(n).delete();
    }

    @Override
    public void deleteFromCart(String name) {
        cartItems.stream()
                .filter(x-> x.getName().equals(name))
                .findFirst()
                .get()
                .delete();
    }

    @Override
    public CheckoutPageBase clickCheckout(){
        checkoutBtn.click();
        return initPage(CheckoutPageBase.class, driver);
    }

    @Override
    public boolean isItemPresent(String name){
        return cartItems.stream()
                .filter(x-> x.getName().equals(name))
                .findAny()
                .get() != null;
    }


}
