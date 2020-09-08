import com.opencsv.CSVWriter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException {



//        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

//        WebDriver driverFF = new FirefoxDriver();

        WebDriver driverChrome = new ChromeDriver();



        driverChrome.get("https://market.yandex.ru");
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverChrome.manage().window().maximize();
        driverChrome.findElement(By.xpath("//span[.='Войти']")).click();

        ArrayList<String> handles = new ArrayList<String>(driverChrome.getWindowHandles());
        driverChrome.switchTo().window(handles.get(1));

        driverChrome.findElement(By.cssSelector("#passp-field-login")).sendKeys("sheff-qa");
        driverChrome.findElement(By.xpath("//button[@data-t='button:action']")).click();
        driverChrome.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Uxw29qwergt!$");
        driverChrome.findElement(By.xpath("//input[@name='passwd']")).submit();

        driverChrome.switchTo().window(handles.get(0));

        List<WebElement> popularCategories = driverChrome.findElements(By.xpath("//div[1]/div[@data-zone-name='category-link']/div/a"));

        driverChrome.get(popularCategories.get(0).getAttribute("href"));

        driverChrome.get("https://market.yandex.ru");

        if (driverChrome.findElements(By.xpath("//span[.='Каталог товаров']/../parent::button")).size() > 0) {
            WebElement ele = driverChrome.findElement(By.xpath("//span[.='Каталог товаров']/../parent::button"));
            JavascriptExecutor executor = (JavascriptExecutor) driverChrome;
            executor.executeScript("arguments[0].click();", ele);
        } else {
            driverChrome.findElement(By.xpath("/html/body/div[2]/div[3]/noindex/div/div/div[2]/div")).click();
        }

        List<WebElement> allCategories =
                driverChrome.findElements(By.xpath("//div[@data-zone-name='category-link']/button/a/span"));

        String csv = "data.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        String[] record = new String[allCategories.size()];
        for (int i = 0; i < allCategories.size(); i++) {
            record[i] = allCategories.get(i).getAttribute("textContent");
        }
        writer.writeNext(record);
        writer.close();


        driverChrome.findElement(By.xpath("//img[@alt='user-avatar']/../../../button")).click();
        if (driverChrome.findElements(By.xpath("//div[.='sheff-qa@yandex.ru']/../../div[3]")).size() > 0) {
            driverChrome.findElement(By.xpath("//div[.='sheff-qa@yandex.ru']/../../div[3]")).click();
        }
        driverChrome.findElement(By.xpath("//*[.='Выйти']")).click();

        driverChrome.quit();
    }
}

