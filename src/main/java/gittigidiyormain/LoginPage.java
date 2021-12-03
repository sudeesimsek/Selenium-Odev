package gittigidiyormain;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class LoginPage extends BasePage {

    protected By emailTextBox = By.id("L-UserNameField");
    protected By passwordTextBox = By.id("L-PasswordField");
    protected By btnLoginButton = By.id("gg-login-enter");

    public LoginPage(WebDriver driver) {
        super(driver);

    }


    public void setEmailAndPassword(String email, String password) {
        setText(emailTextBox, email);
        setText(passwordTextBox, password);

    }

    public void clickLogin() {
        Actions action = new Actions(driver);
        clickElement(btnLoginButton);
    }


}
