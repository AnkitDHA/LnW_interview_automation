package RunnerFile;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/FeatureFiles"},
		glue = {"StepDefinitions"},
		plugin = {
				"pretty",
				
				"html:target/cucumber-report.html"
		},
		
		dryRun = false,
		
		tags = "@2items"
		
		
		
		
		)






public class TestRunner {

	
	
}
