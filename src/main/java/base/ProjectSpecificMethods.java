package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import pages.LoginPage;
import utils.ReadExcel;

public class ProjectSpecificMethods {
	
	public static RemoteWebDriver driver;
	
	public String fileName;
	public String url = "http://leaftaps.com/opentaps/control/main";
	//@Parameters("url")
	@BeforeMethod
	public void startApp(/*String url*/) throws MalformedURLException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		/*driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get(url);*/
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		
				
		try {
			RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
			driver.get(url);
			String title = driver.getTitle();
			System.out.println(title+" title");
			
			new LoginPage(driver)
			.enterUsername("Demosalesmanager")
			.enterPassword("crmsfa")
			.clickLoginButton()
			.verifyHomePage();
			takeSnap();
			driver.quit();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}
	
	@AfterMethod
	public void closeBrowser() {
		System.out.println("before driver close");
		try {
			driver.quit();
			//System.out.println("Title "+driver.getTitle());
			//driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}

	}
	
	public void takeSnap() throws IOException{
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("./screenshot/screenshot"+System.currentTimeMillis()+".png"));
	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		
		return ReadExcel.readData(fileName);

	}
	

}
