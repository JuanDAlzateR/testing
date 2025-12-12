package com.solvd.testing.mobile.gui.pages.common;

import com.solvd.testing.mobile.gui.components.FilterComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SearchResultsPageBase extends AbstractPage {

    public SearchResultsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickFilter(String string);

    public abstract void scrollToElement(String string);

    public abstract FilterComponent getFilterComponent();

    public abstract String getSearchBarText();

}
