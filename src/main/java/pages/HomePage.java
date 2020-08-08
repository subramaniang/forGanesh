package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {
	
	
	public HomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	
	
	//click logout button
	
	public LoginPage clickLogoutButton() {
		driver.findElementByClassName("decorativeSubmit").click();
		
		return new LoginPage((ChromeDriver) driver);
	}

	// click crmsfa link
	
	public MyHomePage clickCrmsfaLink() {
		driver.findElementByLinkText("CRM/SFA").click();
		
		return new MyHomePage();

	}
	
	
	public HomePage verifyHomePage() {
		try {
			Assert.assertTrue(driver.findElementByLinkText("CRM/SFA").isDisplayed());
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("the elemeent not displayed");
		}
		
		return this;
	}
	
}
