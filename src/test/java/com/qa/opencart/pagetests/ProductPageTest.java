package com.qa.opencart.pagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductPageTest extends BaseTest {

	@Test(priority = 1)
	public void NavigateToProductPageTest() {
		productpage = homepage.navigateToItemPage("Macbook").NavigateToProductPage();
		String tile = productpage.getTitleofProductPage();
		Assert.assertEquals(tile, "MacBook Pro", "product page title do not match");
	}
	@Test(priority = 2)
	public void ProductPageUrlTest() {
		String url =  productpage.getUrlofProductPage();
		Assert.assertEquals(url, "https://naveenautomationlabs.com/opencart/index.php?route=product/product&product_id=45&search=Macbook","url mismatch");
		
	}
	@Test(priority = 3)
	public void AddProducttoCartTest() {
		String msg = productpage.AddProducttoCart();
		Assert.assertEquals(msg, "Success: You have added MacBook Pro to your shopping cart!×"
				+ "Success message do not match ...");
	}
	@Test(priority = 4)
	public void CheckoutTest() {
		String total = productpage.checkout();
		Assert.assertEquals(total, "1 item(s) - $2,000.00" , "Amount not matching");
	}
}
