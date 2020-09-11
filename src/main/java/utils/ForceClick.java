package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForceClick {

    private WebDriver driver;
    private By locator;
    private WebElement element;

    public ForceClick(WebDriver driver) {
        this.driver = driver;
    }

    public void forceClick(By locator) {
        this.element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void forceClick(WebElement element) {
        this.element = element;
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
