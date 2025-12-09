package com.solvd.testing.gui.pages.desktop;

import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends AbstractPage {
    public static final Logger LOGGER = LogManager.getLogger(CoursePage.class);

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@data-e2e=\"hero-title\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//span[text()=\"Instructor: \"]")
    private ExtendedWebElement instructor;


    public void choseLevel(){
        levelButton.click();
        CommonUtils.pause(2);
        WebElement advancedCheckBox=driver.findElement(By
                .xpath("//div[contains(@data-testid,'productDifficultyLevel:Advanced')]")
        );
        advancedCheckBox.click();
        CommonUtils.pause(2);
        WebElement viewButton=driver.findElement(By
                .xpath("//span[@class='cds-button-label' and text()='View']")
        );
        viewButton.click();

    }

    public void clickOnResult(int n){
        ExtendedWebElement result=resultNumber(n);
        result.click();
    }

    public ExtendedWebElement resultNumber(int n){
        WebElement result=driver.findElement(By
                        .xpath("//a[contains(@data-click-value,'hitPosition\":"+n+"')]")
        );
        return (ExtendedWebElement) result;

    }

}
