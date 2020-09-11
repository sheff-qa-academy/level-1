package pages;

import locators.LocatorsMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ForceClick;

public class ProductsCatalogPage extends BasePage {

    public ProductsCatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {

        ForceClick forceClick = new ForceClick(driver);

        if (driver.findElements(By.xpath(LocatorsMainPage.PRODUCTS_CATALOG_BUTTON_V1)).size() > 0) {

            forceClick.forceClick(By.xpath(LocatorsMainPage.PRODUCTS_CATALOG_BUTTON_V1));

        } else {

            forceClick.forceClick(By.xpath(LocatorsMainPage.PRODUCTS_CATALOG_BUTTON_V2));
        }
    }

    public boolean atPage() {
        if (driver.findElements(By.xpath("//*[@id='27903767']")).size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
