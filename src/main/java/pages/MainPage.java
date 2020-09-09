package pages;

import org.openqa.selenium.WebDriver;
import utils.PropertyLoader;

public class MainPage extends BasePage {

    String url = PropertyLoader.getProperty("site.url");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public boolean atPage() {
        if (driver.getTitle().equals("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов")) {
            return true;
        } else {
            return false;
        }
    }

    public String getURL() {
        return url;
    }
}