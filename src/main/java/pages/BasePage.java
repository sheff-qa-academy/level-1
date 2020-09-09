package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    public WebDriver getWebDriver() {
        return driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
