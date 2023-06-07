package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions",
		tags = "@MobileTest or @WebTest",
		plugin = {"pretty", "html:target/cucumber.html"}
)
public class TestMobileRunner extends AbstractTestNGCucumberTests {

}
