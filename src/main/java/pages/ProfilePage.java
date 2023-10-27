package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public void waitForEmailInputTextToBeVisible(String email){
        wait
                .withMessage("Email input value should be " + email)
                .until(ExpectedConditions.textToBePresentInElementValue(
                        getEmailInput(), email));
    }
    public String getEmailInputType(){
        return getEmailInput().getAttribute("type");
    }
    public boolean disabledEmailInput(){
        return getEmailInput().isEnabled();
    }

    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }
    public String getNameInputType(){
        return getNameInput().getAttribute("type");
    }

    public WebElement getPhoneInput(){
        return driver.findElement(By.id("phone"));
    }
    public String getPhoneInputType(){
        return getPhoneInput().getAttribute("type");
    }

    public WebElement getCityInput(){
        return driver.findElement(By.id("city"));
    }
    public String getCityInputType(){
        return getCityInput().getAttribute("type");
    }

    public WebElement getCountryInput(){
        return driver.findElement(By.id("country"));
    }
    public String getCountryInputType(){
        return getCountryInput().getAttribute("type");
    }

    public WebElement getUrlTwitterInput(){
        return driver.findElement(By.id("urlTwitter"));
    }
    public String getUrlTwitterInputType(){
        return getUrlTwitterInput().getAttribute("type");
    }

    public WebElement getUrlGitHubInput(){
        return driver.findElement(By.id("urlGitHub"));
    }
    public String getUrlGitHubInputType(){
        return getUrlGitHubInput().getAttribute("type");
    }


}
