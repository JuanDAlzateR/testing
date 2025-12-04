package com.solvd.testing.web;

import com.solvd.testing.gui.components.TopMenuComponent;
import com.solvd.testing.gui.pages.desktop.HomePage;

import com.zebrunner.carina.core.IAbstractTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;



public class WebSampleTest implements IAbstractTest {

    @Test
    public void verifyHomePage(){
        HomePage homePage =new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test
    public void verifySearchBar(){
        HomePage homePage =new HomePage(getDriver());
//        getDriver().manage().window().setSize(new Dimension(1280, 800));
//        getDriver().manage().window().setPosition(new Point(550, 300));
        homePage.open();
        TopMenuComponent topMenuComponent= new TopMenuComponent(getDriver());
        topMenuComponent.useSearchBar("Java Programming");

        // Wait to load the page
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("search"));

        String currentUrl = getDriver().getCurrentUrl();


        Assert.assertTrue(currentUrl.contains("search?query=Java+Programming")
                        || currentUrl.contains("search?query=Java%20Programming"),
                "ERROR:the search doesn't show in the URL: " + currentUrl);
    }



    @Test
    public void verifyExplore(){
        HomePage homePage =new HomePage(getDriver());
        TopMenuComponent topMenuComponent= new TopMenuComponent(getDriver());
        homePage.open();
        topMenuComponent.clickCSLink();

    }





    }

