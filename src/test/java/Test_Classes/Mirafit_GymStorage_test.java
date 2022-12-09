package Test_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Library_files.Utility;
import POM_Classes.Login_Pom;
import POM_Classes.Logout_Pom;
import POM_Classes.Mirafit_GymStorage_Pom;

public class Mirafit_GymStorage_test 
{

	int TCID;
	Login_Pom login;
	Logout_Pom logout;
	Mirafit_GymStorage_Pom Gym_Storage;
	
	WebDriver driver;
	@Parameters("browsername")
	@Test
	public void TC1(String browsername) throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Softwares\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
	
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium Softwares\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();	
		}
		else if (browsername.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Selenium Softwares\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		// To open the URL
		driver.get("https://mirafit.co.uk/");
		
		// To accept all the cookies
		WebDriverWait wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept Cookies']")));
		driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
		
		
		login=new Login_Pom(driver);
		logout = new Logout_Pom(driver);
		Gym_Storage = new Mirafit_GymStorage_Pom(driver);
		
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=4;
		login.clickprofile();
		login.setLogin_PomUsername(Utility.getdata(0, 0));
		login.setLogin_Pompassword(Utility.getdata(1, 0));
		login.clickLogin_Pombtn();
		
	}
	
	
	@Test(priority=2)
	public void GymStorage() throws InterruptedException
	{
		
		Gym_Storage.Moveto_Gym_Storage(driver);
		
		Gym_Storage.GetProductImage();
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
		Gym_Storage.click_Wish_List();
		
		Gym_Storage.Get_Wishlist_Message();
		
		Gym_Storage.Click_Continue_shopping();
		
		js.executeScript("window.scrollBy(0,300)");
		
		Gym_Storage.Click_View_Details(driver);
		
		Gym_Storage.Get_Stock();
		
//		Gym_Storage.Get_Reviews();
		
		Gym_Storage.Click_Choice();
		
		Gym_Storage.Click_Add_To_Cart(driver);
		
		Gym_Storage.Click_On_Cart_Button(driver);
		
		Gym_Storage.Click_Remove_item_from_Cart(driver);
		
		Gym_Storage.Get_EmptyCartMessage();
		
			
	}
	
	
	
	
	@Test(priority=3)
	public void logout() throws InterruptedException
	{
		TCID=006;
		
		
		logout.click_login_btn();
		logout.click_logout();
		logout.get_logout_message();
	}	
	
	@AfterMethod
	public void Screenshots(ITestResult result) throws IOException, InterruptedException  // Takes the failed TC screenshots
	{
		
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Utility.screenshot(driver, TCID);
		}
	}
	
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close(); // Close the browser
		
		
	}
}
