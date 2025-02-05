package parallel;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.factory.DriverFactory;
import qa.pages.LoginPage;

public class LoginSteps {
	
	String title;
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	   
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	   
		title = loginpage.getloginpagetitle();
		System.out.println("page title is" + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
	    
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		
		Assert.assertTrue(loginpage.isForgotpwdlinktextExist());
	   
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginpage.enterUserName(username);
	
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
		loginpage.enterPassword(pwd);
	   
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickonLogin();
	   
	}

 
	  
	}



