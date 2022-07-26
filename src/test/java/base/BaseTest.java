package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.ElementReader;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriverWait wait;
    public static WebDriver driver;
    public String expectedText;
    protected ConfigReader configReader = new ConfigReader("config");
    protected ElementReader elementReader = new ElementReader("element");

    public void initializeDriver() {

        if (configReader.getProperty("web_driver").equals("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            driver = new ChromeDriver(options);
            options.addArguments("incognito");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (configReader.getProperty("web_driver").equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (configReader.getProperty("web_driver").equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void testFailed() {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("target/" + System.currentTimeMillis() + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
