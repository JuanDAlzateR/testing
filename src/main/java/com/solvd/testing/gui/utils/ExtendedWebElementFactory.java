package com.solvd.testing.gui.utils;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExtendedWebElementFactory {
    WebDriver driver;

    public ExtendedWebElementFactory(WebDriver driver) {
        this.driver = driver;
    }

    public ExtendedWebElement findByXpath(String xpathExpression, String name) {
        return new ExtendedWebElement(By.xpath(xpathExpression), name, driver, driver);
        //For now SearchContext it's driver. It could be implemented in a better way.
    }

}
