package pages;

import locators.LocatorsMainPage;
import org.openqa.selenium.WebDriver;
import utils.ElementsCollection;

public class PopularCategoriesPage extends ElementsCollection {

    public PopularCategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void init() {
        super.setElements(LocatorsMainPage.POPULAR_CATEGORIES);
    }
}