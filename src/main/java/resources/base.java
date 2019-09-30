package resources;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public static WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        //chrome
        //FF
        //IE or Edge
        prop = new Properties();
        FileInputStream fis = new FileInputStream("F:\\Charlie\\src\\main\\java\\resources\\data.properties");

        prop.load(fis);
        String browserName = prop.getProperty("browser");


        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "F:\\Charlie\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if (browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "F:\\Charlie\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (browserName.equals("IE")){
            System.setProperty("webdriver.ie.driver", "F:\\Charlie\\driver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        //Timeout to make sure that the landing page is fully loaded and no error will be thrown
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public void getScreenshot(String testName) throws  IOException{

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("F:\\Charlie\\ScreenshotsOnError\\+"+testName+"+screenshot.png"));
    }
}
