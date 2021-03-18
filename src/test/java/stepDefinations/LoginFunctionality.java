package stepDefinations;

import org.openqa.selenium.WebDriver;

import End2EndScenario.PmPortal.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.LoginPom;

public class LoginFunctionality extends BaseClass {
	
	
	@Given("^user should be landing Page$")
	public void user_should_be_landing_Page() throws Throwable {
		driver= init();
		
	}

	@When("^User enter username as \"([^\"]*)\" and Password as \"([^\"]*)\" and Click on Sign In button$")
	public void user_enter_username_as_and_Password_as_and_Click_on_Sign_In_button(String arg1, String arg2) throws Throwable {
		  new LoginPom(driver).creddetail(arg1, arg2);
		  } 
	

	@Then("^Group dahbosrd screen should be displayed$")
	public void group_dahbosrd_screen_should_be_displayed() throws Throwable {
	    new LoginPom(driver).displayAllGroups();
	}
	
	@And("^Then signout successfully$")
	public void then_signout_successfully() throws Throwable {
		new LoginPom(driver).signOut();
	}

	@And("^Close the browser Sucessfully$")
	public void close_the_browser_sucessfully() throws Throwable {
	    driver=closeBrowser();
	}


}
