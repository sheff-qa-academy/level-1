package pages;

import locators.LocatorsMainPage;
import org.openqa.selenium.WebDriver;

public class PopularCategoriesPage extends ElementsCollectionPage {

    public PopularCategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void init() {
        super.setElements(LocatorsMainPage.POPULAR_CATEGORIES);
    }
}