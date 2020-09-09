import Locators.MainPageLocators;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.TestBase;
import utils.ElementsCollection;
import utils.PropertyLoader;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CategoriesTestCases extends TestBase {

    private MainPage mainPage;
    private LoginPage loginPage;
    private String username;
    private String password;
    private ElementsCollection elementsCollection;

    @BeforeTest
    public void SetUp() {
        mainPage = new MainPage(app.getWebDriver());
        loginPage = new LoginPage(app.getWebDriver());
        username = PropertyLoader.getProperty("user.username");
        password = PropertyLoader.getProperty("user.password");
        elementsCollection = new ElementsCollection(app.getWebDriver());
    }

    @Test
    public void categoriesCheckTestCase() {

        mainPage.open();
        assertTrue(mainPage.atPage(), "This is not the main page");
        loginPage.open();
        assertTrue(loginPage.atPage(), "This is not the login page");
        loginPage.enterLogin(username);
        loginPage.enterPassword(password);
        loginPage.submit();
        assertTrue(mainPage.atPage(), "This is not the main page");
        elementsCollection.setElements(MainPageLocators.POPULAR_CATEGORIES);
        elementsCollection.getRandomDisplayedElement().click();

    }
}
