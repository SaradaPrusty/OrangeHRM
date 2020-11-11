package com.OrangeHRM.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class loginPOM {

	private WebDriver driver;
	
	//I faced error in adding a new employee because of exceed in add limit.
	
	public loginPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "txtUsername")
	private WebElement Username;
	
	@FindBy(id = "txtPassword")
	private WebElement Password;
	
	@FindBy(id = "btnLogin")
	private WebElement login; 
	
	@FindBy(id = "menu_pim_viewPimModule")
	private WebElement PIM;
	
	@FindBy(id = "menu_leave_viewLeaveModule")
	private WebElement addEmp;
	
	
	public void implicitWait() throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 driver.manage().wait(1000, 1000);;
	}
	
	public void sendUserName(String userName) {
		this.Username.clear(); 
		this.Username.sendKeys(userName);
	}
	
	public void sendPassword(String Password) {
		this.Password.clear(); 
		this.Password.sendKeys(Password);
	}
	
	public void login() {
		this.login.click();
	}
	
	public void PIM() {
		this.PIM.click();
	}
	
	public void addEmp() {
		this.addEmp.click();
	}
	
	public void leaveOption() {
		WebElement leaveOption= driver.findElement(By.xpath("//*[@id=\"menu_leave_viewLeaveModule\"]/a"));
		leaveOption.click();
	}
	
	public void dropDown() {
    WebElement leaveList = driver.findElement(By.xpath("//span[contains(text(),'Leave List')]"));
    leaveList.click();
	WebElement DropDown = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/input[1]"));  
    Select dropdown = new Select(DropDown);  
    dropdown.selectByIndex(1);  
    driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	}
	
	public void logout() {
	    
		WebElement DropDown1 = driver.findElement(By.xpath("//a[@id='user-dropdown']"));  
	    Select dropdown1 = new Select(DropDown1);  
	    dropdown1.selectByVisibleText("Logout");  
	   
		}
	
	
	
}
