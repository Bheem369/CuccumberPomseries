package qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	
	private WebDriver driver;

	private By name = By.name("name");
	private By subjectHeading = By.name("subject");
	private By email = By.name("email");
	private By messageText = By.id("message");
	private By sendButton = By.name("submit");
	private By successMessg = By.cssSelector(".status.alert.alert-success");

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public void fillContactUsForm(String heading, String emailId, String Name, String message) {
		
		
		driver.findElement(name).sendKeys(Name);
		driver.findElement(email).sendKeys(emailId);
		driver.findElement(subjectHeading).sendKeys(heading);
		driver.findElement(messageText).sendKeys(message);
	}

	public void clickSend() {
		driver.findElement(sendButton).click();
	}
	
	public String getSuccessMessg() {
		return driver.findElement(successMessg).getText();
	}
	
	public void  clickonAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	
	

}