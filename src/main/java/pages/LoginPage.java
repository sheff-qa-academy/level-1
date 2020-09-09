package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.findElement(By.xpath("//span[.='Войти']")).click();
        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
    }

    public void enterLogin(String login) {
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys(login);
        driver.findElement(By.xpath("//button[@data-t='button:action']")).click();
    }
    public void enterPassword(String password) {
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@name='passwd']")).submit();

    }

    public boolean atPage() {
        if (driver.getTitle().equals("Авторизация")) {
            return true;
        } else {
            return false;
        }
    }

}
