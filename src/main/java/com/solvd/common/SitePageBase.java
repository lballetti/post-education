package com.solvd.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.solvd.components.Header;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class SitePageBase extends AbstractPage {

    @FindBy(id = "header")
    private Header header;

    public SitePageBase(WebDriver driver) {
        super(driver);
    }

    public Header getHeaderMenu() {
        return header;
    }
}
