package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void setText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public String get(WebElement element) {
        return element.getText();
    }

    public List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }

    public HomePage wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        return new HomePage(driver);
    }

    public HomePage scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        return new HomePage(driver);
    }

    public BookPage scroll2(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        return new BookPage(driver);
    }
}
