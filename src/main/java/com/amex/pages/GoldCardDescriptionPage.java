package com.amex.pages;

import com.amex.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoldCardDescriptionPage {

    private WebDriver driver;
    private CommonUtils utils;

    private By demandezVotreCarteButton = By.xpath("//a[contains(text(), 'Demandez votre Carte')]");

    // Constructor to initialize WebDriver
    public GoldCardDescriptionPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new CommonUtils(driver);
        utils.handleCookiesPopup();
    }

    /**
     * Clicks on the "Demandez votre Carte" button and navigates to UserDetailsPage.
     * @return UserDetailsPage instance
     */
    public UserDetailsPage clickDemandezVotreCarte() {
        WebElement demandezvotreCarteButton = driver.findElement(demandezVotreCarteButton);
        utils.waitForClickability(demandezvotreCarteButton);
        demandezvotreCarteButton.click();
        return new UserDetailsPage(driver);
    }
}
