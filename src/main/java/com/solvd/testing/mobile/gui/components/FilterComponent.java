package com.solvd.testing.mobile.gui.components;

import com.solvd.testing.gui.pages.desktop.CoursePage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.MobileBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterComponent extends BaseComponent {

    public static final Logger LOGGER = LogManager.getLogger(FilterComponent.class);

    public FilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@content-desc='filters']")
    private ExtendedWebElement filtersRecyclerView;

    public void clickFilter(String string) {
        click(findFilterButton(string));
    }

    public ExtendedWebElement findFilterButton(String string) {
        String xpathString = "//android.support.v7.widget.RecyclerView[@content-desc='filters']//android.widget.TextView[@text='" + string + "']";
        LOGGER.info("xpath:"+xpathString);
        ExtendedWebElement filterButton = elementFactory
                .findByXpath(xpathString, string + "FilterBtn",filtersRecyclerView);
        return filterButton;
    }

    public void scrollToElement(String string) {
        while(!filtersRecyclerView.isVisible(1)){
            scroll("Backward");
        }
       swipe(findFilterButton(string),filtersRecyclerView,Direction.LEFT,10);
    }

    public Boolean isFilterButtonVisible(String string) {
        return findFilterButton(string).isVisible(1);
    }

    public void scroll(String string){
        getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scroll"+string+"()"
                )
        );
    }

    public void scrollFilters(Direction direction){
        swipe(filtersRecyclerView,direction);
    }
}
