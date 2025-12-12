package com.solvd.testing.mobile.gui.utils;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ExtendedWebMobileElementFactory {
    WebDriver driver;

    public ExtendedWebMobileElementFactory(WebDriver driver) {
        this.driver = driver;
    }

    public ExtendedWebElement findByXpath(String xpathExpression, String name, SearchContext searchContext) {
        return new ExtendedWebElement(By.xpath(xpathExpression), name, driver, searchContext);
    }

}
