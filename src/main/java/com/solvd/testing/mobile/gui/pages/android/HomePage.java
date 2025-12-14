package com.solvd.testing.mobile.gui.pages.android;

import com.solvd.testing.mobile.gui.components.FooterComponent;
import com.solvd.testing.mobile.gui.components.TopComponent;
import com.solvd.testing.mobile.gui.pages.common.HomePageBase;
import com.solvd.testing.mobile.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(id = "com.google.android.youtube:id/toolbar_container")
    private TopComponent topComponent;

    @FindBy(id = "com.google.android.youtube:id/bottom_bar_container")
    private FooterComponent footerComponent;

    @FindBy(xpath = "//android.widget.ListView[@resource-id=\"com.google.android.youtube:id/account_list\"]//android.widget.RelativeLayout")
    private List<ExtendedWebElement> accounts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement denyNotificationsBtn;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Search YouTube\"]")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.google.android.youtube:id/search_edit_text\"]")
    private ExtendedWebElement editSearchBar;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Search']")
    private ExtendedWebElement searchBtn;

    public TopComponent getTopComponent() {
        return topComponent;
    }

    public FooterComponent getFooterComponent() {
        return footerComponent;
    }

    @Override
    public void denyNotifications() {
        if (denyNotificationsBtn.isVisible(Duration.ofSeconds(1))) {
            denyNotificationsBtn.click();
        }
    }

    @Override
    public void chooseAccount() {
        if (accounts.size()>0 && accounts.get(0).isVisible()) {
           accounts.get(0).click();
        }
    }

    @Override
    public void initialize() {
        denyNotifications();
        CommonUtils.pause(1);
        chooseAccount();
        CommonUtils.pause(1);
    }

    @Override
    public SearchResultsPageBase search(String string) {
//        searchBtn.click();
        topComponent.clickSearch();
        CommonUtils.pause(1);
        editSearchBar.click();
        editSearchBar.type(string);

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        CommonUtils.pause(5);
        return initPage(driver, SearchResultsPageBase.class);
    }

}
