package pages;

import base.BaseTest;

public class ProductPage {
    BaseTest baseTest = new BaseTest();

    public void chooseProduct() {
        baseTest.clickToElement("product_cart");
        baseTest.nextTab();
    }

    public void addProducts() {
        baseTest.clickToElement("product_first_add_button");
        baseTest.waitForSecond(1000);
        baseTest.clickToElement("product_close_modal_icon");
        baseTest.clickToElement("product_second_add_button");
        baseTest.waitForSecond(1000);
        baseTest.clickToElement("product_shopping_cart_button");
    }
}
