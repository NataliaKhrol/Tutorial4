package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Эта страница описывает страницу авторизации
 */

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public ArrayList<String> getProductsNames() {
        List<WebElement> allProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProducts) {
            names.add(product.getText());
        }

        return names;
    }
}
