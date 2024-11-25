package com.qa.opencart.base;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.ItemPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductPage;

public class BaseTest {
	PlaywrightFactory pf;
	protected Page page;
	protected HomePage homepage;
	protected LoginPage loginpage;
	protected ItemPage itempage;
	protected ProductPage productpage;
	Properties prop;
	
	@BeforeTest
	public void startBrowser() throws IOException {
		pf = new PlaywrightFactory();
		prop = pf.InitProp();
		page = pf.InitBrowser(prop);
		//loginpage = new LoginPage(page); 
		homepage = new HomePage(page);
		//productpage = new ProductPage(page);
		//itempage = new ItemPage(page);
	}
	
	@AfterTest
	public void exitBrowser() {
		page.context().browser().close();
	}
	
}
