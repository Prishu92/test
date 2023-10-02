package TestExecution;

import org.testng.annotations.Test;

import Objects.HomeScreen;
import objectManager.Drivermanager;

public class TestCase extends Drivermanager{
	HomeScreen hobj=new HomeScreen();
	@Test
	public void UserReg() throws InterruptedException
	{
		hobj.clickShowProgressBar(driver);
		
		hobj.reg(driver);
		
		hobj.verifyRegData(driver);
	}

}
