package com.qa.opencart.pagetests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	
	   @Test(priority = 1)
	   public void NavigateToLoginPageTest() {
		  loginpage =  homepage.navigateToLoginPage();
		  String loginPageTitle = loginpage.getPageTitle();
		  Assert.assertEquals(loginPageTitle, "Account Login");
		   
	   }
	
	/*
	    @Test(priority = 1)
		public void PageTitleTest() {
			String title = loginpage.getPageTitle();
			Assert.assertEquals(title, "Account Login");
		}
		*/
	    
	    @Test(priority = 2)
	    public void PageUrlTest() {
	    	String url = loginpage.getPageUrl();
	    	Assert.assertEquals(url, "https://naveenautomationlabs.com/opencart/index.php?route=account/login","URL mismatch - Not on login page");
	    	Assert.assertTrue(loginpage.userNameVisible(), "Username field is not visible");
	    }
	    
	   /* @DataProvider(name = "LoginData")
	    public Object[][] getData(){
	    	Object[][] data = new Object[2][2];
	    	//dataset1 
	    	data[0][0]="aditi@gmail.com";
	    	data[0][1]="Rutuja@123";
	    	
	    	//data[1][0]="riya@gmail.com";
	    	//data[1][1]="Rutuja@123";
	    	
	    	return data;
	    			
	    	
	    }
	    */
	    
	    @Test(priority = 3)
	    public void LoginTest() throws InterruptedException {
	    	/*
	    	//String actualHeader = loginpage.doLogin("aditi@gmail.co","Rutuja@123");
	    	loginpage.doLogin(" "," ");
	    	Assert.assertTrue(loginpage. WarningMsgVisible(), "Error message not visible on invalid login");
	    	String errormsg = loginpage.getWarningMessageText();
	    	Assert.assertEquals(errormsg, " Warning: No match for E-Mail Address and/or Password.");
	    	//Assert.assertEquals(actualHeader, "My Account");
	    	// loginpage.doLogout();
	    	 * */
	    	
	    	 // Attempt login with invalid credentials
	        loginpage.doLogin("aditi@gmail.com", "Rutuja@123");
	        // Check if warning message is visible
	        Assert.assertTrue(loginpage.WarningMsgVisible(), "Error message not visible on invalid login");

	      /*  // Explicitly wait for the warning message to be present
	       // page.waitForSelector(".fa.fa-exclamation-circle"); // Adjust locator as per your UI
	        //loginpag+e.WarningMsgVisible();

	       

	        // Get and validate the error message text
	        String actualErrorMessage = loginpage.getWarningMessageText();
	        String expectedErrorMessage = "Warning: No match for E-Mail Address and/or Password.";
	        Assert.assertEquals(actualErrorMessage.trim(), expectedErrorMessage.trim(), "Error message text mismatch");
	        */
	    	
	    }
	    
	    
		
	
}
