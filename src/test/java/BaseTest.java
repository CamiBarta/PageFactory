import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.BookPage;
import page_objects.HomePage;


public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    BookPage bookPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/books");

        homePage = new HomePage(driver);
        bookPage = new BookPage(driver);
    }

    @Test
    public void combinedTest() throws InterruptedException {
        homePage.clickLogin()
                .fullLogin()
                .wait(5)
                .clickFirstBook();
        bookPage.addBookToCollection();
        Thread.sleep(5000);
        bookPage.clickOkBtnOnAlertBox();
        bookPage.logOut();
    }
}
