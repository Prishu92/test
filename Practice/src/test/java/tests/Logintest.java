package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;
public class Logintest {
    @BeforeMethod
    public void setup(){
        DriverFactory.initDriver("chrome");
    }

    @Test
    public void testlogin(){
        LoginPage login=new LoginPage(DriverFactory.getDriver());
        login.navigateTo("https://example.com/login");
        login.login("admin","admin123");

    }
    @AfterMethod
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
