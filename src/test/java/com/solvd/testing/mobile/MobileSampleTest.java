package com.solvd.testing.mobile;

import com.solvd.testing.mobile.gui.components.FilterComponent;
import com.solvd.testing.mobile.gui.pages.common.HomePageBase;
import com.solvd.testing.mobile.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.MobileBy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileSampleTest implements IAbstractTest, IMobileUtils {
    public static final Logger LOGGER = LogManager.getLogger(MobileSampleTest.class);

    @Test(testName = "Verify search", description = "verifies search for a string")
    public void verifySearchFromHomePage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.denyNotifications();
        CommonUtils.pause(1);
        SearchResultsPageBase searchResultsPage = homePage.search("java");
        Assert.assertTrue(searchResultsPage.getSearchBarText().equals("java"));
    }

    @Test(testName = "Verify search and filters", description = "verifies search and apply filter")
    public void verifySearchAndApplyFilter() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.denyNotifications();
        CommonUtils.pause(1);
        SearchResultsPageBase searchResultsPage = homePage.search("programming");
        CommonUtils.pause(1);
        scroll("Backward");
        searchResultsPage.clickFilter("Shorts");
        CommonUtils.pause(2);
        FilterComponent filterComponent = searchResultsPage.getFilterComponent();
        ExtendedWebElement shortsBtn = filterComponent.findFilterButton("Shorts");
        Assert.assertTrue(filterComponent.findFilterButton("Shorts").getAttribute("selected").equals("true"));
    }

    @Test(testName = "Verify search and filters", description = "verifies search and swipe looking for an previously unseen filter")
    public void verifySearchAndSwipeToUnseenFilter() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.denyNotifications();
        CommonUtils.pause(1);
        SearchResultsPageBase searchResultsPage = homePage.search("programming");
        FilterComponent filterComponent = searchResultsPage.getFilterComponent();
        filterComponent.scrollToElement("Live");
        CommonUtils.pause(3);
        Assert.assertTrue(filterComponent.isFilterButtonVisible("Live"));
    }

    public void scroll(String string) {
        getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scroll" + string + "()"
                )
        );
    }

}