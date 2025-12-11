package com.solvd.testing.mobile.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomeScreenBase extends AbstractPage {

    public HomeScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract WelcomePageBase clickYoutubeButton();

}
