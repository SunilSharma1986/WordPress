package com.wordpress.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.util.DSConstants;

public class TopMenu {

	public WebDriver dr;	
	public ExtentTest test;
	
	
	
	@FindBy(xpath=DSConstants.PROFILE_HOVER)
	WebElement profile_link;
	
	@FindBy(xpath=DSConstants.LOGOUT_LINK)
	WebElement logOut_link;
	

	
	
	public TopMenu(WebDriver dr,ExtentTest test)
	{
		this.dr=dr;
		this.test=test;
		
	}
	
	
	public void logout() throws Exception
	{
		
	// test.log(LogStatus.INFO, "Performing LOGOUT");
	 //actionClass(profile_link);
		
		test.log(LogStatus.INFO, "Performing hover actions");
		Actions act=new Actions(dr);
		act.moveToElement(profile_link).build().perform();
		test.log(LogStatus.INFO, "Clicking on LogOut Button");
	    Thread.sleep(1000);
	    
	    logOut_link.click();
	    test.log(LogStatus.INFO, "Successfully clicked on LogOut Button");
	 
	}
}
