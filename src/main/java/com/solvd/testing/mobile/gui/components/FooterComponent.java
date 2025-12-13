package com.solvd.testing.mobile.gui.components;

import com.solvd.testing.mobile.gui.pages.common.HomePageBase;
import com.solvd.testing.mobile.gui.pages.common.ShortsPageBase;
import com.solvd.testing.mobile.gui.pages.common.SubscriptionsPageBase;
import com.solvd.testing.mobile.gui.pages.common.YouPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterComponent extends BaseComponent implements IMobileUtils {

    public FooterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc='Home']")
    private ExtendedWebElement homeBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Shorts']")
    private ExtendedWebElement shortsBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Subscriptions']")
    private ExtendedWebElement subscriptionsBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='You']")
    private ExtendedWebElement youBtn;

    public HomePageBase clickHome() {
        homeBtn.click();
        return initPage(getDriver(),HomePageBase.class);
    }

    public ShortsPageBase clickShorts() {
        shortsBtn.click();
        return initPage(getDriver(), ShortsPageBase.class);
    }

    public SubscriptionsPageBase clickSubscriptions() {
        subscriptionsBtn.click();
        return initPage(getDriver(), SubscriptionsPageBase.class);
    }

    public YouPageBase clickYou() {
        youBtn.click();
        return initPage(getDriver(), YouPageBase.class);
    }

}
