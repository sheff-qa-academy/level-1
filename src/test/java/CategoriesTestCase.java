import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.TestBase;
import utils.PropertyLoader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CategoriesTestCase extends TestBase {

    private MainPage mainPage;
    private LoginPage loginPage;
    private String username;
    private String password;

    @BeforeTest
    public void SetUp() {
        mainPage = new MainPage(app.getWebDriver());
        loginPage = new LoginPage(app.getWebDriver());
        username = PropertyLoader.getProperty("user.username");
        password = PropertyLoader.getProperty("user.password");
    }

    @Test
    public void categoriesTest() {

        mainPage.open();
        assertTrue(mainPage.atPage());
        loginPage.open();
        assertTrue(loginPage.atPage());
        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
        

    }
}
