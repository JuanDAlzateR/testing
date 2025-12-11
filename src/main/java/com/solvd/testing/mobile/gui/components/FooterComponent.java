package com.solvd.testing.mobile.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterComponent extends BaseComponent {

    public FooterComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "//android.widget.Button[@content-desc='Home']")
    private ExtendedWebElement homeBtn;

    @FindBy(id = "//android.widget.Button[@content-desc='Shorts']")
    private ExtendedWebElement shortsBtn;

    @FindBy(id = "//android.widget.Button[@content-desc='Subscriptions']")
    private ExtendedWebElement subscriptionsBtn;

    @FindBy(id = "//android.widget.Button[@content-desc='You']")
    private ExtendedWebElement youBtn;

    public void clickHome() {
        homeBtn.click();
    }

}
