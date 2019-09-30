package pageObjects;

import org.openqa.selenium.WebDriver;
import resources.base;

public class loginPage extends base {

    public WebDriver driver;

    public loginPage(WebDriver driver){

        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
