package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class ItemPage {
	
      Page page;
	private String  selectItemImage = "img[alt='MacBook Pro']";
	private String itemPageTitle = "div#content > h1";
	private String ItemName = "a:has-text('MacBook Pro')";
	
	
	public ItemPage(Page page) {
		this.page = page;
	}
	
	public String getUrlofItemPage() {
		String ItemPageUrl = page.url();
		System.out.println("This is URL of Item Page : " + ItemPageUrl);
		return ItemPageUrl ; 
		
	}
	
	public String getTitleofItemPage() {
		String ItemPageTitle = page.title();
		System.out.println("This is title of Item Page : " + ItemPageTitle);
		return ItemPageTitle;
		
	}
	
	public ProductPage NavigateToProductPage() {
		String itemName = page.textContent(ItemName);
		System.out.println("User selected this item : " + itemName);
		page.click(ItemName);
		return new ProductPage(page) ;
	}
	/*
	public void ChooseItem() {
		String itemName = page.textContent(ItemName);
		System.out.println("User selected this item : " + itemName);
		page.click(ItemName);
	}
	*/

}
