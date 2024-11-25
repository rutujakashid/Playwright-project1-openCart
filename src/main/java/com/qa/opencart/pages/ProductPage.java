package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class ProductPage {
	protected Page page;
	
	private String addToCartBtn = "button#button-cart";
	private String successMsg = ".alert-dismissible";
	private String cartTotal = "span#cart-total";
	private String checkout = "a:has-text('Checkout')";
	
	public ProductPage(Page page) {
		this.page = page;
	}
	
	public String getUrlofProductPage() {
		String url = page.url();
		System.out.println(url);
		return url;
		
	}
	public String getTitleofProductPage() {
		String ProductPageTitle = page.title();
		System.out.println("This is title of Product Page : " + ProductPageTitle);
		return ProductPageTitle;
		
	}
	public String AddProducttoCart() {
		page.click(addToCartBtn);
		String msg = page.textContent(successMsg);
		System.out.println(msg);
		return msg;
	}
	
	public String checkout() {
		String totalAmount = page.textContent(cartTotal);
		System.out.println(totalAmount);
		page.click(cartTotal);
		page.click(checkout);
		return totalAmount;
	}

}
