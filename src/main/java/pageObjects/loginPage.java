package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.base;

public class loginPage extends base {

    public WebDriver driver;

    By emailInput = By.id("email");
    By passwordInput = By.id("password");
    By loginBtn = By.cssSelector(".appButton");
    By forgotPassw = By.cssSelector(".forgotPass");
    By signUp = By.cssSelector(".go-to-register > a:nth-child(1)");
    By welcomeMsg = By.xpath("/html/body/div/div[3]/div/h1");
    By loginError = By.cssSelector(".register-subtitle");


    public loginPage(WebDriver driver){

        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public WebElement getEmail(){
        return driver.findElement(emailInput);
    }

    public WebElement getPassword(){
        return driver.findElement(passwordInput);
    }

    public WebElement getLoginBtn(){
        return driver.findElement(loginBtn);
    }

    public WebElement passwordReset(){
        return driver.findElement(forgotPassw);
    }

    public WebElement signUp(){
        return driver.findElement(signUp);
    }

    public WebElement getWelcome(){
        return driver.findElement(welcomeMsg);
    }

    public WebElement getloginError(){
        return driver.findElement(loginError);
    }


}
