package checks;

import locators.LocatorsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckAuthorization {

    private WebDriver driver;

    public CheckAuthorization(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isButtonLoginDisplayd() {

        return driver.findElements(By.xpath(LocatorsMainPage.LOG_IN_BUTTON)).size() > 0;
    }
}
