package com.solvd.testing.mobile.gui.pages.android;

import com.solvd.testing.mobile.gui.pages.common.HomeScreenBase;
import com.solvd.testing.mobile.gui.pages.common.WelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = HomeScreenBase.class)
public class HomeScreen extends HomeScreenBase {

    public HomeScreen(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.TextView[@content-desc='YouTube']")
    private ExtendedWebElement youtubeButton;

    @Override
    public WelcomePageBase clickYoutubeButton() {
        youtubeButton.click();
        return initPage(getDriver(), WelcomePageBase.class);
    }

}
