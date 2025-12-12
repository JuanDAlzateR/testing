package com.solvd.testing.web;

import com.solvd.testing.gui.components.LogInComponent;
import com.solvd.testing.gui.components.TopMenuComponent;
import com.solvd.testing.gui.pages.desktop.CoursePage;
import com.solvd.testing.gui.pages.desktop.HomePage;

import com.solvd.testing.gui.pages.desktop.SearchPage;
import com.solvd.testing.gui.pages.desktop.UniversitiesPage;
import com.zebrunner.carina.core.IAbstractTest;

import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;


public class WebSampleTest implements IAbstractTest {

    public static final Logger LOGGER = LogManager.getLogger(WebSampleTest.class);

    @Test(testName = "Verify Home Page", description = "verifies that the home page loads")
    public void verifyHomePageLoads() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test(testName = "Verify search", description = "verifies search bar correct functionality")
    public void verifySearchBarFunctionality() {
        HomePage homePage = new HomePage(getDriver());

        homePage.open();
        TopMenuComponent topMenuComponent = new TopMenuComponent(getDriver());
        topMenuComponent.useSearchBar("Java Programming");

        // Wait to load the page
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("search"));

        String currentUrl = getDriver().getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("search?query=Java+Programming")
                        || currentUrl.contains("search?query=Java%20Programming"),
                "ERROR:the search doesn't show in the URL: " + currentUrl);
    }


    @Test(testName = "Verify explore hover", description = "verifies explore hover and the correct functionality of a link")
    public void verifyExploreHoverAndLink() {
        HomePage homePage = new HomePage(getDriver());
        TopMenuComponent topMenuComponent = new TopMenuComponent(getDriver());
        homePage.open();
        topMenuComponent.clickCSLink();

        String currentUrl = getDriver().getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("browse/computer-science"),
                "ERROR:the link doesn't contain computer-science: " + currentUrl);
    }

    @Test(testName = "Verify filter search", description = "verifies search bar and filter by level")
    public void verifyFilterSearchByLevel() {
        HomePage homePage = new HomePage(getDriver());
        TopMenuComponent topMenuComponent = new TopMenuComponent(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());
        homePage.open();
        topMenuComponent.useSearchBar("Java");
        searchPage.choseLevel();
        CommonUtils.pause(10);

        String currentUrl = getDriver().getCurrentUrl();

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(currentUrl.contains("search?query=Java"),
                "ERROR: the search for java doesn't show in the URL: " + currentUrl);
        sa.assertTrue(currentUrl.contains("productDifficultyLevel=Advanced"),
                "ERROR:the search doesn't filter by advance level. URL: " + currentUrl);
        sa.assertAll();
    }

    @Test(testName = "Verify course search", description = "verifies search bar, opening the first result and important info of the course is in fact present")
    public void verifyCourseSearchAndDisplayInformation() {
        HomePage homePage = new HomePage(getDriver());
        TopMenuComponent topMenuComponent = new TopMenuComponent(getDriver());
        SearchPage searchPage = new SearchPage(getDriver());

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

        CoursePage coursePage = new CoursePage(getDriver());

        String title = coursePage.getCourseTitle();
        String instructor = coursePage.getCourseInstructor();
        String rating = coursePage.getRating();

        SoftAssert sa = new SoftAssert();
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

    @Test(testName = "Verify login popup", description = "verifies input and buttons for login, and warning for invalid account")
    public void verifyLogInPopUpInputAndCorrectDenyAccess() {
        HomePage homePage = new HomePage(getDriver());
        TopMenuComponent topMenuComponent = new TopMenuComponent(getDriver());
        LogInComponent loginComponent = new LogInComponent(getDriver());
        homePage.open();
        topMenuComponent.clickLogIn();

        loginComponent.inputEmail("example@email.com");
        CommonUtils.pause(1);
        loginComponent.clickContinue();
        CommonUtils.pause(1);
        loginComponent.inputPassword("1234");
        CommonUtils.pause(1);
        loginComponent.clickNext();
        CommonUtils.pause(1);

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(loginComponent.getEmailValue(), "example@email.com",
                "ERROR: the email wasn't input correctly");
        sa.assertEquals(loginComponent.getPasswordValue(), "1234",
                "ERROR: the password wasn't input correctly");
        sa.assertTrue(loginComponent.visibleWarning(), "ERROR: Page doesn't show incorrect email or password");
        sa.assertAll();
    }

    @Test(testName = "Verify universities page", description = "verifies universities page button and correct scroll")
    public void verifyUniversitiesPageLinkAndScroll() {
        HomePage homePage = new HomePage(getDriver());
        TopMenuComponent topMenuComponent = new TopMenuComponent(getDriver());
        UniversitiesPage universitiesPage = new UniversitiesPage(getDriver());
        homePage.open();
        topMenuComponent.clickUniversities();
        LOGGER.info("start:");
        Boolean bool = universitiesPage.linkedInButtonVisible();
        LOGGER.info("finish:");
        String currentUrl = getDriver().getCurrentUrl();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(currentUrl.contains("www.coursera.org/campus"),
                "ERROR: campus doesn't show in the URL: " + currentUrl);

        sa.assertTrue(!universitiesPage.linkedInButtonVisible(), "ERROR: LinkedIn button is visible at the top of the page");
        universitiesPage.scrollToLinkedInButton();

        sa.assertTrue(universitiesPage.linkedInButtonVisible(), "ERROR: LinkedIn button is not visible at the bottom of the page");
        sa.assertAll();
    }

    @Test(testName = "Verify window size", description = "verifies window correct functionality")
    public void verifyChangeOfBrowserWindowSize() {
        HomePage homePage = new HomePage(getDriver());
        getDriver().manage().window().setSize(new Dimension(1280, 800));
        getDriver().manage().window().setPosition(new Point(550, 300));
        homePage.open();

        int height = getDriver().manage().window().getSize().height;
        int width = getDriver().manage().window().getSize().width;

        Assert.assertTrue(height == 800 && width == 1280,
                "ERROR:the browser doesn't have the correct size: " + getDriver().manage().window().getSize());
    }

    @Test(testName = "Verify dynamic result search", description = "verifies the total amount of results in a search, increases as the user scrolls down")
    public void verifyDynamicScrollLoadsMoreResults() {
        WebDriver driver = getDriver();
        driver.get("https://www.coursera.org/search?query=python");

        SearchPage resultsPage = new SearchPage(driver);

        SoftAssert sa = new SoftAssert();

        int previousCount = resultsPage.getResultsCount();
        sa.assertTrue(previousCount > 0, "ERROR: Initial results should not be zero");

        for (int i = 1; i <= 3; i++) {
//            LOGGER.info("count:"+previousCount);
            resultsPage.scrollToResult(previousCount - 1);
            int newCount = resultsPage.getResultsCount();

            sa.assertTrue(
                    newCount > previousCount,
                    "ERROR: Scroll #" + i + " should load more results. Before: "
                            + previousCount + " After: " + newCount
            );
            previousCount = newCount;
        }
        sa.assertAll();
    }

    @Test(testName = "Verify links in carousel", description = "verifies that each button on the partners carousel, redirects to a link of that partner")
    public void verifyLinksOfPartnersCarousel() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        List<ExtendedWebElement> partners = homePage.getPartnersCarousel();

        SoftAssert sa = new SoftAssert();
        partners.stream().forEach(p -> {
            String href = homePage.getHref(p).toLowerCase();
            String text = homePage.getTrimText(p).toLowerCase();
            sa.assertTrue(href.contains(text), "ERROR: Carousel button doesn't refer to corresponding partner. href:" + href + ". text:" + text);
        });

        sa.assertAll();
    }
}

