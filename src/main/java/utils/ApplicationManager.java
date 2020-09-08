package utils;

import webdrivers.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;
    private String baseUrl;

    public ApplicationManager() {

        baseUrl = PropertyLoader.getProperty("site.url");

        driver = BrowserFactory.getInstance(PropertyLoader.getProperty("browser.name"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
