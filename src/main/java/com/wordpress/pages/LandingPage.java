package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.base.BasePage;
import com.wordpress.util.DSConstants;

public class LandingPage extends BasePage{

	
	
	@FindBy(xpath=DSConstants.POST_TAB)
	WebElement postsTab;
	
	public LandingPage(WebDriver dr, ExtentTest test)
	{
		super(dr, test);
	}
	
	
	
	public PostsPage gotoPostsPage()
	{
		test.log(LogStatus.INFO, "Clicking on Posts Tab " +postsTab);
		postsTab.click();
		
		postsPage=new PostsPage(dr, test);
		
		PageFactory.initElements(dr, postsPage);
		
		return postsPage;
	}
	
	
		
}
