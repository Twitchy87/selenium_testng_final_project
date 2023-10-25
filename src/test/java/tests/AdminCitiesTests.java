package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

import javax.swing.plaf.TableHeaderUI;

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

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";
        String oldCity = "Madrid";
        String newCity = "Alicante";

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
        citiesPage.enterNewCity(oldCity);
        citiesPage.waitForSaveButtonToBeClickable();
        citiesPage.clickOnSaveButton();

        Thread.sleep(2000);

        citiesPage.searchForCity(oldCity);
        citiesPage.waitForSearchForCityResultToBeOne();

        Thread.sleep(2000);

        citiesPage.clickOnEditButton();
        citiesPage.enterEditedItem(newCity);

        Thread.sleep(2000);

        citiesPage.clickOnSaveButton();

        Thread.sleep(2000);

        messagePopUpPage.waitForSuccessfulPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getSuccessfulPopUpMessage().contains("Saved successfully"),
                "Successful pop up message should be \"Saved successfully\"");

    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";
        String oldCity = "Madrid";
        String newCity = "Alicante";

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
        citiesPage.enterNewCity(oldCity);
        citiesPage.waitForSaveButtonToBeClickable();
        citiesPage.clickOnSaveButton();

        Thread.sleep(2000);

        citiesPage.searchForCity(oldCity);
        citiesPage.waitForSearchForCityResultToBeOne();

        Thread.sleep(2000);

        citiesPage.clickOnEditButton();
        citiesPage.enterEditedItem(newCity);

        Thread.sleep(2000);

        citiesPage.clickOnSaveButton();
        citiesPage.clickOnClearSearchButton();

        Thread.sleep(2000);

        citiesPage.searchForCity(newCity);
        citiesPage.waitForSearchForCityResultToBeOne();
        Assert.assertEquals(citiesPage.getNameOfCity(), newCity,
                "Result city should be " + newCity);
    }
}
