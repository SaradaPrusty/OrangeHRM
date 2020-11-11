package com.OrangeHRM.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

	private WebDriver driver;
	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}

	public void clickWhenReady(By locator, int maxTimeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, maxTimeOut);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public WebElement waitForElement(By locator, int maxTimeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, maxTimeOut);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return null; 
	}

}
