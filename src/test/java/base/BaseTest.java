package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.ElementReader;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriverWait wait;
    private static WebDriver driver;
    ConfigReader configReader = new ConfigReader("config");
    ElementReader elementReader = new ElementReader("element");

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

    public void baseUrl(String baseUrl) {
        driver.get(configReader.getProperty(baseUrl));
    }

    public WebElement findElement(String locatorName) {
        wait = new WebDriverWait(driver, 10);
        By locator = elementReader.getElementValue(locatorName);
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", webElement);
        return webElement;
    }

    public void clickToElement(String locatorName) {
        driver.findElement(elementReader.getElementValue("home_login_dropdown")).click();
        WebElement element = findElement(locatorName);
        try {
            element.click();
        } catch (Exception e) {
            testFailed();
        }
    }

    public void compareTextWithExpected(String locatorName, String expectedText) {
        String text = findElement(locatorName).getText();
        expectedText = configReader.getProperty(expectedText);
        Assert.assertEquals("Product is added to shopping cart", text, expectedText);
    }

    public void sendKeysToElement(String locatorName, String text) {
        WebElement element = findElement(locatorName);
        element.sendKeys(text);
    }

    public void waitForSecond(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void nextTab() {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
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
