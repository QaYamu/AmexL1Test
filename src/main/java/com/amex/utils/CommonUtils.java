package com.amex.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    private By userConsentPopupAcceptButton = By.xpath("//button[@data-testid='granular-banner-button-accept-all']"); // More specific name


    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }
     catch (InterruptedException e) {
         Thread.currentThread().interrupt();
     }}

    /**
     * Handles the cookie popup if present.
     */
    public void handleCookiesPopup() {
        try {
            WebElement acceptButton = wait.until(ExpectedConditions.presenceOfElementLocated(userConsentPopupAcceptButton));
            if (acceptButton.isDisplayed()) {
                acceptButton.click();
            }
        } catch (Exception e) {

        }
    }
    }
