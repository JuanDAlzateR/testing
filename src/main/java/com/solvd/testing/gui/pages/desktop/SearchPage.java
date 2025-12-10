package com.solvd.testing.gui.pages.desktop;

import com.solvd.testing.gui.pages.common.BasePage;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BasePage {
    public static final Logger LOGGER = LogManager.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-testid='chip-button-inactive']/div[text()='Level']")
    private ExtendedWebElement levelButton;

    @FindBy(xpath = "//div[@id='searchResults']//ul//li")
    private List<ExtendedWebElement> results;

    @FindBy(xpath = "//body")
    private ExtendedWebElement body;

    public void choseLevel() {
        click(levelButton);

        ExtendedWebElement advancedCheckBox = elementFactory
                .findByXpath("//div[contains(@data-testid,'productDifficultyLevel:Advanced')]", "advancedCheckBox");
        click(advancedCheckBox);

        ExtendedWebElement viewButton = elementFactory
                .findByXpath("//span[@class='cds-button-label' and text()='View']", "viewButton");

        click(viewButton);

    }

    public void clickOnResult(int n) {
        ExtendedWebElement result = elementFactory
                .findByXpath("//a[contains(@data-click-value,'hitPosition\":" + n + "')]", "result" + n);
        click(result);
    }

    public int getResultsCount() {
        return results.size();
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        pause(2);
    }

    public void scrollToResult(int n) {
        ExtendedWebElement result = elementFactory
                .findByXpath("//a[contains(@data-click-value,'hitPosition\":" + n + "')]", "result" + n);
        result.scrollTo();
        pause(2);
    }

}
