package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Class for running the pre and post requisites
 * for a set of feature files
 * @author borja
 *
 */
public class Hooks {
	
	@Before("@MobileTest")
	public void beforeMobileValidation() {
		System.out.println("Before trigering the mobile hook");
	}
	
	@After("@MobileTest")
	public void afterMobileValidation() {
		System.out.println("After triggering the mobile hook");
	}
	
	@Before("@WebTest")
	public void beforeWebValidation() {
		System.out.println("Before trigering the web hook");
	}
	
	@After("@WebTest")
	public void afterWebValidation() {
		System.out.println("After triggering the web hook");
	}

}
