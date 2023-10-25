package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasicPage{
    public LandingPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getHeaderText(){
        return driver.findElement(By.tagName("h1")).getText();
    }
}
