package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART_PATTERN =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private static final String DATA_TEST_PATTERN = "[data-test='%s']";
    private final By title = By.xpath("//*[text()='Products']");
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpen() {
        return driver.findElement(title).isDisplayed();
    }

    public void addGoodsToCart(String goodsName) {
        //By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, "Sauce Labs Bike Light"));
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public void switchToCart() {
        driver.findElement(cartLink).click();
    }
}
