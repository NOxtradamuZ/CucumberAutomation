package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetUp {
	
	// Attributes 
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public WebDriver driver;
	public TestBase base;
	public GenericUtils genericUtils;
	
	public TestContextSetUp() throws IOException {
		/** Instantiate the browser */
		base = new TestBase();
		/** Gets the driver and send to the page objects */
		pageObjectManager = new PageObjectManager(base.webDriverManager());
		genericUtils = new GenericUtils(base.webDriverManager());
	}

}
