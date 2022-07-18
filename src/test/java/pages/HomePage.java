package pages;

import base.BaseTest;

public class HomePage {
    BaseTest baseTest = new BaseTest();

    public void navigateToHomePage(){
        baseTest.baseUrl("base_url");
    }

    public void navigateToLogIn() {
        baseTest.clickToElement("home_login_dropdown");
        baseTest.clickToElement("home_login_item");
    }

    public void searchForProduct(String product) {
        baseTest.clickToElement("home_search_input");
        baseTest.sendKeysToElement("home_search_input",product);
        baseTest.clickToElement("home_search_button");
    }

    public void checkForLogin() {
        baseTest.compareTextWithExpected("home_logged_in_dropdown","user_name");
    }
}
