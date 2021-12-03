package gittigidiyormain;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {
    private static final By addToBasketBag = By.xpath("//button[@class='control-button gg-ui-button plr10 gg-ui-btn-default']");
    public static final By goToBasketFromBagPage = By.xpath("//a[@class='gg-ui-btn-default padding-none']");
    public static final By favoriteButton = By.xpath("//div[@class='sc-1n49x8z-14 fIkZfb']");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void verticalScrollDown(int scrollLength) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String scrollString = ("scroll(0," + String.valueOf(scrollLength) + ")");
        ((JavascriptExecutor) driver).executeScript(scrollString);
    }

    public List<WebElement> listElements() {
        WebElement webDriver = null;
        return webDriver.findElements(favoriteButton);
    }


    public ProductsPage randomClick() throws InterruptedException {
        List<WebElement> tumUrunler;
        try {
            tumUrunler  = driver.findElements(By.cssSelector("div[data-cy=\"product-favorite\"]"));
            JavascriptExecutor executor = (JavascriptExecutor)driver;

            Thread.sleep(1000);
            Random random = new Random();


            for(int i=0;i<4;i++){
                int rastgeleUrun  = random.nextInt(tumUrunler.size()-1);
                executor.executeScript("arguments[0].click();", tumUrunler.get(rastgeleUrun));
                tumUrunler.remove(rastgeleUrun);
            }
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
        return this;
    }

    public void selectProductOnProductsPage() {
        clickElement(By.xpath("(//div[@class='sc-533kbx-0 sc-1v2q8t1-0 iCRwxx ixSZpI sc-1n49x8z-12 bhlHZl'])[28]"));
    }

    public void addToBasket() {
        clickElement(addToBasketBag);
    }

    public void goBasketPage() {
        wait.until(ExpectedConditions.elementToBeClickable(goToBasketFromBagPage)).click();
    }

}





