package webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String WINDOWS = "windows";
    public static final String LINUX = "linux";

    private static WebDriver webDriver = null;

    public static WebDriver getInstance(String browser, String platform) {

        if (webDriver != null) {
            return webDriver;
        }

        if (CHROME.equalsIgnoreCase(browser)) {
            if (WINDOWS.equalsIgnoreCase(platform)) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                webDriver = new ChromeDriver();

            } else if (LINUX.equalsIgnoreCase(platform)) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                webDriver = new ChromeDriver();
            }


        } else if (FIREFOX.equalsIgnoreCase(browser)) {
            if (WINDOWS.equalsIgnoreCase(platform)) {
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                webDriver = new FirefoxDriver();

            } else if (LINUX.equalsIgnoreCase(platform)) {
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
                webDriver = new ChromeDriver();
            }
        }

        return webDriver;
    }
}
