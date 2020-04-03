package com.webappsecurity.zero.TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.LoginError;

public class VerifyInvalidLoginTest {
	WebDriver driver;
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
	@Test
	public void verifyInvalidLogin() {
		Login lp = new Login(driver);
		LoginError le =new LoginError(driver);
		lp.applicationLogin("","");
	String actualMessage = le.getErrorMsg();
	String expectedMessage = "Login and/or password are wrong.";
	
	Assert.assertEquals(actualMessage, expectedMessage);
	}
	@AfterTest
	public void closeApplication() {
		 driver.close();
	}

}
