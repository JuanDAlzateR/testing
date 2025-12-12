package com.solvd.testing.mobile.gui.pages.android;

import com.solvd.testing.mobile.gui.components.FilterComponent;

import com.solvd.testing.mobile.gui.pages.common.SearchResultsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.DeviceType.Type;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = SearchResultsPageBase.class)
public class SearchResultsPage extends SearchResultsPageBase {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.google.android.youtube:id/chip_bar_container")
    private FilterComponent filterComponent;

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.youtube:id/results\"]")
    private ExtendedWebElement resultsList;

    @FindBy(id = "com.google.android.youtube:id/search_query")
    private ExtendedWebElement searchBar;


    @Override
    public void clickFilter(String string) {
       filterComponent.clickFilter(string);
    }

    @Override
    public void scrollToElement(String string) {
        while(!filterComponent.isVisible(1)){
            scroll("Backward");
        }
        filterComponent.scrollToElement(string);
    }

    public void scroll(String string){
        getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scroll"+string+"()"
                )
        );
    }

    @Override
    public FilterComponent getFilterComponent(){
        return filterComponent;
    }
    @Override
    public String getSearchBarText(){
        return searchBar.getText();
    }
}
