package stepDefinations;

import End2EndScenario.PmPortal.BaseClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.LoginPom;
import pom.Patientdashbord;

public class PatientDashboardOperations extends BaseClass {

	@When("^User select Group from Groups Dashbaord screen$")
	public void user_select_Group_from_Groups_Dashbaord_screen() throws Throwable {
		new LoginPom(driver).clickOnFirstGroup();
	}

	@When("^User clicks on Add Patient Button$")
	public void user_clicks_on_Add_Patient_Button() throws Throwable {

		new Patientdashbord(driver).clickOnAddPatientBtn();
	}

	@Then("^Add Patient popup should be opened$")
	public void add_Patient_popup_should_be_opened() throws Throwable {
		new Patientdashbord(driver).popUpName();
	}

	@When("^user enter Firstname as \"([^\"]*)\" lastname as \"([^\"]*)\" MRN number as \"([^\"]*)\"$")
	public void user_enter_Firstname_as_lastname_as_MRN_number_as(String arg1, String arg2, String arg3)
			throws Throwable {
		new Patientdashbord(driver).getrequiredinfor(arg1, arg2, arg3);
	}

	@When("^Select Date of Birth$")
	public void select_Date_of_Birth() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		new Patientdashbord(driver).selectDOB();
	}

	@When("^Gender as \"([^\"]*)\" Race as \"([^\"]*)\" Ethnicity as \"([^\"]*)\" Vital Status as \"([^\"]*)\"  and Attending Physician as \"([^\"]*)\"$")
	public void gender_as_Race_as_Ethnicity_as_Vital_Status_as_and_Attending_Physician_as(String arg1, String arg2,
			String arg3, String arg4, String arg5) throws Throwable {

		new Patientdashbord(driver).getOtherInfo(arg1, arg2, arg3, arg4, arg5);
	}

	@When("^Click on \"([^\"]*)\" Button$")
	public void click_on_Button(String arg1) throws Throwable {
		new Patientdashbord(driver).clickOnCreatePatient();
	}

	@Then("^Application Should display sucessfull message$")
	public void application_Should_display_sucessfull_message_as() throws Throwable {
		new Patientdashbord(driver).sucessMessageValidation();
	}
	
	
	@When("^click on delete Action taking button$")
	public void click_on_delete_Action_taking_button() throws Throwable {
	    new Patientdashbord(driver).clickOnDeleteBtn();
	 
	}

	@Then("^Application should Display Confirmation message$")
	public void application_should_Display_Confirmation_message() throws Throwable {
	    new Patientdashbord(driver).verifyConfrmationMessage();
	   
	}

	@When("^user click on go back button$")
	public void user_click_on_go_back_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		new Patientdashbord(driver).clickOnGoBackBtn();
	}

	
	@When("^Select Remove Patient button$")
	public void select_Remove_Patient_button() throws Throwable {
		new Patientdashbord(driver).clickOnRemovePatientBtn();
	    
	}

	@Then("^Remove Patient Sucessfull message should be display$")
	public void remove_Patient_Sucessfull_message_should_be_display() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}



	

}
