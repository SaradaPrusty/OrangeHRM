package com.OrangeHRM.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.OrangeHRM.pom.loginPOM;
import com.OrangeHRM.util.DriverFactory;
import com.OrangeHRM.util.DriverNames;


public class Testdemo {

	private WebDriver driver;
	private loginPOM loginPOM;
	public String inputUsername;
	
	
	public Testdemo() {
		this.driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new loginPOM(driver);
	}
	
	@BeforeMethod
	public void beforeTest() throws MalformedURLException {
		
		System.out.println("*****************  In BeforeTest *************");
		driver.get("https://orngehrmnew-trials65141.orangehrmlive.com/auth/login");	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	
	 
	  @Test
	  public void TC01() throws IOException, InterruptedException {
		  File src=new File("C:\\Users\\SaradaPrusty\\Downloads\\Readdata.xlsx");
			 FileInputStream fis=new FileInputStream(src);
			
			Workbook w = null;
			w = new XSSFWorkbook(fis);
			Sheet s = w.getSheet("Sheet1"); 
			int rownumber = s.getLastRowNum();
			//System.out.println(rownumber);
			 
			String inputUsername = s.getRow(1).getCell(0).getStringCellValue();
			String inputpassword = s.getRow(1).getCell(1).getStringCellValue();
			
			System.out.println(inputUsername);
			System.out.println(inputpassword);
		  
			loginPOM.sendUserName(inputUsername);
			loginPOM.sendPassword(inputpassword);
		    loginPOM.login();
		    loginPOM.PIM();
		    loginPOM.addEmp();
		    loginPOM.implicitWait();	    
		    loginPOM.leaveOption();
		    loginPOM.dropDown();
		    loginPOM.logout();
		    
		    
	}
	  
	  @AfterMethod
	  public void afterTest() throws InterruptedException {
	  
		  loginPOM.implicitWait();
		  	//Thread.sleep(5000, 20);
			System.out.println("*****************  In AfterTest *************");
			driver.quit();
	  }
}
