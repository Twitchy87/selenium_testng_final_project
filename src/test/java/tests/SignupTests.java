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
}
