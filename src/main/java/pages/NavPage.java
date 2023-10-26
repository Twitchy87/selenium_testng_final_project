package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLanguagesButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public void clickOnLanguagesButton(){
        getLanguagesButton().click();
    }

    public WebElement getEnButton(){
        return driver.findElement(By.className("btnEN"));
    }
    public void clickOnEnButton(){
        getEnButton().click();
    }

    public void waitForLanguagesMenuToBeVisible(){
        wait
                .withMessage("Languages menu should be visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("v-menu__content")));
    }

    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("header a[href='/login']"));
    }
    public void clickOnLoginButton(){
        getLoginButton().click();
    }

    public WebElement getLogoutButton(){
        return driver.findElement(By.className("btnLogout"));
    }
    public void waitForLogoutButtonToBeVisible(){
        wait.withMessage("Logout button should be visible.")
                .until(ExpectedConditions.visibilityOf(getLogoutButton()));
    }
    public void clickOnLogoutButton(){
        getLogoutButton().click();
    }

    public WebElement getSignupButton(){
        return driver.findElement(By.cssSelector("header a[href='/signup']"));
    }
    public void clickOnSignupButton(){
        getSignupButton().click();
    }

    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    public void clickOnAdminButton(){
        getAdminButton().click();
    }

    public void waitForAdminMenuToBeVisible(){
        wait
                .withMessage("Admin menu should be visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".v-menu__content .v-list")));
    }

    public WebElement getCitiesButton(){
        return driver.findElement(By.className("btnAdminCities"));
    }
    public void clickOnCitiesButton(){
        getCitiesButton().click();
    }

    public WebElement getESButton(){
        return driver.findElement(By.className("btnES"));
    }
    public void clickOnESButton(){
        getESButton().click();
    }

    public WebElement getCNButton(){
        return driver.findElement(By.className("btnCN"));
    }
    public void clickOnCNButton(){
        getCNButton().click();
    }

    public WebElement getFRButton(){
        return driver.findElement(By.className("btnFR"));
    }
    public void clickOnFRButton(){
        getFRButton().click();
    }

    public WebElement getUAButton(){
        return driver.findElement(By.className("btnUA"));
    }
    public void clickOnUAButton(){
        getUAButton().click();
    }

}
