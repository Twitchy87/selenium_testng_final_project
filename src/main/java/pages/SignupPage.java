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
    public void enterUserName(String name){
        getUserNameInput().clear();
        getUserNameInput().sendKeys(name);
    }

    public WebElement getUserEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public String getUserEmailInputType(){
        return getUserEmailInput().getAttribute("type");
    }
    public void enterUserEmail(String email){
        getUserEmailInput().clear();
        getUserEmailInput().sendKeys(email);
    }

    public WebElement getUserPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    public String getUserPasswordInputType(){
        return getUserPasswordInput().getAttribute("type");
    }
    public void enterUserPassword(String password){
        getUserPasswordInput().clear();
        getUserPasswordInput().sendKeys(password);
    }

    public WebElement getUserConfirmPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public String getUserConfirmPasswordInputType(){
        return getUserConfirmPasswordInput().getAttribute("type");
    }
    public void enterUserConfirmPassword(String confirmPassword){
        getUserConfirmPasswordInput().clear();
        getUserConfirmPasswordInput().sendKeys(confirmPassword);
    }

    public WebElement getSignupButton(){
        return driver.findElement(By.cssSelector("[type='submit']"));
    }
    public void clickOnSignupButton(){
        getSignupButton().click();
    }

    public void signup(String name, String email, String password, String confirmPassword){
        enterUserName(name);
        enterUserEmail(email);
        enterUserPassword(password);
        enterUserConfirmPassword(confirmPassword);
        clickOnSignupButton();
    }
}
