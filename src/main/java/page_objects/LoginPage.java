package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#userName")
    private WebElement usernameField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#login")
    private WebElement loginButton;

    public HomePage fullLogin(){
        setText(usernameField, Constants.USERNAME);
        setText(passwordField,Constants.PASSWORD);
        scroll(loginButton);
        click(loginButton);
        return new HomePage(driver);
    }
}
