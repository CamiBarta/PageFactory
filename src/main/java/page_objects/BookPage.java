package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends BasePage {

    public BookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".text-right.fullButton>#addNewRecordButton")
    private WebElement addToCollectionButton;

    @FindBy(css="#submit")
    private WebElement logOutButton;

    public void addBookToCollection(){
        scroll2(addToCollectionButton);
        click(addToCollectionButton);
    }

    public void clickOkBtnOnAlertBox(){
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public LoginPage logOut(){
        click(logOutButton);
        return new LoginPage(driver);
    }
}
