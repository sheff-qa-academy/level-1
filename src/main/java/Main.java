import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

//        WebDriver driverFF = new FirefoxDriver();
        WebDriver driverChrome = new ChromeDriver();

//        driverFF.get("https://market.yandex.ru");

        driverChrome.get("https://market.yandex.ru");
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverChrome.manage().window().maximize();
        driverChrome.findElement(By.xpath("//span[@class='_14Uuc5WvKg' and text()='Войти']/parent::a")).click();

        ArrayList<String> handles = new ArrayList<>(driverChrome.getWindowHandles());
        driverChrome.switchTo().window(handles.get(1));
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverChrome.findElement(By.xpath("//input[@name='login']")).sendKeys("sheff-qa");
        driverChrome.findElement(By.xpath("//button[@data-t='button:action']")).click();
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverChrome.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Uxw29qwergt!$");
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverChrome.findElement(By.xpath("//input[@name='passwd']")).sendKeys(Keys.ENTER);
        driverChrome.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//        driverChrome.quit();
    }
}
