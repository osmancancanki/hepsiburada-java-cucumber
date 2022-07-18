package steps;

import io.cucumber.java.en.Given;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

public class TestSteps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Given("^User navigates to home page$")
    public void user_navigates_to_home_page() {
        homePage.navigateToHomePage();
    }

    @Given("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String text) {
        homePage.searchForProduct(text);
    }

    @Given("^User chooses product$")
    public void user_chooses_product() {
        productPage.chooseProduct();
    }

    @Given("^User adds two product from different shops$")
    public void user_adds_two_product_from_different_shops() {
        productPage.addProducts();
    }

    @Given("^Products should be added to shopping cart$")
    public void products_should_be_added_to_shopping_cart() {
        cartPage.checkForProducts();
    }

    @Given("^User logs in with credentials$")
    public void user_logs_in_with_credentials() {
        homePage.navigateToLogIn();
        loginPage.login();
    }

    @Given("^User should be logged in$")
    public void user_should_be_logged_in() {
        homePage.checkForLogin();
    }
}
