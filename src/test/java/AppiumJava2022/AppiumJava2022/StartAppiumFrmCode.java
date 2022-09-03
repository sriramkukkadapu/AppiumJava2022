package AppiumJava2022.AppiumJava2022;


import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.testng.annotations.BeforeTest;

import java.io.File;
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


/* ============== For this Run configurations set ANDROID_HOME variable ============== */

public class StartAppiumFrmCode {
	
	 public AndroidDriver driver=null;
	 private AppiumDriverLocalService service;	 

	 @BeforeSuite
	 public void setup() {
	        try {
	            service = new AppiumServiceBuilder()
	                    .usingPort(4725)
	                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
	                    .build();
	            service.start();

	            if (service == null || !service.isRunning()) {
	                throw new RuntimeException("An appium server node is not started!");
	            } else {
	                UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
	                        .autoGrantPermissions()
	                        .setNewCommandTimeout(Duration.ofMillis(20000))
	                        .setAdbExecTimeout(Duration.ofMillis(20000))
	                        .setDeviceName("Nexus 6 API 29")
	                        .setApp(System.getProperty("user.dir") + "/Apps/VodQA.apk");
	                driver = new AndroidDriver(new URL("http://127.0.0.1:4725"), uiAutomator2Options);
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

/*	@BeforeSuite
	public void beforeTest() {
		
		try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("appium:newCommandTimeout", 900000);
            capabilities.setCapability("appium:adbExecTimeout", 70000);
            capabilities.setCapability("appium:deviceName", "Nexus 6 API 29");
            capabilities.setCapability("appium:noReset", false);
            capabilities.setCapability("appium:fullReset", true);
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("appium:autoGrantPermissions", true);
            //capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/Apps/TheApp-v1.10.0.apk");
            capabilities.setCapability("appium:app", "https://github.com/cloudgrey-io/the-app/releases/download/v1.10.0/TheApp-v1.10.0.apk");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
*/	

	@Test // (enabled=false)
	public void login() {
		driver.startActivity(new Activity("io.cloudgrey.the_app", "io.cloudgrey.the_app.MainActivity"));
		driver.findElement(AppiumBy.xpath("//*[@text=\"Login Screen\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("username")).sendKeys("admin");
		driver.findElement(AppiumBy.accessibilityId("password")).sendKeys("admin");
		driver.findElement(AppiumBy.accessibilityId("loginBtn")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.accept();	
		
	}
	
	@Test // (enabled=false)
	public void clipBoard() {
		driver.startActivity(new Activity("io.cloudgrey.the_app", "io.cloudgrey.the_app.MainActivity"));
		driver.findElement(AppiumBy.xpath("//*[@text=\"Clipboard Demo\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("messageInput")).sendKeys("Clipboard testing");
		driver.findElement(AppiumBy.xpath("//*[@text='Set Clipboard Text']")).click();
		driver.findElement(AppiumBy.xpath("//*[@text='Refresh Clipboard Text']")).click();
		
		WebElement element = driver.findElement(AppiumBy.accessibilityId("Clipboard testing"));
		String actual = element.getText();
		Assert.assertEquals(actual, "Clipboard testing");
		
	}
	
	
	@Test // (enabled=false)
	public void picker() {
		driver.startActivity(new Activity("io.cloudgrey.the_app", "io.cloudgrey.the_app.MainActivity"));
		driver.findElement(AppiumBy.accessibilityId("Picker Demo")).click();
		
		driver.findElement(AppiumBy.accessibilityId("monthPicker")).click();
		driver.findElement(AppiumBy.xpath("//*[@text='December']")).click();
		
		driver.findElement(AppiumBy.accessibilityId("dayPicker")).click();
		driver.findElement(AppiumBy.xpath("//*[@text='1']")).click();
		
		driver.findElement(AppiumBy.xpath("//*[@text='Learn More']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
	}
	
	

	@AfterSuite
	public void afterTest() {
		
		if(service!=null)
			service.stop();
		
		if(driver!=null)
			driver.quit();
	}
	

}

