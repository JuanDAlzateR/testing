package com.solvd.testing.web;

import com.solvd.testing.gui.components.TopMenuComponent;
import com.solvd.testing.gui.pages.desktop.CoursePage;
import com.solvd.testing.gui.pages.desktop.HomePage;

import com.solvd.testing.gui.pages.desktop.SearchPage;
import com.zebrunner.carina.core.IAbstractTest;

import com.zebrunner.carina.utils.common.CommonUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

        String currentUrl = getDriver().getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("browse/computer-science"),
                "ERROR:the link doesn't contain computer-science: " + currentUrl);
    }

    @Test
    public void filterSearch(){
        HomePage homePage =new HomePage(getDriver());
        TopMenuComponent topMenuComponent= new TopMenuComponent(getDriver());
        SearchPage searchPage=new SearchPage(getDriver());
        homePage.open();
        topMenuComponent.useSearchBar("Java");
        searchPage.choseLevel();
        CommonUtils.pause(10);

        String currentUrl = getDriver().getCurrentUrl();

        SoftAssert sa=new SoftAssert();
        sa.assertTrue(currentUrl.contains("search?query=Java"),
                "ERROR: the search for java doesn't show in the URL: " + currentUrl);
        sa.assertTrue(currentUrl.contains("productDifficultyLevel=Advanced"),
                "ERROR:the search doesn't filter by advance level. URL: " + currentUrl);
        sa.assertAll();
    }

    @Test
    public void searchCourse(){
        HomePage homePage =new HomePage(getDriver());
        TopMenuComponent topMenuComponent= new TopMenuComponent(getDriver());
        SearchPage searchPage=new SearchPage(getDriver());


        homePage.open();
        topMenuComponent.useSearchBar("Programming");

        String mainTab = getDriver().getWindowHandle();

        searchPage.clickOnResult(0);
        CommonUtils.pause(1);

        for (String handle : getDriver().getWindowHandles()) {
            if (!handle.equals(mainTab)) {
                getDriver().switchTo().window(handle);
                break;
            }
        }

        CoursePage coursePage=new CoursePage(getDriver());

        String title=coursePage.getCourseTitle();
        String instructor=coursePage.getCourseInstructor();
        String rating=coursePage.getRating();

        SoftAssert sa=new SoftAssert();
        sa.assertTrue(title.toLowerCase().contains("programming"),
                "ERROR: the course title doesn't contains 'programming'. Title: " + title);
        sa.assertNotNull(instructor,
                "ERROR: course doesn't show an instructor. Instructor: " + instructor);
        sa.assertNotNull(rating,
                "ERROR: course doesn't show a rating. Rating: " + instructor);

        sa.assertTrue(coursePage.enrollButtonIsEnabled(),
                "ERROR: course doesn't have an enabled enroll button.");
        sa.assertAll();
    }





}

