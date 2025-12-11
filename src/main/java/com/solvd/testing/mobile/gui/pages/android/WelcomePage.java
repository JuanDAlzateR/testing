package com.solvd.testing.mobile.gui.pages.android;

import com.solvd.testing.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(id = "//android.widget.Button[@content-desc='Shorts']")
    private ExtendedWebElement title;

    @FindBy(id = "//android.widget.Button[@content-desc='Home']")
    private ExtendedWebElement homeBtn;

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement denyNotificationsBtn;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

//    @Override
//    public boolean isPageOpened() {
//        return title.isElementPresent();
//    }
//
//    @Override
//    public LoginPageBase clickNextBtn() {
//        nextBtn.click();
//        return initPage(getDriver(), LoginPageBase.class);
//    }
    @Override
    public void denyNotifications() {
        if (denyNotificationsBtn.isVisible(Duration.ofSeconds(1))){
            denyNotificationsBtn.click();
        }
    }
}
