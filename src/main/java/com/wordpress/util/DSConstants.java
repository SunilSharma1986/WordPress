package com.wordpress.util;

public class DSConstants {
	
	
	public static final boolean GRID_RUN=false;
	public static final String ENV="PROD";

	//paths
	public static final String CHROME_DRIVER_EXE="D:/Selenium/Chrome/chromedriver.exe";
	public static final String FF_DRIVER_EXE="D:/Selenium/Chrome/chromedriver.exe";
	
	
	//text locators
	public static final String LOGIN_USERNAME="log";
	public static final String LOGIN_PWD="pwd";
	public static final String POST_TITLE_TXT="//input[@name='post_title']";
	public static final String POST_CONTENT_TXT="//textarea[@name='content']";
	
	
	
	//button locators
	public static final String LOGIN_BTN="wp-submit";
	public static final String POST_TAB="//a[contains(text(),'Posts')]";
	public static final String POST_ADD_NEW_BTN="//a[contains(text(),'Add New')]";
	public static final String POST_PUBLISH_BTN="publish";
	
	
	
	//links
	public static final String POST_HTML_LNK="//a[@id='content-html']";
	public static final String HOME_LOGO=".//div[@class='icon32']";
	public static final String PROFILE_HOVER="//a[@title='My Account']";
	public static final String LOGOUT_LINK="//a[text()='Log Out']";
	
	
	
	//PROD_ENV_DETAILS
	public static final String PROD_DS_URL="http://demosite.center/wordpress/wp-login.php";
	public static final String PROD_USERNAME="admin";
	public static final String PROD_PASSWORD="demo123";
	
	//QA_ENV_DETAILS
	public static final String QA1_DS_URL="http://demosite.center/wordpress/wp-login.php";
	public static final String QA2_DS_URL="http://demosite.center/wordpress/wp-login.php";
	public static final String QA3_DS_URL="http://demosite.center/wordpress/wp-login.php";
	
	//path
	public static final String REPORTS_PATH = "D:/Workspace/wordpress/Reports/";
	public static final String REPORTS_SS_PATH = "D:/Workspace/wordpress/Reports/Screenshots/";
	public static final String TEST_DATA_SHEET_PATH="D:/Workspace/wordpress/src/main/java/com/wordpress/testdata/DS_TestData.xlsx";
}
