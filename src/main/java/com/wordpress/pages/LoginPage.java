package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.base.BasePage;
import com.wordpress.util.DSConstants;

public class LoginPage extends BasePage{
	
	
	
	@FindBy(name=DSConstants.LOGIN_USERNAME)
	WebElement username;
	
	

	@FindBy(name=DSConstants.LOGIN_PWD)
	WebElement password;
	
	
	@FindBy(name=DSConstants.LOGIN_BTN)
	WebElement loginBtn;
	
	
	public LoginPage(WebDriver dr, ExtentTest test)
	{
		super(dr, test);
		
	}
	
	
	public Object doLogin(String UN,String PWD)
	{
		
		username.sendKeys(UN);
		test.log(LogStatus.INFO, "Entered the username - "+UN);
		password.sendKeys(PWD);
		test.log(LogStatus.INFO, "Entered the password - "+PWD);
		loginBtn.click();
		test.log(LogStatus.INFO, "Clicked on login button - "+loginBtn);
		//boolean loginSucess=true;
		if(isElementPresent(DSConstants.HOME_LOGO))
		{
			landingPage=new LandingPage(dr, test);
			PageFactory.initElements(dr, landingPage);
			return landingPage;
		}
		else
		{
			loginPage=new LoginPage(dr, test);
			PageFactory.initElements(dr, loginPage);
			return loginPage;
		}
	}
	
	
	public void verifyTitle(String expectedTitle)
	{
		
	}
}
