package com.solvd.testing.mobile.gui.pages.android;

import com.solvd.testing.mobile.gui.pages.common.HomePageBase;
import com.solvd.testing.mobile.gui.pages.common.HomeScreenBase;
import com.solvd.testing.mobile.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = HomeScreenBase.class)
public class SearchResultsPage extends SearchResultsPageBase {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement denyNotificationsBtn;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
    private ExtendedWebElement moreOptionsBtn;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@content-desc='filters']//android.widget.TextView[text()='All']")
    private ExtendedWebElement allFilterBtn;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@content-desc='filters']//android.widget.TextView[text()='All']")
    private ExtendedWebElement shortsFilterBtn;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@content-desc='filters']//android.widget.TextView[text()='All']")
    private ExtendedWebElement videoFilterBtn;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@content-desc='filters']//android.widget.TextView[text()='All']")
    private ExtendedWebElement unwatchedFilterBtn;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@content-desc='filters']//android.widget.TextView[text()='All']")
    private ExtendedWebElement watchedFilterBtn;

//android.widget.ImageView[@content-desc="More options"]



}
