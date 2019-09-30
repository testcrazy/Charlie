import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.loginPage;
import resources.base;

public class accountPage extends base {

    private static Logger Log = LogManager.getLogger(base.class.getName());

    @Test
    public void validateemailField(){

        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if email input field is displayed
        Assert.assertTrue(ap.getEmail().isDisplayed());
        Log.info("Successfully validated email input field");
    }

    @Test(priority = 1)
    public void validatePasswField(){
        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if password input field is displayed
        Assert.assertTrue(ap.getPassword().isDisplayed());
        Log.info("Successfully validated password input field");
    }

    @Test(priority = 2)
    public void validateLoginBtn(){
        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if login btn is displayed
        Assert.assertTrue(ap.getLoginBtn().isDisplayed());
        Log.info("Successfully validated login btn");
    }

    @Test(priority = 3)
    public void validatePasswReset(){
        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if password reset link is displayed
        Assert.assertTrue(ap.passwordReset().isDisplayed());
        Log.info("Successfully validated password reset link");
    }

    @Test(priority = 4)
    public void validatesignUp(){
        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if signup for link is displayed
        Assert.assertTrue(ap.signUp().isDisplayed());
        Log.info("Successfully validated signup for link");
    }
}
