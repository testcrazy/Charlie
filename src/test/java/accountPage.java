import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

        //Validate if welcome message is correct
        sleep(2000);
        Assert.assertEquals(ap.getWelcome().getText(), prop.getProperty("accountPageWelcome"));
        Log.info("Successfully validated welcome message");
    }
    @Test(priority = 6 ,dataProvider = "getData")
    public void loginTests(String email, String password)throws IOException{
        loginPage ap = new pageObjects.loginPage(driver);

        //Enter email and password
        ap.getEmail().sendKeys(email);
        ap.getPassword().sendKeys(password);

        //Click login btn
        ap.getLoginBtn().click();
        Log.info("Entered username, password and clicked login btn");

        //Check for displayed error message
        Assert.assertTrue(ap.getloginError().isDisplayed());
        Log.info("Error message is displayed");

        //Clear input fields for next test
        ap.getEmail().clear();
        ap.getPassword().clear();
    }


    @DataProvider
    public Object[][] getData(){
        Object[][] data = new Object[8][2];

        data [0][0] = "6317@berlin-htw";
        data [0][1] = "Pluspeter";

        data [1][0] = "6317@berlin-htw.de";
        data [1][1] = "pluspeter";

        data [2][0] = "@berlin-htw.de";
        data [2][1] = "PLUSPETER";

        data [3][0] = "berlin-htw.de";
        data [3][1] = "Pluspeter";

        data [4][0] = "6317@berlin-htw.de";
        data [4][1] = "PLUSPETER";

        data [5][0] = "6317@berlin-htw.de";
        data [5][1] = "Pluspeter1";

        data [6][0] = "6317@berlin-htw.de";
        data [6][1] = "1Pluspeter";

        data [7][0] = "6317@berlin-htw.de";
        data [7][1] = "Pluspeter";

        return data;
    }
}
