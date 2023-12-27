package com.solvd.ios;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.common.CartPageBase;
import com.solvd.common.HomepageBase;
import com.solvd.components.Header;
import com.solvd.components.ItemBox;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomepageBase.class)
public class Homepage extends HomepageBase{

    @FindBy(id = "header")
    private Header header;

    @FindBy(css = ".features_items div.col-sm-4")
    private List<ItemBox> products;

    @FindBy(css = "#cartModal a")
    private ExtendedWebElement viewCartModalButton;

    public Homepage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase addToCartandView(int n) {
        products.get(n).addToCart();
        viewCartModalButton.click();
        return initPage(CartPageBase.class, driver);
    }

    @Override
    public CartPageBase addToCartandView(String name) {
        products.stream()
                .filter(x-> x.getName().equals(name))
                .findFirst()
                .get()
                .addToCart();

        viewCartModalButton.click();
        return initPage(CartPageBase.class, driver);
    }
    
    @Override
    public Header getHeader() {
        return header;
    }
    
}
