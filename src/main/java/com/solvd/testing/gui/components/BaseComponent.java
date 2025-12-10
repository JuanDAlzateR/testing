package com.solvd.testing.gui.components;

import com.solvd.testing.gui.actions.ElementActions;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseComponent extends AbstractUIObject {

    protected ElementActions actions;

    public BaseComponent(WebDriver driver) {
        super(driver);
        this.actions =new ElementActions(driver);
    }

    protected void click(ExtendedWebElement element) {
        actions.click(element);
        actions.pause(1);
    }

}