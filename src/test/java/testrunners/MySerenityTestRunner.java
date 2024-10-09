package testrunners;

import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import net.serenitybdd.cucumber.CucumberWithSerenity;
//import net.serenitybdd.cucumber.CucumberWithSerenity;

//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"src/test/resource/parallel"},
		glue = {"parallel"},
		plugin = {"pretty"}
		)

public class MySerenityTestRunner {
	

}
