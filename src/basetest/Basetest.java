package basetest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import factory.SiteFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basetest {
	protected static AppiumDriver driver;
	protected static SiteFactory factory;
	
	public Basetest() {}
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("deviceName", "OnePlus 7T");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("fullReset", "true");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("newCommandTimeout", 120);
		
		capabilities.setCapability("appPackage", "com.yara.lcc.qa"); 
		capabilities.setCapability("appActivity", "com.yara.lcc.MainActivity");
		capabilities.setCapability("appWaitActivity", "com.yara.lcc.MainActivity");
		capabilities.setCapability("app", System.getProperty("user.dir")+"/app-qa-universal-release.apk");
		
		URL serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
        this.driver = new AndroidDriver<AndroidElement>(serverAddress, capabilities);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		factory=new SiteFactory(driver);	
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	@AfterClass
	public void teardown(){ 
	    this.driver.quit(); 
	} 
	
	public static int getRandomValue(int upperband) {
		Random random=new Random();
		return random.nextInt(upperband);
	}
	
	public  static void log(String message) {
			System.out.println(message);
			Reporter.log(message);
	}

}
