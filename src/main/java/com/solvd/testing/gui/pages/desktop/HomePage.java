package com.solvd.testing.gui.pages.desktop;

import com.solvd.testing.Mine;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {
    public static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search-autocomplete-input")
    private ExtendedWebElement searchBar;

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
}
