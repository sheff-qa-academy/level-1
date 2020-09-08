package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebDriver getWebDriver() {
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public BasePage ensurePageLoaded() {
        return this;
    }

    public boolean waitPageLoaded() {
        try {
            ensurePageLoaded();
            return true;
        } catch (TimeoutException to) {
            return false;
        }
    }
}
