package parallel;



//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

//import io.cucumber.java.Scenario;
//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resource/parallel" },
	    glue = {"parallel"},
	    tags = "not @Skip",
		monochrome = true,
		plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/",
				   "rerun:target/failedrerun.txt"}
		)

public class ParallelRunTG extends AbstractTestNGCucumberTests {
	
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
		
	}
	
	
     
	

}

