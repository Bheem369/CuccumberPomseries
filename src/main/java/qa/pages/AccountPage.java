package qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	private WebDriver driver;
	
	private By accountSections = By.xpath("//div[@id='content']//h2");
	
	public AccountPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public int getAccountSectionsCount()
	{
		return driver.findElements(accountSections).size();
	}
	
	public String getAccountPageTitle()
	{
		return driver.getTitle();
	}
	
	public List<String> AccountSectionsList()
	{
		List<String> acclist = new ArrayList<>();
		List<WebElement> headlist = driver.findElements(accountSections);
		
		for(WebElement e: headlist)
		{
			String text = e.getText();
			System.out.println(text);
			acclist.add(text);
		}
		
		return acclist;
	}
	
	

}
