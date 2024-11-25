package com.qa.opencart.pagetests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ItemPageTest extends  BaseTest {
	/*
	@DataProvider(name = "Data")
    public Object[][] getData(){
    	return new Object[][] {
    		
    		{"Macbook"},
    		{"Samsung"}
    	
    	};
    	
    }
    */
	@Test(priority = 1)
	public void navigateToItemPageTest() {
		itempage = homepage.navigateToItemPage("MacBook");
		String tile = itempage.getTitleofItemPage();
		Assert.assertEquals(tile, "Search - MacBook","Page Title didnot match");
		
	}
	
	@Test(priority = 2)
	public void UrlofItemPageTest() {
		String urlofitempage = itempage.getUrlofItemPage();
		Assert.assertEquals(urlofitempage, "https://naveenautomationlabs.com/opencart/index.php?route=product/search&search=MacBook",
				"Expected and Actual url are not matching");
	}
	/*
	@Test(priority = 3)
	public void ChooseItemTest() {
		itempage.ChooseItem();
	}
	*/

}
