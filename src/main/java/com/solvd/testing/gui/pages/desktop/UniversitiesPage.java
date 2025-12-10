package com.solvd.testing.gui.pages.desktop;

import com.solvd.testing.gui.pages.common.BasePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class UniversitiesPage extends BasePage {
    public static final Logger LOGGER = LogManager.getLogger(UniversitiesPage.class);

    public UniversitiesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img[alt='Coursera LinkedIn']")
    private ExtendedWebElement linkedInButton;


    public void scrollToLinkedInButton() {
        linkedInButton.scrollTo();
    }

    public Boolean linkedInButtonVisible() {
        return linkedInButton.isVisible(Duration.ofSeconds(2));
    }


    public void scrollDown() {
        linkedInButton.scrollTo();
    }
}
