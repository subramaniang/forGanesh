package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {

	public LoginPage(RemoteWebDriver driver) {
		this.driver = driver;
	}

	// enter username

	public LoginPage enterUsername(String data) throws InterruptedException {
		Thread.sleep(4000);
		driver.findElementById("username").sendKeys(data);
		Thread.sleep(4000);
		return this;

	}

	// enter password

	public LoginPage enterPassword(String data) {
		driver.findElementById("password").sendKeys(data);

		return this;
	}

	// click login

	public HomePage clickLoginButton() {
		driver.findElementByClassName("decorativeSubmit").click();

		// HomePage hp = new HomePage();

		return new HomePage(driver);

	}

}
