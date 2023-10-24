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
}
