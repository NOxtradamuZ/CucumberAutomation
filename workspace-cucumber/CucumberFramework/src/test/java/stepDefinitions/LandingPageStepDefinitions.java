package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetUp;

public class LandingPageStepDefinitions {
	
	// Attributes
	public String offerPageProductName;
	public TestContextSetUp contextSetUp;
	
	/** Get the pages */
	public LandingPage landingPage;
	
	/** Constructor and dependencies injection */
	public LandingPageStepDefinitions(TestContextSetUp contextSetUp) {
		this.contextSetUp = contextSetUp;
		this.landingPage = contextSetUp.pageObjectManager.getLandingPage();
	}
 	
	@Given("^useris on Greencart landing page$")
    public void user_is_on_greencart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingsPage().contains("GreenKart"));
    }

	@When("^user searched with shortname (.+) and extracted the actual name of product$")
    public void user_searched_with_shortname_and_extracted_the_actual_name_of_product(String shortName) throws InterruptedException {
    	
    	/** Le pasamos el shortname como argumento */
    	landingPage.searchItem(shortName);
    	
    	Thread.sleep(2000);
    	contextSetUp.landingPageProductName = landingPage.getProductName()
    			.split("-")[0]
    			.trim();
    	System.out.println(contextSetUp.landingPageProductName + " is extracted from Home page");
    }
	
	@When("^added \\\"([^\\\"]*)\\\" items of the selected product to cart$")
	public void added_items_of_the_selected_product_to_cart(String quantity) {
		
		/** Añadimos los 3 items al carrito */
		landingPage.incrementItem(Integer.parseInt(quantity));
		landingPage.addItemToCart();
	}
    
}
