package com.solvd.testing.mobile.gui.pages.android;

import com.solvd.testing.mobile.gui.pages.common.HomePageBase;
import com.solvd.testing.mobile.gui.pages.common.HomeScreenBase;
import com.solvd.testing.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = HomeScreenBase.class)
public class HomePage extends HomePageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private ExtendedWebElement denyNotificationsBtn;

    @Override
    public void denyNotifications() {
        if (denyNotificationsBtn.isVisible(Duration.ofSeconds(1))){
            denyNotificationsBtn.click();
        }
    }

}
