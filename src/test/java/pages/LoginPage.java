package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Эта страница описывает страницу авторизации
 * */

public class LoginPage extends BasePage {
    private final By loginField = By.xpath("//*[@id='user-name']");
    private final By passwordField = By.cssSelector("[data-test='password']");
    private final By loginBtn = By.cssSelector("[value='Login']");
    private final By errorMsg = By.xpath("//h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(BASE_URL);
    }

    public void login(final String login, final String password) {
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public String checkErrorMsg() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return driver.findElement(errorMsg).getText();
    }
}
