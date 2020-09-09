import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.TestBase;

public class CategoriesTestCase extends TestBase {

    private MainPage mainPage = new MainPage(app.getWebDriver());
    private LoginPage loginPage;


    @Test
    public void categoriesTest() {

        mainPage.open();
        Assert.assertTrue(mainPage.atPage());

    }
}
