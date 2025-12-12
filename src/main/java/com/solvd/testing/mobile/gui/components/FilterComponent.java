package com.solvd.testing.mobile.gui.components;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterComponent extends BaseComponent {

    public FilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver,searchContext);
    }
//android.support.v7.widget.RecyclerView[@content-desc="filters"]

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView[@content-desc='filters']")
    private ExtendedWebElement filtersRecyclerView;

    public void clickFilter(String string) {
        click(findFilterButton(string));
    }

    private ExtendedWebElement findFilterButton(String string) {
        String xpathString= "//android.support.v7.widget.RecyclerView[@content-desc='filters']//android.widget.TextView[text()='"+string+"']";
        ExtendedWebElement filterButton = elementFactory
                .findByXpath(xpathString, string+"FilterBtn");
        return  filterButton;
    }

    public void scrollToElement(String string){
        findFilterButton(string).scrollTo();
    }

}
