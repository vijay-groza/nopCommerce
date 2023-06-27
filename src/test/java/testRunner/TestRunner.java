package testRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Vijay\\eclipse-workspace\\noopCommerce\\src\\test\\java\\Features\\Customers.feature",
		glue = "stepDefinition",
		dryRun = false,
		plugin = {"pretty","html:test-output"},
		monochrome = true
		)
public class TestRunner {
		
	
	
}
