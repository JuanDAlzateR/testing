package com.solvd.testing.mobile.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopComponent extends BaseComponent {

    public TopComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "//android.widget.Button[@content-desc='Cast. Disconnected']")
    private ExtendedWebElement castBtn;

    @FindBy(id = "//android.widget.ImageView[@content-desc='Notifications']")
    private ExtendedWebElement notificationsBtn;

    @FindBy(id = "//android.widget.ImageView[@content-desc='Search']")
    private ExtendedWebElement searchBtn;

    @FindBy(id = "//android.widget.ImageView[@content-desc='Settings']")
    private ExtendedWebElement settingsBtn;

    public void clickCast() {
        castBtn.click();
    }

    public void clickNotifications() {
        notificationsBtn.click();
    }

    public void clickSearch() {
        searchBtn.click();
    }

    public void clickSettings() {
        settingsBtn.click();
    }

}
