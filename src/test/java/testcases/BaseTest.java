package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    Logger logger;

    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        logger= LogManager.getLogger(BaseTest.class.getName());
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
        logger.info("Added book");
        Thread.sleep(5000);
        bookPage.clickOkBtnOnAlertBox();
        logger.info("Accepted alert");
        bookPage.logOut();
    }
}
