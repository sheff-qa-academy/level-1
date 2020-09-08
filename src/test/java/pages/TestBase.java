package pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
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
