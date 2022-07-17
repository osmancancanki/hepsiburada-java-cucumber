package pages;

import base.BaseTest;
import utils.ConfigReader;
import utils.ElementReader;

public class LoginPage extends BaseTest {
    ElementReader elementReader = new ElementReader("element");
    ConfigReader configReader = new ConfigReader("config");

public void login(){
    getDriver().findElement(elementReader.getElementValue("login_email_input")).sendKeys(configReader.getProperty("user_email"));
    getDriver().findElement(elementReader.getElementValue("login_email_button")).click();
    getDriver().findElement(elementReader.getElementValue("login_password_input")).sendKeys(configReader.getProperty("user_password"));
    getDriver().findElement(elementReader.getElementValue("login_password_button")).click();
}
}
