package com.solvd.testing.gui.pages.common;

import com.solvd.testing.gui.actions.ElementActions;
import com.solvd.testing.gui.utils.ExtendedWebElementFactory;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BasePage extends AbstractPage {
    protected ElementActions actions;
    protected ExtendedWebElementFactory elementFactory;

    public BasePage(WebDriver driver) {
        super(driver);
        this.actions =new ElementActions(driver);
        this.elementFactory=new ExtendedWebElementFactory(driver);
    }

    protected void click(ExtendedWebElement element) {
        actions.click(element);
        pause(1);
    }

    protected void click(WebElement element) {
        actions.click(element);
        pause(1);
    }

    protected void pause(int seconds) {
        CommonUtils.pause(seconds);
    }
}