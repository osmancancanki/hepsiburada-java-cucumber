package pages;

import base.BaseTest;
import utils.ElementReader;

public class HomePage extends BaseTest {
    ElementReader elementReader = new ElementReader("element");

    public void navigateToHomePage(){
        baseUrl();
    }
    public void navigateToLogIn() {
        getDriver().findElement(elementReader.getElementValue("home_login_dropdown")).click();
        getDriver().findElement(elementReader.getElementValue("home_login_item")).click();
    }

    public void searchForProduct(String product) {
        getDriver().findElement(elementReader.getElementValue("home_search_input")).click();
        getDriver().findElement(elementReader.getElementValue("home_search_input")).sendKeys(product);
        getDriver().findElement(elementReader.getElementValue("home_search_button")).click();
    }
}
