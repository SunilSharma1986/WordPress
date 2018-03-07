package com.wordpress.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.wordpress.common.TopMenu;
import com.wordpress.pages.LandingPage;
import com.wordpress.pages.LaunchPage;
import com.wordpress.pages.LoginPage;
import com.wordpress.pages.LogoutPage;
import com.wordpress.pages.PostsPage;
import com.wordpress.util.DSConstants;

public class BasePage {
	
	public WebDriver dr;
	public TopMenu menu;
	public ExtentTest test;
	public LandingPage landingPage;
	public LoginPage loginPage;
	public LaunchPage launchPage;
	public PostsPage postsPage;
	public Actions action;
	public LogoutPage logOut;
	
	
	public BasePage()
	{
		
	}
	
	public BasePage(WebDriver dr, ExtentTest test)
	{
		this.dr=dr;
		this.test=test;	    
		menu=new TopMenu(dr, test);
         PageFactory.initElements(dr, menu); 
		
		}
	
	public void verifyTitle(String expectedTitle)
	{
		test.log(LogStatus.INFO, "Verifying the title " +expectedTitle);
	}

	
	
	public void actionClass(WebElement act)
	{
		action=new Actions(dr);
		action.moveToElement(act).build().perform();
	}
	
	public boolean isElementPresent(String locator)
	{
		boolean displayed = dr.findElement(By.xpath(locator)).isDisplayed();
		if(displayed)
			return true;
			else
			return false;
		
	}
	
	
	
	public TopMenu getMenu()
	{
		return menu;
	}
	
	
	//Taking screenshot
	
	public void takeScreenShot()
	{
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=DSConstants.REPORTS_SS_PATH+screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	}
	
	
	}

