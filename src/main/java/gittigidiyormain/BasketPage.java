package gittigidiyormain;

import com.sun.javafx.collections.VetoableListDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class BasketPage extends BasePage {
    private static final By clickCountPart = By.xpath("//select[@class='amount']");
    private static final By increaseCountPart = By.xpath("//option[@value='2']");
    private static final By finishShoppingButton = By.xpath("//input[@class='gg-d-24 gg-ui-btn-primary gg-ui-btn-lg btn-pay']");
    private static final By adressSaveButton = By.xpath("//button[@class='gg-ui-btn-primary gg-btn post-address gg-ui-btn-fluid post-address-button gg-ui-btn-lg']");
    private static final By getAdressTextString = By.xpath("((//*[@class='gg-input-error-text gg-d-24'])//p)[6]");
    private static final By organizeBasketButton = By.xpath("(//a[@class='header-link pl10'])[2]");
    public static final By secondFavoriteProduct = By.xpath("(//a[@class='gg-ui-btn-default btn-add-to-basket'])[6]");
    public static final By thirdFavoriteProductClickButton = By.xpath("(//a[@class='btn-delete'])[2]");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void clickCount() {
        clickElement(clickCountPart);
    }

    public void increaseCount() {
        clickElement(increaseCountPart);

    }
    public void assertCont(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    public void finishShopping() {
        clickElement(finishShoppingButton);

    }

    public void saveAdress() {
        clickElement(adressSaveButton);
    }

    public void getAdressText() {
        System.out.println(findElement(getAdressTextString).getText());
    }

    public void organizeBasket() {
        clickElement(organizeBasketButton);

    }

    public void addToBasketSecondProduct() {
        clickElement(secondFavoriteProduct);
    }

    public void removeThirdProductFromFavorites() {
        clickElement(thirdFavoriteProductClickButton);

    }

    public void newTab() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.gittigidiyor.com/");
    }

    public void logOutFromSite() throws InterruptedException {
        Thread.sleep(2000);
        driver.get("https://www.gittigidiyor.com/cikis-yap");

    }

    public void closePages() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(300);
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(300);
        driver.close();
        driver.quit();
    }
}
