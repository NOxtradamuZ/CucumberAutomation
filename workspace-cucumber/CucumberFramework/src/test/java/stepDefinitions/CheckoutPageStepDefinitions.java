package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetUp;

public class CheckoutPageStepDefinitions {
	
	// Attributes
	public TestContextSetUp contextSetUp;
	
	/** Get the pages */
	public CheckoutPage checkoutPage;
	
	/** Constructor to inject dependencies */
	public CheckoutPageStepDefinitions(TestContextSetUp contexSetUp) {
		this.contextSetUp = contexSetUp;
		/** Get the page */
		this.checkoutPage = contextSetUp.pageObjectManager.getCheckoutPage();
	}
	
	/** Step definitions 
	 * @throws InterruptedException */
	@Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException {
		/** Open the cart and access to the checkout*/
		checkoutPage.openCart();
		checkoutPage.accessCheckout();
	}
	
	@Then("^verify user has ability to enter promo code and place the order$")
	public void verify_user_has_ability_to_enter_promo_code() {
		/** Use the methods and validate these */
		Assert.assertTrue(checkoutPage.verifyPromoBtnIsDisplayed()); 
		Assert.assertTrue(checkoutPage.verifyPlaceOrderBtnIsDisplayed());
	}	

}
