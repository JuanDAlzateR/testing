package com.solvd.testing.gui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInComponent extends BaseComponent {

    @FindBy(xpath = "//input[@name='email']")
    private ExtendedWebElement inputEmail;

    @FindBy(xpath = "//button[text()='Continue']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//input[@aria-label='Password']")
    private ExtendedWebElement inputPassword;

    @FindBy(xpath = "//button[text()='Next']")
    private ExtendedWebElement nextButton;

    @FindBy(xpath = "//span[contains(text(),\"Sorry, we don't recognize that username or password.\")]")
    private ExtendedWebElement warning;


    public LogInComponent(WebDriver driver) {
        super(driver);
    }

    public void inputEmail(String email) {
        inputEmail.type(email);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void inputPassword(String password) {
        inputPassword.type(password);
    }

    public void clickNext() {
        nextButton.click();
    }

    public Boolean visibleWarning() {
        return warning.isPresent();
    }

    public String getEmailValue() {
        return inputEmail.getAttribute("value");
    }

    public String getPasswordValue() {
        return inputPassword.getAttribute("value");
    }

}
