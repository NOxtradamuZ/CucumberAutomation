package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EcommerceSteps {
	
	// Attributes
	public WebDriver driver;
	public String productNameCatalog;
	public List<WebElement> products;
	
	public WebDriverWait wait;
	
	// Cucumber methods

	@Given("^user is on Greencart landing page$")
    public void user_is_on_greencart_landing_page() {
        
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/borja/Desktop/Drivers Selenium/chromedriver.exe"
				);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");	
    }

    @When("^user searches with shortname \"([^\"]*)\"$")
    public void user_searches_with_shortname_something(String productName) {
    	WebElement searchTool = driver.findElement(By.className("search-keyword"));
    	searchTool.sendKeys(productName);
    }
    
    @When("^user extracts the actual name of the product$")
    public void user_extracts_the_actual_name_of_the_product() {
    	
    	// Wait until the element appears
    	wait.until(ExpectedConditions.textToBePresentInElementLocated(
    			By.className("product-name"),
    			"Tomato - 1 Kg"
    			));
    	
    	WebElement fruitTitle = driver.findElement(By.className("product-name"));
    	productNameCatalog = fruitTitle.getText().split(" ")[0];
    	Assert.assertEquals(productNameCatalog, "Tomato");
    }
    
    @When("^user access to the offers page$")
    public void user_access_to_the_offers_page() {
    	
    	/** Click on the button with the list of products*/
    	driver.findElement(By.xpath("//div[@class='cart']/a[2]")).click();
    	
    	/** Handle the windows */
    	Set<String> windows = driver.getWindowHandles();
    	Iterator<String> it = windows.iterator();
    	/** ParentId and ChildId are like a tuple */
    	String parentId = it.next();
    	String childId = it.next();
    	
        driver.switchTo().window(childId);
  
    }
    
    @When("^user searches with the extracted product name$")
    public void user_searches_with_the_extracted_product_name() {
    	
    	driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(productNameCatalog);
       
    }

    @Then("^user checks if the product exists$")
    public void user_checks_if_the_product_exists() {
    	/** With all the results, we will check the text */
		List<WebElement> filterElements = driver
			.findElements(By.xpath("//table[@class='table table-bordered']//td[1]"))
			.stream()
			.filter(s->s.getText().contains(productNameCatalog))
			.collect(Collectors.toList());
		
		Assert.assertEquals(productNameCatalog, filterElements.get(0).getText());	
    }
}
