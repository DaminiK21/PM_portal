package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import End2EndScenario.PmPortal.BaseClass;

public class Search_FilterPatient {
	WebDriver driver;

	public Search_FilterPatient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='assets/icons/search.svg']")
	WebElement sarchIcon;

	@FindBy(id = "search-keyword")
	WebElement sarchTextbox;

	@FindBy(xpath = "//img[@src='assets/icons/filter.svg']")
	WebElement filtericon;

	@FindBy(xpath = "//datatable-body[@class='datatable-body']//datatable-body-row")
	List<WebElement> searchResult;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement cancelLink;

	@FindBy(xpath = "//div[@class='patient-filter-buttons']//button[@class='btn btn-primary']")
	WebElement resetBtn;

	@FindBy(xpath = "//div[@class='patient-filter-buttons']//button[@class='btn btn-secondary']")
	WebElement applyFilterBtn;

	@FindBy(id = "patient-filter-name")
	WebElement filterPName;

	@FindBy(id = "patient-filter-identifier")
	WebElement filterPid;

	public void clickOnSearchIcon() throws InterruptedException {
		Thread.sleep(5000);
		sarchIcon.click();
	}

	public void EnterPatientID(String pid) {
		sarchTextbox.sendKeys(pid);
	}

	public void verifyResultIsDisplayed() throws InterruptedException {
		Thread.sleep(5000);
		int totalPatient = searchResult.size();
		for (int i = 0; i < totalPatient; i++) {
			System.out.println(searchResult.get(i).getText());
		}

	}

	public void clickOnCancelLink() throws InterruptedException {
		Thread.sleep(5000);
		cancelLink.click();
	}
	
	public void checkCancelButtonsfunctionality() {
		
		System.out.println("Clicked on Cancel linlk");
		/*if (!cancelLink.isDisplayed() && !resetBtn.isDisplayed() && !applyFilterBtn.isDisplayed()) {
			System.out.println("Cancel link working as expected");
		}
		else {
			System.out.println(" operation is not perform successfully");
		}*/
	}


	public void clickOnResetBtn() throws InterruptedException {
		Thread.sleep(4000);
		resetBtn.click();
	}

	public void clickOnapplyFilterbtn() throws InterruptedException {
		Thread.sleep(5000);
		applyFilterBtn.click();
	}

	public void applyFilterCriteria(String pfname, String Plname, String pid) throws InterruptedException {
		Thread.sleep(2000);
		filtericon.click();
		String patientName = pfname + " " + Plname;
		filterPName.sendKeys(patientName);
		filterPid.sendKeys(pid);
	}

	public void checkAllButtonsAreDisplayed() {
		if (cancelLink.isDisplayed() && resetBtn.isDisplayed() && applyFilterBtn.isDisplayed()) {
			System.out.println("Filter Section is displayed correctly");
		}
	}

	
	public void checkResetButtonsfunctionality() throws InterruptedException {
		if (filterPName.getText() == " ") {
			Thread.sleep(2000);
			System.out.println("Reset button working as expected");

		}

	}

	public void clickOnFilterIcon() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		filtericon.click();
	}

	public void clearSearch_Text() throws InterruptedException {
		// TODO Auto-generated method stub

		sarchTextbox.clear();
		Thread.sleep(2000);
	}

}
