package gittigidiyortest;

import gittigidiyormain.BasketPage;
import gittigidiyormain.HomePage;
import gittigidiyormain.LoginPage;
import gittigidiyormain.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RunTest extends BaseTest {


    String _email = "graceeaudrey@gmail.com";
    String _password = "Avrilmaster1";
    String _productName = "Bilgisayar";
    String _productName2 = "Çanta";

    @Test
    @Order(1)
    public void homePageLogin() throws InterruptedException {
        basketPage.assertCont("https://www.gittigidiyor.com/");
        System.out.println("login successfully");
        homePage.firstLogin();
        Thread.sleep(3000);
        homePage.secondLogin();
        Thread.sleep(3000);
    }

    @Test
    @Order(2)
    public void login() {
        loginPage.setEmailAndPassword(_email, _password);
        loginPage.clickLogin();

    }

    @Test
    @Order(3)
    public void findProduct() throws InterruptedException {
        homePage.typeProductNameOnSearchArea(_productName);
        productsPage.verticalScrollDown(10000);
        Thread.sleep(3000);
    }

    @Test
    @Order(4)
    public void selectRandomProduct() throws InterruptedException {
        productsPage.randomClick();
    }

    @Test
    @Order(5)
    public void backToHomePage() {
        homePage.backHomePage();
    }

    @Test
    @Order(6)
    public void findProduct2() throws InterruptedException {
        homePage.typeProductNameOnSearchArea2(_productName2);
        Thread.sleep(3000);
        productsPage.selectProductOnProductsPage();
        Thread.sleep(3000);
    }

    @Test
    @Order(7)
    public void goBasket() throws InterruptedException {
        productsPage.addToBasket();
        Thread.sleep(3000);
        productsPage.goBasketPage();
        Thread.sleep(3000);
    }

    @Test
    @Order(8)
    public void checkOut() throws InterruptedException {
        basketPage.clickCount();
        Thread.sleep(3000);
        basketPage.increaseCount();
        Thread.sleep(3000);
        basketPage.finishShopping();
        Thread.sleep(3000);
    }

    @Test
    @Order(9)
    public void adress() throws InterruptedException {
        basketPage.saveAdress();
        Thread.sleep(3000);
        basketPage.getAdressText();
        Thread.sleep(3000);
    }

    @Test
    @Order(10)
    public void organizeBasket() throws InterruptedException {
        basketPage.organizeBasket();
        Thread.sleep(3000);
    }

    @Test
    @Order(11)
    public void favoriteProducts() throws InterruptedException {

        basketPage.addToBasketSecondProduct();
        Thread.sleep(3000);
        basketPage.removeThirdProductFromFavorites();
        Thread.sleep(3000);
    }

    @Test
    @Order(12)
    public void logOut() throws InterruptedException {
        basketPage.newTab();
        Thread.sleep(3000);
        basketPage.logOutFromSite();
        Thread.sleep(3000);
        basketPage.closePages();
    }
}

