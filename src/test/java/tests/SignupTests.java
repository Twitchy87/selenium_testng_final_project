package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignupTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage(){
        navPage.clickOnSignupButton();

        wait
                .withMessage("Url should be " + baseUrl + "/signup")
                .until(ExpectedConditions.urlContains("/signup"));
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnSignupButton();

        wait
                .withMessage("Url should be " + baseUrl + "/signup")
                .until(ExpectedConditions.urlContains("/signup"));

        Assert.assertEquals(signupPage.getUserNameInputType(), "text",
                "User name input type should be text.");

        Assert.assertEquals(signupPage.getUserEmailInputType(), "email",
                "User email input type should be email.");

        Assert.assertEquals(signupPage.getUserPasswordInputType(), "password",
                "User password input type should be password.");

        Assert.assertEquals(signupPage.getUserConfirmPasswordInputType(), "password",
                "User confirm password input type should be password.");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists(){
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSignupButton();

        wait
                .withMessage("Url should be " + baseUrl + "/signup")
                .until(ExpectedConditions.urlContains("/signup"));

        signupPage.signup(name, email, password, confirmPassword);

        messagePopUpPage.waitForErrorPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getErrorPopUpMessage(),
                "E-mail already exists",
                "Error message should be \"E-mail already exists\"");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup",
                "Should be on signup page");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void signup(){
        String name = "Ana Cvetkovic";
        String email = "Ana.Cvetkovic@itbootcamp.rs";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSignupButton();

        wait
                .withMessage("Url should be " + baseUrl + "/signup")
                .until(ExpectedConditions.urlContains("/signup"));

        signupPage.signup(name, email, password, confirmPassword);

        wait
                .withMessage("Url should be " + baseUrl + "/home")
                .until(ExpectedConditions.urlContains("/home"));

        messagePopUpPage.waitForNotificationPopUpToBeVisible();
        Assert.assertEquals(messagePopUpPage.getNotificationPopUpTitle(),
                "IMPORTANT: Verify your account",
                "Notification title should be \"IMPORTANT: Verify your account\"");

        messagePopUpPage.clickOnCloseNotificationButton();

        navPage.clickOnLogoutButton();
    }
}
