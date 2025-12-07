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

    @FindBy(id = "search-autocomplete-input")
    private ExtendedWebElement searchBar;


    @FindBy(xpath = "//button[@data-testid='chip-button-inactive']/div[text()='Level']")
    private ExtendedWebElement levelButton;


    public void useSearchBar(String string) {
        searchBar.click();
        searchBar.type(string);
        searchBar.sendKeys(Keys.ENTER);
        //searchBar.type(string + Keys.ENTER);

        CommonUtils.pause(3); // wait 3 seconds

    }

    public void example() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//        new WebDriverWait(driver,Duration.ofSeconds(2);
    }

    public void clickLevel(){
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
}
