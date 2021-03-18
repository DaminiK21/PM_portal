import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPom {
	WebDriver driver;
	
	
	public LoginPom(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	
		
		@FindBy(xpath="//input[@formcontrolname='email']")
		WebElement username;
		
		@FindBy(xpath="//input[@formcontrolname='password']")
		WebElement password;
		
		@FindBy(xpath="//button[@class='btn btn-primary']")
		WebElement signIn;
		
		public void creddetail(String user,String pass) {
			username.sendKeys(user);
			password.sendKeys(pass);
			signIn.click();
			
		}

	

}
