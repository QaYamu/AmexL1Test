package com.amex.pages;

import com.amex.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserDetailsPage {

    private WebDriver driver;
    private CommonUtils utils;

    private By firstNameField = By.id("fieldControl-input-firstName");
    private By lastNameField = By.id("fieldControl-input-lastName");
    private By sauvegarderEtContinuerButton = By.xpath("//button[text()='Sauvegarder et Continuer']");

    public UserDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        utils.handleCookiesPopup();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void clickSauvegarderEtContinuer() {

        WebElement element = driver.findElement(sauvegarderEtContinuerButton);
        utils.scrollToElement(element);
        CommonUtils.sleep(3000);
        element.click();
    }

    public boolean isErrorMessageDisplayed() {
        try {

            WebElement errorMessage = driver.findElement(By.xpath("//span[text()='Veuillez corriger les erreurs ci-dessus pour continuer.']"));
            return errorMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
