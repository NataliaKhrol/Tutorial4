package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {
    @Test
    public void goodsAdded() throws InterruptedException {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpen();
        productsPage.addGoodsToCart("Sauce Labs Bike Light");
      /*  productsPage.addGoodsToCart("Sauce Labs Fleece Jacket");
        productsPage.addGoodsToCart("Sauce Labs Onesie");*/
        productsPage.switchToCart();

        assertEquals(cartPage.getProductsNames().size(), 1);
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Bike Light"));
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}
