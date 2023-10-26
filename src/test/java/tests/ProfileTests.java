package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class ProfileTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheProfilePage(){
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

        loginPage.login(email, password);

        wait
                .withMessage("Url should be " + baseUrl + "/home")
                .until(ExpectedConditions.urlContains("/home"));

        navPage.clickOnMyProfileLink();

        wait
                .withMessage("Url should be " + baseUrl + "/profile")
                .until(ExpectedConditions.urlContains("/profile"));

        profilePage.waitForEmailInputTextToBeVisible(email);

        navPage.clickOnLogoutButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));
    }
}
