package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#login")
    private WebElement loginButton1;

    @FindBy(id = "see-book-Git Pocket Guide")
    private WebElement firstBook;

    public LoginPage clickLogin() {
        click(loginButton1);
        return new LoginPage(driver);
    }

    public List<WebElement> getBookElements() {
        return findElements(By.cssSelector(".rt-tr-group"));
    }


    public BookPage clickFirstBook() {
        click(firstBook);
        return new BookPage(driver);
    }
}
