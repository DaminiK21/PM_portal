package End2EndScenario.PmPortal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class BaseClass {

	
	public static WebDriver driver;
	public Properties prop;
	public WebDriver init() throws IOException {
		prop=new Properties();
		FileInputStream fin=new FileInputStream("D:\\Eclipse\\Scripts\\PmPortal\\src\\main\\java\\End2EndScenario\\PmPortal\\data.properties");
		prop.load(fin);
		// TODO Auto-generated method stub
		
		//String Browser=ConfigReader.GetPropertyValue("browser");
		String Browser=prop.getProperty("browser");
		if(Browser.equalsIgnoreCase("chrome")) {
			
			
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Browser Driver\\chromedriver.exe");                                                
			driver=new ChromeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Browser Driver\\chromedriver.exe");
			//driver=new ChromeDriver();
			//driver.get(prop.getProperty("url"));
		}
		
		else {
			/*System.setProperty("webdriver.chrome.driver", "D:\\Eclipse\\Browser Driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get(prop.getProperty("url"));*/
		}
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	
	public WebDriver closeBrowser() {
		driver.close();
		return driver;
	}                                                                                                                                                                                                                                                                                                                                                       

}
