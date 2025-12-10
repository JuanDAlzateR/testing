package com.solvd.testing.gui.pages.desktop;

import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.time.Duration;

public class HomePage extends AbstractPage {
    public static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void example() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        new WebDriverWait(driver,Duration.ofSeconds(2);
    }

}
