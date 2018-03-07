package com.wordpress.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wordpress.base.BasePage;

public class LogoutPage extends BasePage{
	
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	WebElement logOut_link;
	
	
	

	
}
