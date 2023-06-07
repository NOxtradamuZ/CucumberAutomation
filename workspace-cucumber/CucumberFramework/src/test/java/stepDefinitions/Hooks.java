package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetUp;

public class Hooks {
	
	// Attributes
	/** Instantiate the context */
	public TestContextSetUp contextSetUp;
	
	// Constructor
	public Hooks(TestContextSetUp contextSetUp) {
		this.contextSetUp = contextSetUp;
	}
	
	@After
	public void afterScenario() throws IOException {
		contextSetUp.base.webDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = contextSetUp.base.webDriverManager();
		if(scenario.isFailed()) {
			/** Se debe castear para poder pasarle el driver */
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte  [] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
