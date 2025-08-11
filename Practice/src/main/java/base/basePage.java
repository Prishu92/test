package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static io.restassured.RestAssured.*;
public class basePage {
    protected WebDriver driver;

    public basePage(WebDriver driver) {
        this.driver = driver;
        baseURI="https://reqres.in/api";
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String url){
        driver.get(url);
    }
}
