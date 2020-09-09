import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenMainPage;
import pages.TestBase;

public class CategoriesTestCase extends TestBase {

    private OpenMainPage openMainPage = new OpenMainPage(app.getWebDriver());


    @Test
    public void categoriesTest() {

        openMainPage.open();
        Assert.assertTrue(openMainPage.atPage());

    }
}
