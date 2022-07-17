package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.ConfigReader;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    ConfigReader configReader = new ConfigReader("config");

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

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

    public void baseUrl() {
        driver.get(configReader.getProperty("base_url"));
    }

    public void nextTab() {
        ArrayList<String> tabs2 = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }
}
