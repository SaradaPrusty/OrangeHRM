package com.OrangeHRM.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static WebDriver getDriver(DriverNames driverName) {
		WebDriver driver= null;
		
		if(driverName.equals(DriverNames.CHROME)) {
			System.setProperty(Driver.CHROME_KEY, Driver.CHROME_PATH);
			driver = new ChromeDriver();
			
		}
		
		else if(driverName.equals(DriverNames.FIREFOX)) {
			System.setProperty(Driver.FIREFOX_KEY, Driver.FIREFOX_PATH);
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}

}
