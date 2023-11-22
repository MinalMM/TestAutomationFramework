package com.app.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.qa.base.TestBase;
import com.app.qa.pages.HomePage;
import com.app.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(AllureReportListener.class)
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public static Logger log= LogManager.getLogger(LoginPageTest.class);
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		log.info("Initialization completed!!!");
	}
	
	@Test(priority=1, description = "Verifying login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test case description: Verifying the title on login page")
	@Story("Story Name: To check login page title")
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "123Free CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2, description = "Verifying application logo test" )
	@Description("Test Case Description: Verify the application logo on the login page")
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Verify login into application with correct credentials")
	@Story("Story: Verify the login step")
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("Quitting the driver");
	}
}
	