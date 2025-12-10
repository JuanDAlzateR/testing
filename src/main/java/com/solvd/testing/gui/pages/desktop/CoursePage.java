package com.solvd.testing.gui.pages.desktop;

import com.zebrunner.carina.utils.common.CommonUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursePage extends AbstractPage {
    public static final Logger LOGGER = LogManager.getLogger(CoursePage.class);

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@data-e2e=\"hero-title\"]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//span[text()=\"Instructor: \"]/a/span")
    private ExtendedWebElement instructor;

    @FindBy(xpath = "//div[contains(@aria-label,'stars')]")
    private ExtendedWebElement rating;

    @FindBy(css = "span[data-test='enroll-button-label']")
    private ExtendedWebElement enrollButton;


    public String getCourseTitle(){
        return title.getText();
    }

    public String getCourseInstructor(){
        return instructor.getText();
    }

    public String getRating(){
        return rating.getText();
    }

    public Boolean enrollButtonPresent(){
        return enrollButton.isPresent();
    }

    public Boolean enrollButtonIsEnabled(){
        return enrollButton.isPresent()&&enrollButton.isEnabled();
    }






}
