package gittigidiyortest;

import gittigidiyormain.BasketPage;
import gittigidiyormain.HomePage;
import gittigidiyormain.LoginPage;
import gittigidiyormain.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import testlogger.TestResultLogger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest {
    WebDriver driver;

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    BasketPage basketPage;

    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        basketPage = new BasketPage(driver);
    }

    @AfterAll
    public void tearDown() {
        //driver.quit();
    }

}
