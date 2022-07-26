package pages;

public class ProductPage extends BasePage {

    public void chooseProduct() {
        getTextFromElement("product_cart");
        clickToElement("product_cart");
        nextTab();
    }

    public void addProducts() {
        clickToElement("product_first_add_button");
        waitForSecond(1000);
        clickToElement("product_close_modal_icon");
        clickToElement("product_second_add_button");
        waitForSecond(1000);
        clickToElement("product_shopping_cart_button");
    }
}
