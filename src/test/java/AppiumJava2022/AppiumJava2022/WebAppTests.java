package AppiumJava2022.AppiumJava2022;


import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeTest;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class WebAppTests {
	
	 public AndroidDriver driver=null;

	@BeforeSuite
	public void beforeTest() {
		
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			capabilities.setCapability("chromedriverExecutable", "/Users/sriramku/eclipse-workspace/AppiumJava2022/Drivers/chromedriver");
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Test // (enabled=false)
	public void search() throws InterruptedException {
		
		driver.get("https://www.google.co.in");
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Avengers");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Avengers: Endgame']")).click();
		
		driver.findElement(By.xpath("//div[text()='Avengers: Endgame']"));
		

//		driver.findElement(AppiumBy.xpath("//*[@hint='Search']")).sendKeys("Avengers");
//		driver.findElement(AppiumBy.xpath(("//*[@text='Avengers: Endgame 2019 film']"))).click();
//		driver.findElement(AppiumBy.xpath("//*[@text='Avengers: Endgame']"));
		
		
		
		
	}
	

	@AfterSuite
	public void afterTest() {
	}

}

