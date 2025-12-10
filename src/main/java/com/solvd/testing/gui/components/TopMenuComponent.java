package com.solvd.testing.gui.components;

import com.solvd.testing.gui.pages.desktop.HomePage;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopMenuComponent extends BaseComponent {
    public static final Logger LOGGER = LogManager.getLogger(TopMenuComponent.class);

    public TopMenuComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search-autocomplete-input")
    private ExtendedWebElement searchBar;

    @FindBy(css = "button[data-testid='megamenu-explore-button']")
    private ExtendedWebElement exploreButton;

    @FindBy(xpath = "//span[text()='Log In']")
    private ExtendedWebElement logInButton;

    @FindBy(xpath = "//span[contains(text(),\" Universities\")]")
    private ExtendedWebElement universitiesButton;

    public void useSearchBar(String string) {
        click(searchBar);
        searchBar.type(string);
        searchBar.sendKeys(Keys.ENTER);
        //searchBar.type(string + Keys.ENTER);

        CommonUtils.pause(3); // wait 3 seconds

    }

    public void hoverExplore() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement explore = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-testid='megamenu-explore-button']")
                )
        );

        Actions actions = new Actions(driver);
        actions.moveToElement(explore).pause(Duration.ofMillis(300)).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@data-testid,'megamenu-item')]")
        ));

        WebElement cs = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@data-testid,'megamenu-item')]/a[contains(@href,'computer-science')]")
                )
        );

        actions.moveToElement(cs).pause(Duration.ofMillis(200)).click().perform();
    }

    public void clickCSLink() {
        clickAndWait(exploreButton);

        ExtendedWebElement csLink = elementFactory
                .findByXpath("//div[contains(@data-testid,'megamenu-item')]/a[contains(@href,'computer-science')]", "csLink");

        clickAndWait(csLink);
    }

    public void clickExploreButton() {
        clickAndWait(exploreButton);
    }

    public void clickLogIn() {
        clickAndWait(logInButton);
    }

    public void clickUniversities() {
        clickAndWait(universitiesButton);
    }


}
