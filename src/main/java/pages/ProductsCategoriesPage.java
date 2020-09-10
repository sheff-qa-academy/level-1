package pages;

import locators.LocatorsMainPage;
import org.openqa.selenium.WebDriver;

public class ProductsCategoriesPage extends ElementsCollectionPage {

    public ProductsCategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void init() {
        super.setElements(LocatorsMainPage.PRODUCTS_CATEGORIES);
    }
}
