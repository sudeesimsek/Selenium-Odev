package gittigidiyormain;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static org.openqa.selenium.WebDriver.*;

public class HomePage extends BasePage {
    WebDriverWait wait;

    public static final By loginBtn1 = By.xpath("//div[@class='gekhq4-5 grTfZj']");
    public static final By loginBtn2 = By.xpath("//div[@class='sc-12t95ss-3 fDarBX']");
    public static final By loginBtn3 = By.id("gg-login-enter");
    public static final By searchInputBox = By.cssSelector("input[data-cy='header-search-input']");
    public static final By homePageImg = By.cssSelector("img[alt*='GittiGidiyor']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void firstLogin() {
        clickElement(loginBtn1);
    }

    public void secondLogin() {
        WebElement element = driver.findElement(loginBtn2);
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();

    }

    public void goToLoginPage() throws Exception {
        clickElement(loginBtn3);
    }

    public void backHomePage() {
        clickElement(homePageImg);
    }

    public void typeProductNameOnSearchArea(String productName) {
        setText(searchInputBox, "Bilgisayar" + Keys.ENTER);
    }

    public void typeProductNameOnSearchArea2(String productName) {
        setText(searchInputBox, "Çanta" + Keys.ENTER);
    }
}
