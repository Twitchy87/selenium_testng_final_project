package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage(){
        navPage.clickOnLanguagesButton();
        navPage.waitForLanguagesMenuToBeVisible();
        navPage.clickOnEnButton();
        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

        Assert.assertEquals(loginPage.getEmailInputType(),"email",
                "Input type for email should be email.");

        Assert.assertEquals(loginPage.getPasswordInputType(),"password",
                "Input type for password should be password.");
    }
}
