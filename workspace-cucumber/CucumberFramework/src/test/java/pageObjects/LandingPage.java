package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	// Attributes - Locators
	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.linkText("Top Deals");
	private By incrementItem = By.cssSelector("a.increment");
	private By addItem = By.cssSelector(".product-action button");
			
	private WebDriver driver;
	
	// Constructor
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// Methods - Action methods
	public String getTitleLandingsPage() {
		return driver.getTitle();
	}
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText() {
		driver.findElement(search).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void incrementItem(Integer quantity) {
		for(int i=1; i<quantity; i++) {
			driver.findElement(incrementItem).click();
		}
	}
	
	public void addItemToCart() {
		driver.findElement(addItem).click();
	}
	
	public void selectTopDeals() {
		driver.findElement(topDeals).click();
	}
	

}