package webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";

    private static WebDriver webDriver = null;

    public static WebDriver getInstance(String browser) {

        if (webDriver != null) {
            return webDriver;
        }

        if (CHROME.equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            webDriver = new ChromeDriver();

        } else if (FIREFOX.equals(browser)) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            webDriver = new FirefoxDriver();

        }

        return webDriver;
    }
}
