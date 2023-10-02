
package objectManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Drivermanager {

	public AppiumDriver driver;
	
	@BeforeSuite
	public void config() throws InterruptedException, MalformedURLException
	{
		//driver.findElement(enterUserName).sendKeys(Uname);
		
		{
			DesiredCapabilities cp=new DesiredCapabilities();		
			cp.setCapability("deviceName", "OnePlus Nord CE 3 Lite 5G");
			cp.setCapability("udid", "ddf6b5f"); 
			cp.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); 
			cp.setCapability("platformVersion", "13");
			cp.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cp.setCapability("appPackage", "io.selendroid.testapp");
			cp.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
			URL url=new URL("http://127.1.1.0:4723/wd/hub");
			driver=new AppiumDriver(url,cp);
			System.out.println("Application Started....");
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
	}
}


