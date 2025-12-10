package com.solvd.testing.gui.pages.desktop;

import com.solvd.testing.gui.pages.common.BasePage;
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
import java.util.List;

public class HomePage extends BasePage {
    public static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//a[@href='/google-career-certificates']/ancestor::div[@data-testid='overflow-carousel-content']//a")
    private List<ExtendedWebElement> partnersCarousel;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public String getHref(ExtendedWebElement element) {
        return element.getAttribute("href");
    }

    public String getTrimText(ExtendedWebElement element) {

        String text = element.getText().replaceAll("\\b(University|of)\\b", "").trim();
        if (text.toLowerCase().contains("deeplearning.ai")) {
            return "deep-learning-ai";
        }
        return text;
    }

    public List<ExtendedWebElement> getPartnersCarousel() {
        return partnersCarousel;
    }


}
