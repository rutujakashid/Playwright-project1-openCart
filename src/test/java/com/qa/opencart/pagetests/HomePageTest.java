package com.qa.opencart.pagetests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class HomePageTest extends BaseTest {
	
	@Test
	public void HomePageTitleTest() {
	String hometitle = 	homepage.getHomePageTitle();
	Assert.assertEquals(hometitle, "Your Store");	
	
	}
	
	@DataProvider(name = "Data")
    public Object[][] getData(){
    	return new Object[][] {
    		
    		{"Macbook"},
    		{"Samsung"}
    	
    	};
    	
    }
	
	/*@Test(dataProvider = "Data")
	public void SearchItemTest(String data) {
		String itemTitle = homepage.SearchItem(data);
		Assert.assertEquals(itemTitle, "Search - " + data);
		
	}
	*/
	
	
	

}
