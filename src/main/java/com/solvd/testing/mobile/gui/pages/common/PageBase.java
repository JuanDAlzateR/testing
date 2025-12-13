package com.solvd.testing.mobile.gui.pages.common;

import com.solvd.testing.gui.actions.ElementActions;
import com.solvd.testing.gui.utils.ExtendedWebElementFactory;
import com.solvd.testing.mobile.gui.components.FooterComponent;
import com.solvd.testing.mobile.gui.components.TopComponent;
import com.solvd.testing.mobile.gui.utils.ExtendedWebMobileElementFactory;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PageBase extends AbstractPage {


    protected ElementActions actions;
    protected ExtendedWebMobileElementFactory elementFactory;

    public PageBase(WebDriver driver) {
        super(driver);
        this.actions = new ElementActions(driver);
        this.elementFactory = new ExtendedWebMobileElementFactory(driver);
    }

    protected void click(ExtendedWebElement element) {
        actions.click(element);
    }

    protected void clickAndWait(ExtendedWebElement element) {
        actions.click(element);
        pause(1);
    }

    protected void pause(int seconds) {
        CommonUtils.pause(seconds);
    }
}