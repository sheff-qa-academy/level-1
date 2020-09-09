import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.ForceClick;
import utils.PropertyLoader;

import static org.testng.Assert.*;

public class CategoriesTestCases extends TestBase {

    private MainPage mainPage;
    private LoginPage loginPage;
    private AnyPage anyPage;
    private PopularCategoriesPage popularCategoriesPage;
    private String username;
    private String password;
    private String text1, text2, text3;
    private WebElement element;
    private ForceClick forceClick;

    @BeforeTest
    public void SetUp() {
        mainPage = new MainPage(app.getWebDriver());
        loginPage = new LoginPage(app.getWebDriver());
        anyPage = new AnyPage(app.getWebDriver());
        popularCategoriesPage = new PopularCategoriesPage(app.getWebDriver());
        username = PropertyLoader.getProperty("user.username");
        password = PropertyLoader.getProperty("user.password");
        forceClick = new ForceClick(app.getWebDriver());
        text1 = "";
        text2 = "";
        text3 = "";

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

        popularCategoriesPage.init();
        assertTrue(popularCategoriesPage.getSize() > 0, "Popular Categories elements collection not found");

        element = popularCategoriesPage.getRandomDisplayedElement();
        text1 = element.getAttribute("textContent");
        forceClick.forceClick(element);
        text2 = anyPage.getH1();
        assertTrue(text1.equalsIgnoreCase(text2), "Category name does not match: Text on element is \"" + text1 + "\", " + "h1 text is " + "\"" + text2 + "\".");

        mainPage.open();
        assertTrue(mainPage.atPage(), "This is not the main page");


    }
}
