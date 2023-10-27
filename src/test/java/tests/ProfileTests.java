package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
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


        Assert.assertEquals(profilePage.getEmailInputType(),
                "email",
                "Email input type should be email");

        Assert.assertFalse(profilePage.disabledEmailInput(),
                "Email input should be disabled");

        Assert.assertEquals(profilePage.getNameInputType(),
                "text",
                "Name input type should be text.");

        Assert.assertEquals(profilePage.getPhoneInputType(),
                "tel",
                "Phone input type should be tel.");

        Assert.assertEquals(profilePage.getCityInputType(),
                "text",
                "City input type should be text.");

        Assert.assertEquals(profilePage.getCountryInputType(),
                "text",
                "Country input type should be text.");

        Assert.assertEquals(profilePage.getUrlTwitterInputType(),
                "url",
                "Twitter url input type should be url.");

        Assert.assertEquals(profilePage.getUrlGitHubInputType(),
                "url",
                "GitHub url input type should be url.");

        navPage.clickOnLogoutButton();

        wait
                .withMessage("Url should be " + baseUrl + "/login")
                .until(ExpectedConditions.urlContains("/login"));
    }
}
