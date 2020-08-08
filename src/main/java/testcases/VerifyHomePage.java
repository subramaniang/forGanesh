package testcases;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class VerifyHomePage extends ProjectSpecificMethods {
	

	@BeforeTest
	public void setData() {
		
		//fileName = "TC002";

	}
	
	
	@Test(threadPoolSize = 1, invocationCount = 1/*dataProvider="fetchData"*/)
	public void runVerification(/*String username,String password*/) throws InterruptedException, IOException {
		
		/*new LoginPage((ChromeDriver) driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.verifyHomePage();*/
		

		

	}

}
