package Objects;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class HomeScreen {

	String Name="Test";
	String Uname="UTest";
	String email="test@gm.com";
	String password="test";
	String proLang;
	boolean term;

	public void clickShowProgressBar(AppiumDriver driver) throws InterruptedException
	{
		try
		{
			driver.findElement(By.id("io.selendroid.testapp:id/waitingButtonTest")).click();
			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.id("android:id/message")).isDisplayed(),"Waiting Dialog is displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void reg(AppiumDriver driver)
	{
		try {
			driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys(Uname);

			driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys(email);

			driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys(password);

			driver.findElement(By.id("io.selendroid.testapp:id/inputName")).clear();

			driver.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys(Name);

			driver.findElement(By.id("io.selendroid.testapp:id/input_preferedProgrammingLanguage")).click();
			
			proLang=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[6]")).getText();

			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ListView/android.widget.CheckedTextView[6]")).click();

			driver.navigate().back();

			driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).click();
			
			term=driver.findElement(By.id("io.selendroid.testapp:id/input_adds")).isDisplayed();
			
			//Click Register user
			driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public void verifyRegData(AppiumDriver driver)
	{
		try
		{

			Assert.assertEquals(driver.findElement(By.id("io.selendroid.testapp:id/label_name_data")).getText(), Name);

			Assert.assertEquals(driver.findElement(By.id("io.selendroid.testapp:id/label_username_data")).getText(),Uname);

			Assert.assertEquals(driver.findElement(By.id("io.selendroid.testapp:id/label_password_data")).getText(), password);

			Assert.assertEquals(driver.findElement(By.id("io.selendroid.testapp:id/label_email_data")).getText(), email);

			Assert.assertEquals(driver.findElement(By.id("io.selendroid.testapp:id/label_preferedProgrammingLanguage_data")).getText(), proLang);

			Assert.assertEquals(true, term);	

			driver.findElement(By.id("io.selendroid.testapp:id/buttonRegisterUser")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}