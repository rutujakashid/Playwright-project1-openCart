package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	
	Playwright playwright ;
	Browser browser;
	BrowserContext context;
	Page page ;
	Properties prop;
	
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();
	

	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}

	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}
	
	public Page InitBrowser(Properties prop)
	{
		String browsername = prop.getProperty("browser").trim();
		
		//playwright = Playwright.create();
		tlPlaywright.set(Playwright.create());
		
		switch (browsername.toLowerCase())
		{
		case "chromium":
			//browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
		    break;
		case "firefox":
			//browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false)));
		    break;
		case "safari":
			//browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			tlBrowser.set(getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false)));

		    break;
		case "chrome":
			//browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			getPlaywright().chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));

		    break;
		default:
			System.out.println("select correct browser");
			break;	
		}
		
	/*	context = browser.newContext();
		page = context.newPage();
		page.navigate(prop.getProperty("url"));
		return page;
		*/
		tlBrowserContext.set(getBrowser().newContext());
		tlPage.set(getBrowserContext().newPage());
		getPage().navigate(prop.getProperty("url").trim());
		return getPage();

	}
	
	public Properties InitProp() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace_new\\project1\\Resources\\config\\config.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
		
	}
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		//System.getProperty("user.dir") retrieves the current working directory of the project.
		//screenshot/ is a folder inside the project directory where screenshots are saved.
		//System.currentTimeMillis() generates a unique timestamp to ensure each screenshot has a unique filename.
		
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		//getPage().screenshot(...) takes a screenshot of the entire page. The setPath(Paths.get(path)) option specifies where the screenshot should be saved.
		//.setFullPage(true) indicates that the screenshot should capture the full length of the page, not just the visible part.
		//The screenshot is returned as a byte array (buffer), which represents the image in binary form.
		
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		//Base64.getEncoder().encodeToString(buffer) encodes the screenshot (stored in buffer) into a Base64 string.
		//This encoding is useful if you want to embed the image directly into HTML or JSON without needing a separate file.
		
		return base64Path;
	}
	
	
}
