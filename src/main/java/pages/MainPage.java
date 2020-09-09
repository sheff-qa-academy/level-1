package pages;

import org.openqa.selenium.WebDriver;
import utils.PropertyLoader;

public class MainPage extends BasePage {

//    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(PropertyLoader.getProperty("site.url"));
    }

    public boolean atPage() {
        if (driver.getTitle().equals("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов")) {
            return true;
        } else {
            return false;
        }
    }
}
