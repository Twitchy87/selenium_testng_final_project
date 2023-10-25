package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities(){
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

        loginPage.login(email, password);

        navPage.clickOnAdminButton();

        navPage.waitForAdminMenuToBeVisible();
        navPage.clickOnCitiesButton();

        wait
                .withMessage("Url should be " + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlContains("/admin/cities"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateOrEditNewCity(){
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

        loginPage.login(email, password);

        navPage.clickOnAdminButton();

        navPage.waitForAdminMenuToBeVisible();
        navPage.clickOnCitiesButton();

        wait
                .withMessage("Url should be " + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlContains("/admin/cities"));

        citiesPage.clickOnNewItemButton();
        citiesPage.waitForNewItemDialogToBeVisible();
        Assert.assertEquals(citiesPage.getNewItemNameInputType(), "text",
                "New Item name input type should be text.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity(){
        String email = "admin@admin.com";
        String password = "12345";
        String city = "Nis";

        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

        loginPage.login(email, password);

        navPage.clickOnAdminButton();

        navPage.waitForAdminMenuToBeVisible();
        navPage.clickOnCitiesButton();

        wait
                .withMessage("Url should be " + baseUrl + "/admin/cities")
                .until(ExpectedConditions.urlContains("/admin/cities"));

        citiesPage.clickOnNewItemButton();
        citiesPage.waitForNewItemDialogToBeVisible();
        citiesPage.enterNewCity(city);
        citiesPage.waitForSaveButtonToBeClickable();
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitForSuccessfulPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessfulPopUpMessage().contains("Saved successfully"),
                "Successful pop up message should be \"Saved successfully\"");

    }
}
