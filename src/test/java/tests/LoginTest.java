package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void correctLogin() throws InterruptedException {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpen(), "");
    }

    @Test
    public void checkColor() {
        loginPage.openPage();
        assertEquals(loginPage.checkLoginBtnColor(), "rgb(61, 220, 145)");
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginData")
    public void incorrectLogin(String user, String password, String errorMsg) throws InterruptedException {
        loginPage.openPage();
        loginPage.login(user, password);
        assertEquals(loginPage.checkErrorMsg(), errorMsg);
    }
}
