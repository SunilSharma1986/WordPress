package com.wordpress.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.base.BaseTest;
import com.wordpress.pages.LandingPage;
import com.wordpress.pages.LaunchPage;
import com.wordpress.pages.LoginPage;
import com.wordpress.pages.PostsPage;
import com.wordpress.util.TestUtil;

public class PostsPageTest extends BaseTest {
	LaunchPage launchPage;
	LandingPage landingPage;
	LoginPage loginPage;
	Object page;
	PostsPage postsPage;
	TestUtil testUtil;
	
	
	/*@Test(priority=1)
	public void postsTest()
	{
	
		test = extent.startTest("Posts Page Test for LOGIN");
		test.log(LogStatus.INFO, "Starting Login Test");
		test.log(LogStatus.INFO, "Opening Browser");
		init("chrome");
		launchPage=new LaunchPage(dr, test);
		PageFactory.initElements(dr, launchPage);
		
		loginPage = launchPage.gotoDemoSite();
		loginPage.verifyTitle("Demo Site");
		test.log(LogStatus.INFO, "Loggin In");
		page = loginPage.doLogin("admin", "demo123");
		
		if(page instanceof LoginPage)
		Assert.fail("login FAILED");
		else
		if(page instanceof LandingPage)
		System.out.println("Successfully LoggedIn");	
			
		landingPage=(LandingPage) page;
		
		//landingPage.getMenu().logout();
		
	    postsPage = landingPage.gotoPostsPage();
	    postsPage.takeScreenShot();
		postsPage.verifyPostsPage();
		
	}*/
	
	
	
	@DataProvider
	public Object[][] getDemoSiteTestData()
	{
		Object[][] data = TestUtil.getTestData("posts");
		return data;
	}
	
	
	
	
	@Test(priority=2,dataProvider="getDemoSiteTestData")
	public void addnewPostsTest(String Title,String Content) throws Exception
	{
		test = extent.startTest("Posts Page Test for Adding New Posts");
		test.log(LogStatus.INFO, "Starting Login Test");
		test.log(LogStatus.INFO, "Opening Browser");
		init("chrome");
		launchPage=new LaunchPage(dr, test);
		PageFactory.initElements(dr, launchPage);
		
		loginPage = launchPage.gotoDemoSite();
		loginPage.verifyTitle("Demo Site");
		test.log(LogStatus.INFO, "Loggin In");
		page = loginPage.doLogin("admin", "demo123");
		
		if(page instanceof LoginPage)
		Assert.fail("login FAILED");
		else
		if(page instanceof LandingPage)
		System.out.println("Successfully LoggedIn");	
			
		landingPage=(LandingPage) page;
		
		//landingPage.getMenu().logout();
		
		postsPage=new PostsPage(dr, test);
		PageFactory.initElements(dr, postsPage);
	    postsPage = landingPage.gotoPostsPage();
	    postsPage.takeScreenShot();
	    postsPage.addNewPosts(Title, Content);
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
