package com.amex;

import com.amex.pages.AllCardsPage;
import com.amex.pages.GoldCardDescriptionPage;
import com.amex.pages.HomePage;
import com.amex.pages.UserDetailsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmexTest extends BaseTest{

    private String baseURL = "https://www.americanexpress.com/fr-fr/?inav=NavLogo";

    @Test
    public void testCreditCardApplicationFlow() throws InterruptedException {
        driver.get(baseURL);
        HomePage homePage = new HomePage(driver);
        AllCardsPage allCardsPage = homePage.clickCartesAmericanExpress();
        GoldCardDescriptionPage goldCardDescriptionPage = allCardsPage.clickEnSavoirPlusCarteGold();
        UserDetailsPage userDetailsPage = goldCardDescriptionPage.clickDemandezVotreCarte();

        userDetailsPage.enterFirstName("Junk");
        userDetailsPage.enterLastName("Data");
        userDetailsPage.
                clickSauvegarderEtContinuer();

        Assert.assertTrue(userDetailsPage.isErrorMessageDisplayed(), "Error message should be displayed");
    }
}
