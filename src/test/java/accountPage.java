import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.loginPage;
import resources.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import static java.lang.Thread.sleep;

public class accountPage extends base {

    private static Logger Log = LogManager.getLogger(base.class.getName());

    @Test
    public void validateemailField() throws IOException{

        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if email input field is displayed
        Assert.assertTrue(ap.getEmail().isDisplayed());
        Log.info("Successfully validated email input field");
    }

    @Test(priority = 1)
    public void validatePasswField() throws IOException{
        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if password input field is displayed
        Assert.assertTrue(ap.getPassword().isDisplayed());
        Log.info("Successfully validated password input field");
    }

    @Test(priority = 2)
    public void validateLoginBtn() throws IOException{
        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if login btn is displayed
        Assert.assertTrue(ap.getLoginBtn().isDisplayed());
        Log.info("Successfully validated login btn");
    }

    @Test(priority = 3)
    public void validatePasswReset()throws IOException{
        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if password reset link is displayed
        Assert.assertTrue(ap.passwordReset().isDisplayed());
        Log.info("Successfully validated password reset link");
    }

    @Test(priority = 4)
    public void validatesignUp()throws IOException{
        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if signup for link is displayed
        Assert.assertTrue(ap.signUp().isDisplayed());
        Log.info("Successfully validated signup for link");
    }

    @Test(priority = 5)
    public void validateWelcomeMsg() throws IOException, InterruptedException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("F:\\Charlie\\src\\main\\java\\resources\\data.properties");

        prop.load(fis);

        loginPage ap = new pageObjects.loginPage(driver);

        //Validate if welc ome message is correct
        sleep(2000);
        Assert.assertEquals(ap.getWelcome().getText(), prop.getProperty("accountPageWelcome"));
        Log.info("Successfully validated welcome message");
    }
}
