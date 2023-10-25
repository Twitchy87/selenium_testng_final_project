package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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
    public void enterNewCity(String city){
        getNewItemNameInput().clear();
        getNewItemNameInput().sendKeys(city);
    }

    public WebElement getSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnSaveButton(){
        getSaveButton().click();
    }
    public void waitForSaveButtonToBeClickable(){
        wait
                .withMessage("Save button should be clickable.")
                .until(ExpectedConditions.elementToBeClickable(getSaveButton()));
    }

    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }
    public void searchForCity(String city){
        getSearchInput().clear();
        getSearchInput().sendKeys(city);
    }

    public void waitForSearchForCityResultToBeOne(){
        wait.withMessage("One city should be displayed after search.")
                .until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody tr"), 1));
    }

    public WebElement getEditButton(){
        return driver.findElement(By.id("edit"));
    }
    public void clickOnEditButton(){
        getEditButton().click();
    }

    public WebElement getEditItemInput(){
        return driver.findElement(By.id("name"));
    }
    public void enterEditedItem(String newCity) throws InterruptedException {
        List<Character> chars = new ArrayList<>();
        for (char ch : newCity.toCharArray()) {

            chars.add(ch);
        }

        for (char ch : chars){
            getEditItemInput().sendKeys(Keys.BACK_SPACE);
        }
        Thread.sleep(2000);
        getEditItemInput().sendKeys(newCity);

    }

    public String getNameOfCity(){
        return driver.findElement(By.cssSelector("tr td:nth-child(2)")).getText();
    }

    public WebElement getClearSearchButton(){
        return driver.findElement(By.xpath("//*[contains(@class,'layout')]//*[@class='v-input__append-inner'][1]"));
    }
    public void clickOnClearSearchButton(){
        getClearSearchButton().click();
    }
}
