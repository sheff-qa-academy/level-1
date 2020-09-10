import checks.CheckAuthorization;
import locators.LocatorsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.*;

import java.util.List;

import static org.testng.Assert.*;

public class CategoriesTestCases extends TestBase {

    private MainPage mainPage;
    private AnyPage anyPage;
    private LoginPage loginPage;
    private LogOutPage logOutPage;
    private CheckAuthorization checkAuthorization;
    private PopularCategoriesPage popularCategoriesPage;
    private ProductsCatalogPage productsCatalogPage;
    private ProductsCategoriesPage productsCategoriesPage;
    private String username;
    private String password;
    private String text1, text2, text3;
    private WebElement element;
    private List<WebElement> elementList;
    private ForceClick forceClick;
    private Actions actions;

    @BeforeTest
    public void SetUp() {
        mainPage = new MainPage(app.getWebDriver());
        anyPage = new AnyPage(app.getWebDriver());
        loginPage = new LoginPage(app.getWebDriver());
        logOutPage = new LogOutPage(app.getWebDriver());
        checkAuthorization = new CheckAuthorization(app.getWebDriver());
        popularCategoriesPage = new PopularCategoriesPage(app.getWebDriver());
        productsCatalogPage = new ProductsCatalogPage(app.getWebDriver());
        productsCategoriesPage = new ProductsCategoriesPage(app.getWebDriver());
        username = PropertyLoader.getProperty("user.username");
        password = PropertyLoader.getProperty("user.password");
        forceClick = new ForceClick(app.getWebDriver());
        text1 = "";
        text2 = "";
        text3 = "";
        actions = new Actions(app.getWebDriver());

    }

    @Test
    public void categoriesCheckTestCase() {

        mainPage.open();
        assertTrue(mainPage.atPage(), "This is not the main page");

        loginPage.open();
        assertTrue(loginPage.atPage(), "This is not the login page");

        loginPage.enterLogin(username);

        // клик по элементу не работает
//        element = app.getWebDriver().findElement(By.xpath(LocatorsMainPage.LOG_IN_AUTORIZATION_BUTTON));
//        assertTrue(element.getText().equalsIgnoreCase("Войти"), "Login button not found");
//        actions.click(element);

        loginPage.enterPassword(password);
        loginPage.submit();
        assertTrue(mainPage.atPage(), "This is not the main page");

        popularCategoriesPage.init();
        assertTrue(popularCategoriesPage.getSize() > 0, "Popular Categories elements collection not found");

        element = popularCategoriesPage.getRandomDisplayedElement();
        text1 = element.getAttribute("textContent");
        forceClick.forceClick(element);
        text2 = anyPage.getH1();
//        assertTrue(text1.equalsIgnoreCase(text2), "Category name does not match: Text on element is \"" + text1 + "\", " + "h1 text is " + "\"" + text2 + "\".");

        mainPage.open();
        assertTrue(mainPage.atPage(), "This is not the main page");

        productsCatalogPage.open();
        assertTrue(productsCatalogPage.atPage(), "Products catalog was not open");

        productsCategoriesPage.init();
        assertTrue(productsCategoriesPage.getSize() > 0, "Products Categories elements collection not found");

        CSVRecorder.writeToCSV(productsCategoriesPage.getAllElements(), "textContent", "data.csv");


        logOutPage.logOut();
        assertTrue(checkAuthorization.isButtonLoginDisplayd(), "User is not logged in");
    }
}
