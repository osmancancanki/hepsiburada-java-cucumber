package pages;

import base.BaseTest;
import utils.ElementReader;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BaseTest {
    ElementReader elementReader = new ElementReader("element");

    public List<String> productName(){
        List<String> productList = new ArrayList<>();
        String text = getDriver().findElement(elementReader.getElementValue("product_cart")).getText();
        productList.add(text);
        return productList;
    }

    public void chooseProduct() {
        productName();
        getDriver().findElement(elementReader.getElementValue("product_cart")).click();
        nextTab();
    }

    public void addProducts() {
        getDriver().findElement(elementReader.getElementValue("product_first_add_button")).click();
        getDriver().findElement(elementReader.getElementValue("product_close_modal_icon")).click();
        getDriver().findElement(elementReader.getElementValue("product_second_add_button")).click();
        getDriver().findElement(elementReader.getElementValue("product_shopping_cart_button")).click();
    }
}
