package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPom {
	WebDriver driver;

	public LoginPom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	


	@FindBy(xpath = "//input[@formcontrolname='email']")
	WebElement username;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement signIn;
	
	@FindBy(xpath="//datatable-body[@class='datatable-body']//datatable-row-wrapper[1]")
	WebElement  clickongrp;

	
	@FindBy(xpath="//div[@class='datatable-row-left datatable-row-group ng-star-inserted']")
	List<WebElement> allGroups;
	
	@FindBy(id="sign-out")
	WebElement SignOutlink;
	
	@FindBy(xpath="//span[@class='user-details']")
	WebElement profileHover;
	
	
	
	public void displayAllGroups() {
		int count= allGroups.size();
		for(int i=1;i<=count-1;i++) {
			String Groupname=allGroups.get(i).getText();
			System.out.println(Groupname);
		}
	}
	
	public void clickOnFirstGroup() throws InterruptedException {
		/*WebDriverWait wt= new WebDriverWait(driver,15);
		wt.until(ExpectedConditions.visibilityOf(clickongrp));
		System.out.println(clickongrp.getText());*/
		
		clickongrp.click();
	}

	public void creddetail(String user, String pass) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(pass);
		signIn.click();
		
		
	}
	
	public void signOut() {
		Actions act= new Actions(driver);
		act.moveToElement(profileHover).build().perform();
		SignOutlink.click();
	}

}
