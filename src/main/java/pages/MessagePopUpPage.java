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



}
