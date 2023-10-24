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

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist(){
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

        loginPage.enterUserEmail(email);
        loginPage.enterUserPassword(password);
        loginPage.clickOnLoginButton();

        messagePopUpPage.waitForErrorPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getErrorPopUpMessage(),
                 "User does not exists",
                "Error message should be \"User does not exists\"");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "Should be on login page");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";

        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

        loginPage.enterUserEmail(email);
        loginPage.enterUserPassword(password);
        loginPage.clickOnLoginButton();

        messagePopUpPage.waitForErrorPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getErrorPopUpMessage(),
                "Wrong password",
                "Error message should be \"Wrong password\"");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "Should be on login page");
    }

    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void login(){
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));

        loginPage.enterUserEmail(email);
        loginPage.enterUserPassword(password);
        loginPage.clickOnLoginButton();

        wait
                .withMessage("Url should be " + baseUrl + "/home")
                .until(ExpectedConditions.urlContains("/home"));
    }
}
