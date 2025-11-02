package base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

    public void windowHandle() throws IOException {
        //get the current window handle
        String orgwin = driver.getWindowHandle();
        //click on the link
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(orgwin)) {
                driver.switchTo().window(win);
            }
        }
    }
    public void wa(WebElement element){
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        //Explicit wait
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        //Fluent wait
        Wait<WebDriver> fluent=new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

    }
        public void screenShot() throws IOException {
            //code to take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //code to save the screenshot
            FileUtils.copyFile(src, new File("Path"));
        }
    public void ActionsClass(WebElement element){
        //code for actions class
        Actions action=new Actions(driver);

        action.moveToElement(element).perform();
        //perform right click
        action.contextClick(element).perform();
        //perform double click
        action.doubleClick(element).perform();
        //drag and drop
        action.dragAndDrop(element,element).perform();
        //click and hold
        action.clickAndHold(element).perform();
        //release
        action.release().perform();
    }
    public void selectClass(WebElement element){
        Select st=new Select(element);
        st.selectByIndex(1);
        st.selectByValue("");
        st.selectByVisibleText("");
    }

    public void keyBoard(WebElement element){
        element.sendKeys(Keys.ENTER);
        element.sendKeys(Keys.TAB);
    }
}