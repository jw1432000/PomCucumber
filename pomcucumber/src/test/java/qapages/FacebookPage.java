package qapages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {
	
	protected WebDriver driver;
	
	@FindBy(name="firstname")
	WebElement enterUsername;
	
	@FindBy(name="pass")
	WebElement enterPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement clickLoginButton;
	
	public FacebookPage(WebDriver driver2)
	{
		driver = driver2;
		PageFactory.initElements(driver, this);
	}
	
	
	//ACtions
	public void enterUsername(String un)
	{
		enterUsername.sendKeys(un);
	}
	public void enterPassword(String pwd)
	{
		enterPassword.sendKeys(pwd);
	}
	public void clickOnLoginButton()
	{
		clickLoginButton.click();	
	}

}
