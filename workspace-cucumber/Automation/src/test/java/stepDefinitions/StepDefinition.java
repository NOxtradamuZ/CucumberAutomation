package stepDefinitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	@Given("^validate the browser$")
	public void validate_the_browser() {
		System.out.println("Validate the browser");
	}

	@Given("^User is on Netbanking landing page$")
	public void user_is_on_netbanking_landing_page() {
		System.out.println("User is on Landing page");
	}
	
	@When("^Browser is triggered$")
	public void browser_is_triggered() {
		System.out.println("Browser is triggered");
	}
	
	@When("User login into application with {string} username and {string} password")
	public void user_login_into_application_with_username_and_password(String userName, String password) {
		System.out.println("User login into the application with " + userName + " username and "+ password + " password");
	}
	
	@When("^User sign up with the following details$")
	public void user_sign_up_with_the_following_details(DataTable data) throws Throwable {
		List<List<String>> obj = data.asLists();
		System.out.println(obj.get(0).get(0));
		System.out.println(obj.get(0).get(1));
		System.out.println(obj.get(0).get(2));
		System.out.println(obj.get(0).get(3));
		System.out.println(obj.get(0).get(4));
	}
	
	@When("^User login in the application with (.+) and (.+)$")
	public void user_login_in_application_with_username_and_password_parameterized(String userName, String password) {
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
	}
	
	@Then("^check if browser is started$")
	public void check_if_browser_is_started() {
		System.out.println("Check if browser is started");
	}
	
	@Then("^Home page is populated$")
	public void home_page_is_populated() {
		System.out.println("Home page is populated");
	}
	
	@Then("Cards displayed are {string}")
	public void cards_displayed_are(String booleanValue) {
		System.out.println("Cards displayed are " + booleanValue);
	}
	
}
