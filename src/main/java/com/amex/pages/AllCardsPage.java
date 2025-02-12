package com.amex.pages;

import com.amex.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AllCardsPage {

    private WebDriver driver;
    private CommonUtils utils;


    private By enSavoirPlusButton = By.xpath(
            "//a[contains(@class, 'btn') and contains(@href, 'gold-card-americanexpress') and contains(span, 'En savoir plus')]");


    // Constructor to initialize WebDriver
    public AllCardsPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        utils.handleCookiesPopup();
    }

    /**
     * Clicks on "En Savoir Plus" for the Gold Card and navigates to the GoldCardDescriptionPage.
     * @return GoldCardDescriptionPage instance
     */
    public GoldCardDescriptionPage clickEnSavoirPlusCarteGold() {
        driver.findElement(enSavoirPlusButton).click();
        return new GoldCardDescriptionPage(driver);
    }
}

