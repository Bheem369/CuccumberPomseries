package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.ContactUsPage;
import qa.util.ExcelReader;

public class ContactUsSteps {
	
	private ContactUsPage contactUspage = new ContactUsPage(DriverFactory.getDriver());
	
	@Given("user navigate to contactus page")
	public void user_navigate_to_contactus_page() {
		
		DriverFactory.getDriver().get("https://www.automationexercise.com/contact_us");
	  
	}

	@When("user fills the given form name with sheetname {string} and rownumber {int}")
	public void user_fills_the_given_form_name_with_sheetname_and_rownumber(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>> testdata = reader.getData("C:\\Users\\DELL\\Documents\\contactusdata.xlsx", SheetName );
		
		String Name =  testdata.get(RowNumber).get("name");
		String email =  testdata.get(RowNumber).get("emailid");
	    String heading =  testdata.get(RowNumber).get("subject");
	    String mesg =  testdata.get(RowNumber).get("message");
	    
	    contactUspage.fillContactUsForm(heading, email, Name, mesg);
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		contactUspage.clickSend();
	    
	}
	
	@When("clicks ok on alert popup button")
	public void clicks_ok_on_alert_popup_button() {
	    
		contactUspage.clickonAlert();
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String expsucmesg) {
		
		String actsucmesg = contactUspage.getSuccessMessg();
		Assert.assertEquals(actsucmesg, expsucmesg);
	 
	}


}
