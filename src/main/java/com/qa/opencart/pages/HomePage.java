package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;
	
	//create private loactors 
	
	private String searchBox = ".form-control";
	private String searchIcon = ".btn-default";
	private String myAccountTab = "a[title='My Account']";
	private String loginBtn = "a:has-text('Login')";
	
	//create constructor
	public HomePage(Page page) {
		this.page = page;
	}
	
	//create methods doing diff. actions on the page
	
	
	public String getHomePageTitle() {
		String homepagetitle = page.title();
		System.out.println(homepagetitle);
		return homepagetitle;
	}
	
	/*public String  SearchItem(String item) {
		page.fill(searchBox, item);
		page.click(searchIcon);
		String itempage = page.textContent(itemPageTitle);
		return itempage;
		
		
	}
	*/
	public ItemPage navigateToItemPage(String item) {
		page.fill(searchBox, item);
		page.click(searchIcon);
		return new ItemPage(page);
	}
	
	//method for performing page chaining ..From Homepage we will go to LoginPage 
	public LoginPage navigateToLoginPage() {
		page.click(myAccountTab);
		page.click(loginBtn);
		
		return new LoginPage(page);
		
	}
	

}
