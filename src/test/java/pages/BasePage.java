package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasePage extends BaseTest {
    public WebElement findElement(String locatorName) {
        wait = new WebDriverWait(driver, 10);
        By locator = elementReader.getElementValue(locatorName);
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})", webElement);
        return webElement;
    }

    public void navigateToUrl(String url) {
        driver.get(configReader.getProperty(url));
    }

    public void clickToElement(String locatorName) {
        try {
            findElement(locatorName).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void compareTextWithExpected(String locatorName) {
        String text = findElement(locatorName).getText();
        assertThat(expectedText).isEqualTo(text);
    }

    public String getTextFromElement(String locatorName) {
        return findElement(locatorName).getText();
    }

    public void sendKeysToElement(String locatorName, String text) {
        try {
            findElement(locatorName).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void elementIsDisplayed(String locatorName) {
        findElement(locatorName).isDisplayed();
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
}
