package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnyPage extends BasePage {

    public AnyPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getH1(){
        return driver.findElement(By.xpath("//h1")).getAttribute("textContent");
    }
}
