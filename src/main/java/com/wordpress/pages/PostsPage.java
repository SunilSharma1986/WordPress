package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.base.BasePage;
import com.wordpress.util.DSConstants;

public class PostsPage extends BasePage {

	
	@FindBy(xpath=DSConstants.POST_ADD_NEW_BTN)
	WebElement addNewPost_Btn;
	
	@FindBy(xpath=DSConstants.POST_TITLE_TXT)
	WebElement postTitle_txt;

	
	@FindBy(xpath=DSConstants.POST_HTML_LNK)
	WebElement postHtml_lnk;
	
	
	@FindBy(xpath=DSConstants.POST_CONTENT_TXT)
	WebElement postContent_txt;
	
	
	@FindBy(name=DSConstants.POST_PUBLISH_BTN)
	WebElement postPublish_Btn;
	
	
	@FindBy(xpath="//*[@id='message']//p")
	WebElement postPublishedMsg;
	
	
	public PostsPage(WebDriver dr, ExtentTest test)
	{
		super(dr, test);
	}
	
	public void verifyPostsPage()
	{
		
	}
	
	
	
	public void addNewPosts(String title, String content) throws Exception
	{
		test.log(LogStatus.INFO, "Adding New Post ");
		addNewPost_Btn.click();
		test.log(LogStatus.INFO, "Clicked on Add New Post Button");
		postTitle_txt.sendKeys(title);
		test.log(LogStatus.INFO, "Adding the Title of the Post");
		
		postHtml_lnk.click();
		test.log(LogStatus.INFO, "Clicked on HTML Link");
		Thread.sleep(2000);
		postContent_txt.sendKeys(content);
		test.log(LogStatus.INFO, "Entered the content");
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Click on Publish Button");
		postPublish_Btn.click();
		
		String actualMsg = postPublishedMsg.getText();
		System.out.println("Post published Msg Validation  " +actualMsg);
		if(actualMsg.contains("Post"))
		{
			takeScreenShot();
			test.log(LogStatus.PASS, "Post published Successfully" +actualMsg);
		}
		else
			takeScreenShot();
			test.log(LogStatus.FAIL, "Adding New Post Failed" +actualMsg);
		   
	}
	
}
