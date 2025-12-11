package com.solvd.testing.mobile.gui.components;

import com.solvd.testing.gui.actions.ElementActions;
import com.solvd.testing.gui.utils.ExtendedWebElementFactory;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent extends AbstractUIObject {

    protected ElementActions actions;
    protected ExtendedWebElementFactory elementFactory;

    public BaseComponent(WebDriver driver) {
        super(driver);
        this.actions = new ElementActions(driver);
        this.elementFactory = new ExtendedWebElementFactory(driver);
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