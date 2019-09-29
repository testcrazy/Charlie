import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.base;
import pageObjects.landingPage;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class mainPage extends base {

    private static Logger Log = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initialize() throws IOException{

        driver = initializeDriver();
        Log.info("Driver is initialized");

        driver.get(prop.getProperty("url"));
        Log.info("navigated to home page");
    }

    @Test
    public void validationLandingPageTitle() throws IOException{

        landingPage lp = new pageObjects.landingPage(driver);

        //Compare landing page title with stored data
        Assert.assertEquals(lp.getTitle(), prop.getProperty("landingPageTitle"));
        Log.info("Successfully validated page title");
    }

    @Test
    public void validationLoginBtn() throws IOException{
        landingPage lp = new pageObjects.landingPage(driver);

        //Check if Login btn is displayed
        Assert.assertTrue(lp.getLogin().isDisplayed());
        Log.info("Successfully validated login btn");
    }

    @Test
    public void clickLoginBtn() throws IOException, InterruptedException {
        landingPage lp = new pageObjects.landingPage(driver);

        //Click login btn to get to next page
        sleep(2000);
        lp.clickLogin().click();
        Log.info("Successfully clicked the Login btn");
    }




}
