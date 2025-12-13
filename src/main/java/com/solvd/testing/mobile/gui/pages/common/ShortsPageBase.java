package com.solvd.testing.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ShortsPageBase extends PageBase {

    public ShortsPageBase(WebDriver driver) {
        super(driver);
    }
    public abstract void swipe();
    public abstract ExtendedWebElement getCurrentShort();

}
