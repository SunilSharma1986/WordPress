package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.base.BasePage;
import com.wordpress.util.TestUtil;

public class LaunchPage extends BasePage {


	LoginPage loginPage;
	
	public LaunchPage(WebDriver dr, ExtentTest test)
	{
		super(dr, test);
		
		
	}
	
	public LoginPage gotoDemoSite()
	{
		
     	test.log(LogStatus.INFO, "Opening the URL - " +TestUtil.getEnv().get("url"));
		dr.get(TestUtil.getEnv().get("url"));
		dr.manage().window().maximize();
		loginPage=new LoginPage(dr, test);
		PageFactory.initElements(dr, loginPage);
		return loginPage;
		
	}
}
