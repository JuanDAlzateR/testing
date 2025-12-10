package com.solvd.testing.gui.components;

import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseComponent extends AbstractUIObject {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    protected void click(ExtendedWebElement element) {
        element.click();
        pause(1);
    }

    protected void pause(int seconds) {
        CommonUtils.pause(seconds);
    }
}