package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

    public WebDriver driver;

    By login = By.cssSelector(".login-button");

    public landingPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement getLogin(){
        return driver.findElement(login);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
