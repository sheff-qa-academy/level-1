package pages;

import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utils.ApplicationManager;

public class TestBase {

    protected ApplicationManager app;

    @BeforeClass
    public void init() {
        app = new ApplicationManager();

    }

    @AfterSuite
    public void stop() {
        app.stop();
    }

}
