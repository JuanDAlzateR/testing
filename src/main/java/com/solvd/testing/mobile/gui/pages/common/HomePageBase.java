package com.solvd.testing.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void denyNotifications();

    public abstract SearchResultsPageBase search(String string);


}
