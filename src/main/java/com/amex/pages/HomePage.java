package com.amex.pages;

import com.amex.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private CommonUtils utils;

    private By cartesAmericanExpressButton = By.xpath("//p[text()='Cartes American Express®']");
    private By userConsentPopupAcceptButton = By.xpath("//button[@data-testid='granular-banner-button-accept-all']"); // More specific name
    private By userConsentPopupDeclineButton = By.xpath("//button[@data-testid='granular-banner-button-decline-all']");
    private By userConsentPopupManageButton = By.xpath("//button[@data-testid='granular-banner-button-manage']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        utils.handleCookiesPopup();
    }

    /**
     * Clicks on "Accept All Cookies" button.
     * @return HomePage instance
     */
    public HomePage acceptAllCookies() {
        WebElement acceptButton = driver.findElement(userConsentPopupAcceptButton);
        utils.waitForClickability(acceptButton);
        acceptButton.click();
        return this;
    }

    /**
     * Clicks on "Decline All Cookies" button.
     * @return HomePage instance
     */
    public HomePage declineAllCookies() {
        WebElement declineButton = driver.findElement(userConsentPopupDeclineButton);
        utils.waitForClickability(declineButton);
        declineButton.click();
        return this;
    }

    /**
     * Clicks on "Manage Cookies" button.
     * @return HomePage instance
     */
    public HomePage manageCookies() {
        WebElement manageButton = driver.findElement(userConsentPopupManageButton);
        utils.waitForClickability(manageButton);
        manageButton.click();
        return this;
    }

    /**
     * Clicks on "Cartes American Express" and navigates to AllCardsPage.
     * @return AllCardsPage instance
     */
    public AllCardsPage clickCartesAmericanExpress()  {

        WebElement cartesButton = driver.findElement(cartesAmericanExpressButton);
        utils.waitForClickability(cartesButton);
        cartesButton.click();
        return new AllCardsPage(driver);
    }


}
