package pages;

import locators.LocatorsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage extends BasePage {

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logOut() {

        driver.findElement(By.xpath(LocatorsMainPage.USER_AVATAR)).click();

        if (driver.findElements(By.xpath(LocatorsMainPage.LOG_OUT_BUTTON_V1)).size() > 0) {
            driver.findElement(By.xpath(LocatorsMainPage.LOG_OUT_BUTTON_V1)).click();
        }

        driver.findElement(By.xpath(LocatorsMainPage.LOG_OUT_BUTTON_V2)).click();
    }


}
