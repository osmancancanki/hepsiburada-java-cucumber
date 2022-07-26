package pages;

public class HomePage extends BasePage{

    public void navigateToHomePage() {
        navigateToUrl("base_url");
    }

    public void navigateToLogIn() {
        clickToElement("home_login_dropdown");
        clickToElement("home_login_item");
    }

    public void searchForProduct(String product) {
        clickToElement("home_search_input");
        sendKeysToElement("home_search_input", product);
        clickToElement("home_search_button");
    }

    public void checkForLogin() {
        elementIsDisplayed("home_logged_in_dropdown");
    }
}
