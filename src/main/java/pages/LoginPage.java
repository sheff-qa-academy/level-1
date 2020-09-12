package pages;

import locators.LocatorsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class LoginPage extends BasePage {

    private ArrayList<String> handles;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.findElement(By.xpath(LocatorsMainPage.LOG_IN_BUTTON)).click();
        handles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
    }

    public void enterLogin(String login) {
        driver.findElement(By.cssSelector(LocatorsMainPage.INPUT_FIELD_LOGIN)).sendKeys(login);
        driver.findElement(By.cssSelector(LocatorsMainPage.INPUT_FIELD_LOGIN)).sendKeys(Keys.ENTER);
    }
    public void enterPassword(String password) {
        driver.findElement(By.cssSelector(LocatorsMainPage.INPUT_FIELD_PASSWORD)).sendKeys(password);
    }

    public boolean atPage() {
        if (driver.getTitle().equals("Авторизация")) {
            return true;
        } else {
            return false;
        }
    }

    public void submit() {
        driver.findElement(By.cssSelector(LocatorsMainPage.INPUT_FIELD_PASSWORD)).submit();
        driver.switchTo().window(handles.get(0));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
