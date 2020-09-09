package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ElementsCollection {

    WebDriver driver;

    private List<WebElement> elements;
    private List<WebElement> displayedElements = new ArrayList<>();

    public ElementsCollection(WebDriver driver) {
        this.driver = driver;
    }

    public void setElements(String path) {
        elements = driver.findElements(By.xpath(path));

    }

    public List<WebElement> getDisplayedElements() {

        for(int i = 0; i < elements.size(); i++) {
            if (elements.get(i).isDisplayed())
                displayedElements.add(elements.get(i));
        }

        return displayedElements;

    }

    public WebElement getRandomDisplayedElement() {

        for(int i = 0; i < elements.size(); i++) {
            if (elements.get(i).isDisplayed())
                displayedElements.add(elements.get(i));
        }

        return displayedElements.get((int) (Math.random() * displayedElements.size() - 1));
    }

    public WebElement getRandomElement() {

        return elements.get((int) (Math.random() * elements.size()));
    }

    public String getAttribute(String attribute, int index) {
        return elements.get(index).getAttribute(attribute);
    }

    public WebElement getElement(int index) {
        return elements.get(index);
    }
}
