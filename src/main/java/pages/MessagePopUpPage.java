package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage{
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForErrorPopUpToBeVisible(){
        wait
                .withMessage("Error pop up should be visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__wrapper")));
    }

    public String getErrorPopUpMessage(){
        return driver.findElement(By.tagName("li")).getText();
    }

    public WebElement getCloseErrorButton(){
        return driver.findElement(By.cssSelector(".v-snack__wrapper .v-btn"));
    }

    public void waitForNotificationPopUpToBeVisible(){
        wait
                .withMessage("Notification pop up should be visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("v-dialog")));
    }

    public String getNotificationPopUpTitle(){
        return driver.findElement(By.className("dlgVerifyAccount")).getText();
    }

    public WebElement getCloseNotificationButton(){
        return driver.findElement(By.className("btnClose"));
    }
    public void clickOnCloseNotificationButton(){
        getCloseNotificationButton().click();
    }

    public void waitForSuccessfulPopUpToBeVisible(){
        wait.withMessage("Successful pop up should be visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".v-snack__wrapper.success")));
    }

    public String getSuccessfulPopUpMessage(){
        return driver.findElement(By.cssSelector(".success .v-snack__content")).getText();
    }

    public void waitForDeleteWarningDialogToBeVisible(){
        wait
                .withMessage("Delete warning dialog should be visible.")
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".v-dialog--active .v-card")));
    }

    public WebElement getDeleteButton(){
        return driver.findElement(By.cssSelector(".v-dialog--active .v-card .red--text"));
    }
    public void clickOnDeleteButton(){
        getDeleteButton().click();
    }

}
