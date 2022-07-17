package pages;

import base.BaseTest;
import org.junit.Assert;
import utils.ElementReader;

import java.util.List;

public class CartPage extends BaseTest {
    ElementReader elementReader = new ElementReader("element");
    ProductPage productPage = new ProductPage();

    public void checkForProducts() {
        String firstText = getDriver().findElement(elementReader.getElementValue("cart_first_product_item")).getText();
        String secondText = getDriver().findElement(elementReader.getElementValue("cart_second_product_item")).getText();
        List<String> productNameList = productPage.productName();
        String productName = productNameList.get(0);
        Assert.assertEquals("First product is added successfully", productName, firstText);
        Assert.assertEquals("Second product is added successfully", productName, secondText);
    }
}
