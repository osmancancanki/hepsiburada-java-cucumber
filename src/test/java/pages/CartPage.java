package pages;

import base.BaseTest;

public class CartPage extends BasePage {

    public void checkForProducts() {
        expectedText = getTextFromElement("cart_first_product_item");
        compareTextWithExpected("cart_first_product_item");
        expectedText = getTextFromElement("cart_first_product_item");
        compareTextWithExpected("cart_second_product_item");
    }
}
