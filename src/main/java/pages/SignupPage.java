package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getUserNameInput(){
        return driver.findElement(By.id("name"));
    }
    public String getUserNameInputType(){
        return getUserNameInput().getAttribute("type");
    }

    public WebElement getUserEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public String getUserEmailInputType(){
        return getUserEmailInput().getAttribute("type");
    }

    public WebElement getUserPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    public String getUserPasswordInputType(){
        return getUserPasswordInput().getAttribute("type");
    }

    public WebElement getUserConfirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public String getUserConfirmPasswordInputType(){
        return getUserConfirmPasswordInput().getAttribute("type");
    }
}
