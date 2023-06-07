package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions",
		tags = "@SmokeTest and @RegTest"
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
