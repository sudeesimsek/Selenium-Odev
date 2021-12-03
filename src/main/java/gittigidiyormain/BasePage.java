package gittigidiyormain;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    public String test = "testx";
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findAllElements(By locator) {
        return driver.findElements(locator);
    }

    public void clickElement(By locator) {
        findElement(locator).click();
    }

    public void setText(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

}
