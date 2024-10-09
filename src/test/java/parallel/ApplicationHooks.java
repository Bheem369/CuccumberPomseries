package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.factory.DriverFactory;
import qa.util.ConfigReader;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	private Properties prop;
	
	
	
	
	
//	public void skip_scenario(Scenario scenario)
//	{
//		scenario.getName();
//	}
	
	@Before(order=0)
	public void getProperty()
	{
		configreader = new ConfigReader();
		prop = configreader.init_Prop();
	}

	@Before(order=1)
	public void launchBrowser()
	{
		String BrowserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.inti_driver(BrowserName);
		
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String ScreenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath,"image/png", ScreenshotName);
		}
	}
}
