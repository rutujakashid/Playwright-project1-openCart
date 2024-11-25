package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	protected Page page;
	protected String username = "//input[@id='input-email']";
	private String password = "input#input-password";
	private String loginButton = "//input[@value='Login']";
	private String AfterLoginText = "//div[@id='content']/h2[.='My Account']";
	private String caret = "span.caret";
	private String logoutbtn = "a:has-text('Logout')";
	private String Warning = "div#account-login > .alert.alert-danger.alert-dismissible";
	
	public LoginPage(Page page) {
		this.page = page;
	}
	
	public String getPageTitle() {
		String title = page.title();
		System.out.println(title);
		return title;
	}
	
	public String getPageUrl() {
		String url = page.url();
		System.out.println(url);
		return url;
	}
	
	public boolean userNameVisible() {
		return page.isVisible(password);
	}
	
	
		
	
	
	public String doLogin(String user, String pass) throws InterruptedException {
		page.fill(username, user);		
		page.fill(password, pass);
		page.click(loginButton);
		System.out.println("Logged in By user : " + user);
		if (page.isVisible(Warning)) {
	    	String errortext = page.textContent(Warning);
	    	System.out.println(errortext);
	        return errortext ;
	    } else {
	    	
	        return "Warning message is not visible";
	    }
		//Thread.sleep(300);
		//String afterlogintitle = page.textContent(AfterLoginText);
		//System.out.println(afterlogintitle);
		//return afterlogintitle;
	}
	
	public boolean WarningMsgVisible() {
		//page.waitForSelector(Warning, new Page.WaitForSelectorOptions().setTimeout(10000));
		return page.isVisible(Warning);
	}
	
	
	/*public String doLogout() {
		page.click(caret);
		page.click(logoutbtn);
		String text = page.textContent("div#content h1");
        System.out.println(text);
        return text;
	}
	*/
	

}

