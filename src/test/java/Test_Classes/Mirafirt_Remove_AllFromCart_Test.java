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
import org.testng.annotations.Test;

import Library_files.Utility;
import POM_Classes.Login_Pom;
import POM_Classes.Logout_Pom;
import POM_Classes.Mirafirt_Remove_AllFromCart_Pom;

public class Mirafirt_Remove_AllFromCart_Test 
{

	int TCID;
	Login_Pom login;
	Logout_Pom logout;
	Mirafirt_Remove_AllFromCart_Pom Remove_AllFrom_Cart;
	
	WebDriver driver;
	@org.testng.annotations.Parameters("browsername")
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
		Remove_AllFrom_Cart = new Mirafirt_Remove_AllFromCart_Pom(driver);
		
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
	public void Clear_Shopping_Cart() throws InterruptedException
	{
		Remove_AllFrom_Cart.Moveto_Strength(driver);
		
		Remove_AllFrom_Cart.GetProductImage();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
		Remove_AllFrom_Cart.click_Wish_List();
		
		Remove_AllFrom_Cart.Get_Wishlist_Message();
		
		Remove_AllFrom_Cart.Click_Continue_shopping();
		
		js.executeScript("window.scrollBy(0,300)");
		
		Remove_AllFrom_Cart.Click_View_Details(driver);
		
		Remove_AllFrom_Cart.Get_Stock();
		
//		Remove_AllFrom_Cart.Get_Reviews();
		
		Remove_AllFrom_Cart.Click_Choice();
		
		Remove_AllFrom_Cart.Click_Add_To_Cart(driver);
		
		Remove_AllFrom_Cart.Click_On_Cart_Button(driver);
		
		
		///////////////////////////////////////////////////////////////////////////
		
		
		Remove_AllFrom_Cart.Click_Continue_Shopping1();
	
		js.executeScript("window.scrollBy(0,500)");
		
		Remove_AllFrom_Cart.Click_Power_Racks();
		
		js.executeScript("window.scrollBy(0,300)");
		
		Remove_AllFrom_Cart.Click_View_Details1(driver);
		
		Remove_AllFrom_Cart.Get_Stock1();
		
		Remove_AllFrom_Cart.Get_Reviews1();
		
		Remove_AllFrom_Cart.Click_Size();
		
		Remove_AllFrom_Cart.Click_Choice1();
		
		Remove_AllFrom_Cart.Click_Add_To_Cart1(driver);
		
		Remove_AllFrom_Cart.Click_On_Cart_Button1(driver);
		
		Remove_AllFrom_Cart.Clear_cart();
	
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



