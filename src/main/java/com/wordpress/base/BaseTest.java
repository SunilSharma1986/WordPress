package com.wordpress.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.wordpress.util.DSConstants;
import com.wordpress.util.ExtentManager;

public class BaseTest {
	public ExtentReports extent=ExtentManager.getInstance();
	public ExtentTest test;
	public WebDriver dr;
	public DesiredCapabilities cap;
	
	public void init(String bType) throws MalformedURLException
	{
		if(!DSConstants.GRID_RUN)
		{
			if(bType.equalsIgnoreCase("Mozilla"))
		{
			System.setProperty("webdriver.gecko.driver",DSConstants.FF_DRIVER_EXE);
			dr=new FirefoxDriver();
		}
		else if(bType.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",DSConstants.CHROME_DRIVER_EXE);
			dr=new ChromeDriver();
		}
		}
		
		else
		{
			if(bType.equalsIgnoreCase("chrome"))
			{
			cap=new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			
			ChromeOptions options=new ChromeOptions();
			options.merge(cap);
			String hubURL="http://192.168.0.101:4444/wd/hub";
			dr=new RemoteWebDriver(new URL(hubURL), options);
			}
			else
				if(bType.equalsIgnoreCase("Mozilla"))
				{
					System.out.println("Running on Remote Mozilla");
				}
		}
		
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
