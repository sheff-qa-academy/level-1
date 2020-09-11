package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementsCollectionPage extends BasePage {

    private List<WebElement> elementList;
    private List<WebElement> displayedElements = new ArrayList<>();
    private int size = 0;

    public ElementsCollectionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setElementList(String path) {
        elementList = driver.findElements(By.xpath(path));
        size = elementList.size();

    }

    public List<WebElement> getDisplayedElements() {

        for(int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).isDisplayed())
                displayedElements.add(elementList.get(i));
        }

        return displayedElements;
    }

    public List<WebElement> getAllElements() {
        return elementList;
    }

    public WebElement getRandomDisplayedElement() {

        for(int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).isDisplayed())
                displayedElements.add(elementList.get(i));
        }

        return displayedElements.get((int) (Math.random() * displayedElements.size() - 1));
    }

    public WebElement getRandomElement() {

        return elementList.get((int) (Math.random() * elementList.size()));
    }

    public String getAttribute(String attribute, int index) {
        return elementList.get(index).getAttribute(attribute);
    }

    public ArrayList<String> getAllElementsAtribute (String attribute) {

        ArrayList<String> list = new ArrayList<>(elementList.size());
        for (WebElement elements : elementList) {
            list.add(elements.getAttribute(attribute));
        }
        return  list;
    }

    public WebElement getElement(int index) {
        return elementList.get(index);
    }

    public int getSize() {
        return this.size;
    }
}
