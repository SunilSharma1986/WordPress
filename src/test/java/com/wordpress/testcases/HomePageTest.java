package com.wordpress.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.base.BaseTest;
import com.wordpress.pages.LandingPage;
import com.wordpress.pages.LaunchPage;
import com.wordpress.pages.LoginPage;
import com.wordpress.util.TestUtil;

public class HomePageTest extends BaseTest{

	
	LaunchPage launchPage;
	LoginPage loginPage;
	Object page;
	
	
	@Test
	public void homeTest() throws Exception
	{

		test = extent.startTest("Posts Page Test for LOGIN");
		test.log(LogStatus.INFO, "Starting Login Test");
		test.log(LogStatus.INFO, "Opening Browser");
		init("chrome");
		
		launchPage=new LaunchPage(dr, test);
		
		PageFactory.initElements(dr, launchPage);
		
		loginPage = launchPage.gotoDemoSite();
		loginPage.verifyTitle("Demo Site");
		test.log(LogStatus.INFO, "Loggin In" +TestUtil.getEnv().get("username") +"*******" +TestUtil.getEnv().get("password"));
		page = loginPage.doLogin(TestUtil.getEnv().get("username"), TestUtil.getEnv().get("password"));
		
		if(page instanceof LoginPage)
		Assert.fail("login FAILED");
		else
		if(page instanceof LandingPage)
			loginPage.takeScreenShot();	
	    test.log(LogStatus.PASS, "Logging Test Passed");
		System.out.println("Successfully LoggedIn");	
			
		LandingPage landingPage=(LandingPage) page;
		
		//landingPage.getMenu().logout();
		
		//landingPage.getMenu().logout();
		
		landingPage.getMenu().logout();
		
		
		
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		if(extent!=null)
		{
			extent.endTest(test);
			extent.flush();
		}
		
		if(dr!=null)
		{
			dr.quit();
		}
	}
}
