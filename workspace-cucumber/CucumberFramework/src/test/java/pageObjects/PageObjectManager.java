package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	// Attributes
	/** Page */
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	
	/** Utils */
	public WebDriver driver;
	
	// Constructor
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	// Methods to get the pages instantiated
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckoutPage getCheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

}
