package com.tcs.Runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/com/tcs/features/PlaceValidation.feature",
		plugin={"json:target/jsonReports/cucumber-report.json"},
		glue= {"stepDefinition"},
		tags= "@AddPlace and ~@Regression")
public class TestRunner {

}
