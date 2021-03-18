package pom;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Patientdashbord {
	WebDriver driver;
	public Actions actions;

	public Patientdashbord(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='add-patient']")
	WebElement addPatientBtn;

	@FindBy(xpath = "//input[@id='patient-first-name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='patient-last-name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='patient-identifier']")
	WebElement pid;

	@FindBy(xpath = "//input[@id='patient-dob']")
	WebElement datePicker;

	@FindBy(xpath = "//div[@class='bs-datepicker-head']//button[@class='current']")
	WebElement year;

	@FindBy(xpath = "//button[@class='previous']")
	WebElement prev;

	@FindBy(xpath = "//table[@class='years']//tbody//tr//td")
	List<WebElement> allYears;

	@FindBy(xpath = "//table[@class='months']//tbody//tr//td")
	List<WebElement> allMonths;

	@FindBy(xpath = "//table[@class='days weeks']//tbody//tr//td")
	List<WebElement> alldates;

	@FindBy(xpath = "//h4[@class='modal-title']")
	WebElement poup;

	@FindBy(id = "patient-gender")
	WebElement genderDropdown;

	@FindBy(id = "patient-race")
	WebElement raceDropdown;

	@FindBy(id = "patient-ethnicity")
	WebElement ethnicityDropdown;

	@FindBy(id = "patient-vital-status")
	WebElement vStatusDropdown;

	@FindBy(id = "patient-physician")
	WebElement physicantxt;

	@FindBy(xpath = "//app-new-patient//button[contains(text(),'Add Patient')]")
	WebElement createNewPatient;

	@FindBy(xpath = "//div[contains(text(),'Patient Added')]")
	WebElement sucessMsgHeader;

	@FindBy(xpath = "//*[contains(text(),'Patient has been successfully added.')]")
	WebElement sucessMsg;
	@FindBy(xpath = "//app-success-message-popup//div/div//*[contains(text(),'Close')]")
	WebElement sucessclose;
	
	
	@FindBy(xpath = "//a[@class='ng-star-inserted'][1]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Remove Patient')]")
	WebElement removePatientBtn;
	
	@FindBy(xpath = "//app-remove-patient//p")
	WebElement removePatientMessage;
	
	
	
	@FindBy(xpath = "//button[contains(text(),'Go Back')]")
	WebElement goBackBtn;

	@FindBy(xpath = "//app-success-message-popup//div[2][text()='Patient Deleted!']")
	WebElement deletePatientSuccessMessageHeader;
	
	
	@FindBy(xpath = "//app-success-message-popup//div//div")
	WebElement deletePatientSuccessMessage;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement closeReomePatienttSuccessMessage;
	
	
	public void clickOnAddPatientBtn() {
		addPatientBtn.click();

	}

	public void popUpName() {
		System.out.println(poup.getText());
	}

	public void selectDOB() {

		datePicker.click();
		year.click();

		while (!year.getText().equalsIgnoreCase("1982 - 1997")) {
			prev.click();
		}
		int allyr = allYears.size();
		for (int i = 0; i <= allyr; i++) {
			// System.out.println(allYears.get(i).getText());

			String yearname = allYears.get(i).getText();
			if (yearname.equalsIgnoreCase("1992")) {

				allYears.get(i).click();
				break;

			}
		}
		int month = allMonths.size();
		for (int j = 0; j <= month; j++) {
			String monthName = allMonths.get(j).getText();

			if (monthName.equalsIgnoreCase("June")) {

				allMonths.get(j).click();
				break;
			}

		}

		int date1 = alldates.size();
		for (int k = 0; k < date1; k++) {

			String dateName = alldates.get(k).getText();
			if (dateName.equalsIgnoreCase("14")) {

				alldates.get(k).click();
				break;
			}
		}

	}

	public void getrequiredinfor(String fname, String lname, String mrn) throws InterruptedException {
		Thread.sleep(5000);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		pid.sendKeys(mrn);

	}

	public void getOtherInfo(String sex, String race, String ethnicity, String vitalStatus, String physician) {

		Select sexDropdown = new Select(genderDropdown);
		sexDropdown.selectByValue(sex);
		Select raceDrop = new Select(raceDropdown);
		raceDrop.selectByValue(race);

		Select ethnicitydrpdwn = new Select(ethnicityDropdown);
		ethnicitydrpdwn.selectByValue(ethnicity);

		Select vitaldrpdwn = new Select(vStatusDropdown);
		vitaldrpdwn.selectByValue(vitalStatus);
		physicantxt.sendKeys(physician);

	}

	public void sucessMessageValidation() {

		//sucessclose.click();
		actions= new Actions(driver);
		actions.moveToElement(sucessclose).click().build().perform();

	}

	public void clickOnCreatePatient() throws InterruptedException {
		Thread.sleep(5000);
		createNewPatient.click();
	}
	
	public void clickOnDeleteBtn() {
		deleteBtn.click();
	}
	
	public void verifyConfrmationMessage() {
		actions= new Actions(driver);
		actions.moveToElement(removePatientBtn).build().perform();
		if(removePatientBtn.isDisplayed()==true) {
			System.out.println(removePatientMessage.getText());
		}
	}
	
	
	public void clickOnGoBackBtn() throws InterruptedException {
		Thread.sleep(5000);
		actions= new Actions(driver);
		actions.moveToElement(goBackBtn).click().build().perform();
	}
	
	public void clickOnRemovePatientBtn() throws InterruptedException {
		Thread.sleep(5000);
		actions= new Actions(driver);
		actions.moveToElement(removePatientBtn).click().build().perform();
		
	}
	
	public void verifyRemovePatientSuccessMessage() throws InterruptedException {
		Thread.sleep(10000);
		actions= new Actions(driver);
		actions.moveToElement(closeReomePatienttSuccessMessage).click().build().perform();
			
		
	}
}
