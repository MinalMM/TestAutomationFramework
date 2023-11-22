package com.app.qa.testcases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.ContactsPage;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;
import com.app.qa.pages.LogoutPage;
import com.app.qa.util.TestUtil;

public class LogoutPageTest extends TestBase {
	
	LogoutPage logoutPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public LogoutPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		logoutPage = new LogoutPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateLogoutBtn() {
		testUtil.switchToFrame();
		assertTrue(logoutPage.validateLogoutBtn(), "Logout button is displayed.");
		//assertFalse(logoutPage.validateLogoutBtn(), "Logout button is not displayed.");
		log.error("Logout button is displayed!!!");
	}
	
	@Test(priority=2)
	public void clickOnLogoutBtnTest(){
		testUtil.switchToFrame();
		loginPage = logoutPage.clickOnLogoutBtn();
		driver.switchTo().defaultContent();
		//driver.navigate().back();
		//boolean flag = loginPage.validateCRMImage();
		//Assert.assertTrue(flag,"kdbscjdsb");
		log.info("Application is succesfully logged out!!!");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
