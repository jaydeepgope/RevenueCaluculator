package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="FeatureFiles/FitPeoRevenueCalculator.feature",
		glue= "stepdefinitions",
		dryRun=false,
		plugin = {"pretty", "html:Test Reports/revenueresul.html"}
		)


public class TestRunner extends AbstractTestNGCucumberTests{

}
