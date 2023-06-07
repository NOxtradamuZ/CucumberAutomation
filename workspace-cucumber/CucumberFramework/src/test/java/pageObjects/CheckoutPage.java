package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	// Attributes
	public By promoBtn = By.cssSelector(".promoBtn");
	public By placeOrderBtn = By.xpath("//button[contains(text(), 'Place Order')]");
	private By cartBag = By.cssSelector("img[alt='Cart']");
	private By checkOutButton = By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]");
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;		
	}
	
	public Boolean verifyPromoBtnIsDisplayed() {
		return driver.findElement(promoBtn).isDisplayed();
	}

	public Boolean verifyPlaceOrderBtnIsDisplayed() {
		return driver.findElement(placeOrderBtn).isDisplayed();
	}
	
	public void openCart() {
		driver.findElement(cartBag).click();
	}
	
	public void accessCheckout() {
		driver.findElement(checkOutButton).click();
	}
}
