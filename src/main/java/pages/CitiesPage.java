package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getNewItemButton(){
        return driver.findElement(By.className("btnNewItem"));
    }
    public void clickOnNewItemButton(){
        getNewItemButton().click();
    }

    public void waitForNewItemDialogToBeVisible(){
        wait
                .withMessage("New Item dialog should be visible.")
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.className("dlgNewEditItem")));
    }

    public WebElement getNewItemNameInput(){
        return driver.findElement(By.id("name"));
    }
    public String getNewItemNameInputType(){
        return getNewItemNameInput().getAttribute("type");
    }
}
