package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginLogout extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setData() {
		fileName = "TC001";

	}
	
	
	@Test(dataProvider="fetchData")
	public void runLoginLogout(String username,String password) throws InterruptedException {
		
		 // LoginPage lp = new LoginPage();
		
		new LoginPage((ChromeDriver) driver)
		.enterUsername(username)
		.enterPassword(password)
		.clickLoginButton()
		.clickLogoutButton();
		

	}
	

}
