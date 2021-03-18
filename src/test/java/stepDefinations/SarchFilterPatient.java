package stepDefinations;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import End2EndScenario.PmPortal.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import pom.Search_FilterPatient;

public class SarchFilterPatient extends BaseClass {

	@When("^user click on Search icon$")
	public void user_click_on_search_icon() throws Throwable {
		new Search_FilterPatient(driver).clickOnSearchIcon();
	}

	@Then("^Application should display Patient details on Patient dashboard Screen$")
	public void application_should_display_patient_details_on_patient_dashboard_screen() throws Throwable {
		new Search_FilterPatient(driver).verifyResultIsDisplayed();
	}

	@And("^user enter valid Patient id as \"([^\"]*)\"$")
	public void user_enter_valid_patient_id_as_something(String mrn) throws Throwable {
		new Search_FilterPatient(driver).EnterPatientID(mrn);
	}
	 @When("^Clear the Search text box$")
	    public void clear_the_search_text_box() throws Throwable {
		 new Search_FilterPatient(driver).clearSearch_Text();
	    }
	
	

	@When("^user Clicks on Filter icon$")
	public void user_clicks_on_filter_icon() throws Throwable {
		new Search_FilterPatient(driver).clickOnFilterIcon();
	}

	@Then("^Application should Open search filter section with Cancel,Reset and Apply filter buttons$")
	public void application_should_open_search_filter_section_with_cancelreset_and_apply_filter_buttons()
			throws Throwable {
		new Search_FilterPatient(driver).checkAllButtonsAreDisplayed();
	}

	 @When("^user clicks on Cancel link$")
	    public void user_clicks_on_cancel_link() throws Throwable {
		 new Search_FilterPatient(driver).clickOnCancelLink();
	    }
	

	@Then("^application should close the Filter section$")
	public void application_should_close_the_filter_section() throws Throwable {
		new Search_FilterPatient(driver).checkCancelButtonsfunctionality();
	}

	

	@And("^User enter Patient name as \"([^\"]*)\"and  \"([^\"]*)\" and Patient Id as \"([^\"]*)\"$")
	public void user_enter_patient_name_as_somethingand_something_and_patient_id_as_something(String fname,
			String lname, String mrn) throws Throwable {
		new Search_FilterPatient(driver).applyFilterCriteria(fname, lname, mrn);
	}

	@And("^click on Reset Button$")
	public void click_on_reset_button() throws Throwable {

		new Search_FilterPatient(driver).clickOnResetBtn();
		new Search_FilterPatient(driver).checkResetButtonsfunctionality();
	}

	@Then("^application should reset all search fields$")
	public void application_should_reset_all_search_fields() throws Throwable {
		new Search_FilterPatient(driver).checkResetButtonsfunctionality();
	}

	@And("^click on Apply filter button$")
	public void click_on_apply_filter_button() throws Throwable {
		new Search_FilterPatient(driver).clickOnapplyFilterbtn();
	}

}
