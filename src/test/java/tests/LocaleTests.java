package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LocaleTests extends BasicTest{

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES(){
        navPage.clickOnLanguagesButton();
        navPage.waitForLanguagesMenuToBeVisible();
        navPage.clickOnESButton();

        Assert.assertEquals(landingPage.getHeaderText(),
                "Página de aterrizaje",
                "Header should read \"Página de aterrizaje\"");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN(){
        navPage.clickOnLanguagesButton();
        navPage.waitForLanguagesMenuToBeVisible();
        navPage.clickOnEnButton();

        Assert.assertEquals(landingPage.getHeaderText(),
                "Landing",
                "Header should read \"Landing\"");
    }

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToCN(){
        navPage.clickOnLanguagesButton();
        navPage.waitForLanguagesMenuToBeVisible();
        navPage.clickOnCNButton();

        Assert.assertEquals(landingPage.getHeaderText(),
                "首页",
                "Header should read \"首页\"");
    }

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToFR(){
        navPage.clickOnLanguagesButton();
        navPage.waitForLanguagesMenuToBeVisible();
        navPage.clickOnFRButton();

        Assert.assertEquals(landingPage.getHeaderText(),
                "Page d'atterrissage",
                "Header should read \"Page d'atterrissage\"");
    }
}
