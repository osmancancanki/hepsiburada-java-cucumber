package pages;

import base.BaseTest;

public class LoginPage {
    BaseTest baseTest = new BaseTest();

    public void login() {
        baseTest.sendKeysToElement("login_email_input", "user_email");
        baseTest.clickToElement("login_email_button");
        baseTest.sendKeysToElement("login_password_input", "user_password");
        baseTest.clickToElement("login_password_button");
    }
}
