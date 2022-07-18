package pages;

import base.BaseTest;

public class CartPage {
    BaseTest baseTest= new BaseTest();

    public void checkForProducts() {
        baseTest.compareTextWithExpected("cart_first_product_item", "product_name");
        baseTest.compareTextWithExpected("cart_second_product_item", "product_name");
    }
}
