package com.solvd.testing.gui.pages.common;

import com.solvd.testing.gui.actions.ElementActions;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class BasePage extends AbstractPage {
    protected ElementActions actions;

    public BasePage(WebDriver driver) {
        super(driver);
        this.actions =new ElementActions(driver);
    }

    protected void click(ExtendedWebElement element) {
        actions.click(element);
        pause(1);
    }

    protected void pause(int seconds) {
        CommonUtils.pause(seconds);
    }
}