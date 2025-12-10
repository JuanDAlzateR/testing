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

public class SearchPage extends BasePage {
    public static final Logger LOGGER = LogManager.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-testid='chip-button-inactive']/div[text()='Level']")
    private ExtendedWebElement levelButton;

    public void choseLevel(){
        click(levelButton);
        LOGGER.info("click on level button");
        ExtendedWebElement advancedCheckBox= elementFactory
                .findByXpath("//div[contains(@data-testid,'productDifficultyLevel:Advanced')]","advancedCheckBox");
        click(advancedCheckBox);
        LOGGER.info("click on advance button");
        ExtendedWebElement viewButton= elementFactory
                .findByXpath("//span[@class='cds-button-label' and text()='View']","viewButton");

        click(viewButton);
        LOGGER.info("click on view button");
    }

    public void clickOnResult(int n){
        ExtendedWebElement result= elementFactory
                .findByXpath("//a[contains(@data-click-value,'hitPosition\":"+n+"')]","result"+n);
        click(result);
    }

}
