package package1;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qapages.FacebookPage;

public class FacebookStepDef {

	protected WebDriver driver;
	FacebookPage login;
	
	
	public FacebookStepDef(HooksBaseClass drive)
	{
		driver = drive.setUpBrowser();
		login= new FacebookPage(driver);
	}
	
	


	@Given("Browser is launched")
	public void browser_is_launched() {
		System.out.println("BROWSER LAUNCHED.");
	}

	@Given("user enters the {string} on login page.")
	public void user_enters_the_on_login_page(String string) {
		login.enterUsername(string);
	}

	@When("user enters {string} on login page.")
	public void user_enters_on_login_page(String string) {
		login.enterPassword(string);
	}

	@When("user clicks on the login button.")
	public void user_clicks_on_the_login_button() {
		login.clickOnLoginButton();
	}

	@Then("close the browser")
	public void close_the_browser() {

		System.out.println("BROWSER CLOSED.");
	}

	@Given("enters the {string} on login page.")
	public void enters_the_on_login_page(String string) {
		login.enterUsername(string);
	}

	@When("enters {string} on login page.")
	public void enters_on_login_page(String string) {
		login.enterPassword(string);   
	}

	@When("clicks on the login button.")
	public void clicks_on_the_login_button() {
		Assert.assertTrue(false);
		login.clickOnLoginButton();
		
	}
}
