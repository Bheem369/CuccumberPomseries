package qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By signInBtn = By.xpath("//input[@type='submit']");
	private By forgotpwdlink = By.linkText("Forgotten Password");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getloginpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotpwdlinktextExist()
	{
		return driver.findElement(forgotpwdlink).isDisplayed();
	}

	public void enterUserName(String username)
	{
		driver.findElement(emailid).sendKeys(username);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickonLogin()
	{
		driver.findElement(signInBtn).click();
	}
	
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		return new AccountPage(driver);
	}
}
