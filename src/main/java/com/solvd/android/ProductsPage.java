package com.solvd.android;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solvd.common.ProductsPageBase;
import com.solvd.components.Header;
import com.solvd.components.ItemBox;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase{

    private static final Logger logger = LoggerFactory.getLogger(ProductsPage.class);

    @FindBy(id = "header")
    private Header header;

    @FindBy(css = ".features_items div.col-sm-4")
    private List<ItemBox> products;

    @FindBy(css = "input#search_product")
    private ExtendedWebElement searchInput;

    @FindBy(css = "button#submit_search")
    private ExtendedWebElement submitSearchBtn;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void logItems(){
        for (ItemBox product : products) {
            logger.info(product.getProductName());
        }
    }

    @Override
    public ProductsPageBase search(String s){
        searchInput.type(s);
        submitSearchBtn.click();
        return initPage(ProductsPageBase.class, driver);
    }

    @Override
    public boolean isProductPresent(String name){
        return products.stream()
                .filter(x-> x.getProductName().contains(name))
                .findAny()
                .get() != null;
    }

    @Override
    public Header getHeader() {
        return header;
    }
}
