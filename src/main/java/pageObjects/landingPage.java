package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

    public WebDriver driver;

    By login = By.cssSelector(".login-button");
    By loginBtn = By.xpath("//*[@id=\"menu\"]/div[4]/div[2]/a");

    public landingPage(WebDriver driver){

        this.driver = driver;
    }

    public WebElement getLogin(){
        return driver.findElement(login);
    }

    public WebElement clickLogin(){
        return driver.findElement(loginBtn);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
