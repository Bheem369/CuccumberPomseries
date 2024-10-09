package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import qa.factory.DriverFactory;
import qa.pages.AccountPage;
import qa.pages.LoginPage;

public class AccountPageSteps {

	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	private AccountPage ap;

@Given("user had logged into Application")
public void user_had_logged_into_application(DataTable dataTable) {
	
List<Map<String,String>> credlist = dataTable.asMaps();
String userName = credlist.get(0).get("username");
String passWord = credlist.get(0).get("password");

DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
  
   ap = lp.doLogin(userName, passWord);  
}

@Given("user is on account page")
public void user_is_on_account_page() {
	String acttitle = ap.getAccountPageTitle();
	System.out.println(acttitle);
   
}







@Then("user gets accounts section")
public void user_gets_accounts_section(DataTable secTable) {
	List<String> explist = secTable.asList();
	System.out.println("Expected accounts sectionList=" + explist);
	
	List<String> actlist = ap.AccountSectionsList();
	System.out.println("actual accounts sectionlist=" + actlist);
	
	Assert.assertTrue(explist.containsAll(actlist));
   
}

@Then("accounts section count should be {int}")
public void accounts_section_count_should_be(Integer expcount) {
  Assert.assertTrue(ap.getAccountSectionsCount()==expcount);
}

}
