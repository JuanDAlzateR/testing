package com.solvd.testing.mobile.gui.pages.android;

import com.solvd.testing.mobile.gui.components.FilterComponent;
import com.solvd.testing.mobile.gui.pages.common.SearchResultsPageBase;
import com.solvd.testing.mobile.gui.pages.common.ShortsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = ShortsPageBase.class)
public class ShortsPage extends ShortsPageBase implements IMobileUtils {

    public Dimension size;
    public ShortsPage(WebDriver driver) {
        super(driver);
        Dimension size = driver.manage().window().getSize();
        this.size=size;
    }

    @FindBy(id = "com.google.android.youtube:id/nerd_stats_container")
    private ExtendedWebElement statsContainer;

    @FindBy(id = "com.google.android.youtube:id/reel_player_page_container")
    private ExtendedWebElement reelContainer;

    @FindBy(id = "com.google.android.youtube:id/reel_recycler")
    private ExtendedWebElement reelRecycler;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.youtube:id/results\"]")
    private ExtendedWebElement resultsList;

    @FindBy(id = "com.google.android.youtube:id/search_query")
    private ExtendedWebElement searchBar;


    public void scroll(String string) {
        getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scroll" + string + "()"
                )
        );
    }


    @Override
    public void swipe() {
//        swipeInContainer(reelContainer,Direction.UP,400); //duration it's in milliseconds
        int startx= size.getWidth()/2;
        int starty= (int) (size.getHeight()*0.60);
        int endx=startx;
        int endy=0;

        swipe(startx,starty,endx,endy,1000);
    }

    @Override
    public ExtendedWebElement getCurrentShort() {
        return elementFactory.findByXpath("//android.widget.FrameLayout[@resource-id=\"com.google.android.youtube:id/reel_player_page_container\"]","currentShort",reelRecycler);
    }
    ///  .//android.view.ViewGroup[@resource-id='com.google.android.youtube:id/reel_player_page_container']




}
