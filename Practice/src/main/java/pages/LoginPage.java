package pages;

import base.basePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends basePage {

    @FindBy(id="username")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-btn")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void login(String UserName, String Password){
        userName.sendKeys("User");
        password.sendKeys("password");
        loginBtn.click();
    }
}
