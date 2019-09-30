package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

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

    public void switchChildWindow(){

        //How many windows are open right now, will be stored in a set
        Set<String> ids = driver.getWindowHandles();

        //Get ID of child window
        Iterator<String> it = ids.iterator();
        String parentID = it.next();
        String childID = it.next();

        //Switch to child window
        driver.switchTo().window(childID);

    }

}
