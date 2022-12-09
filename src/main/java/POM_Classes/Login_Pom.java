package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Login_Pom
{

	@FindBy(xpath="(//a[@href='https://mirafit.co.uk/customer/account/'])[2]") private WebElement profile;
	@FindBy(xpath="(//input[@class='input-text'])[2]") private WebElement UN;
	@FindBy (xpath="(//input[@class='input-text'])[3]") private WebElement PWD;
	@FindBy(xpath="//button[@class='action login primary']") private WebElement Loginbtn;
	@FindBy (xpath="(//div[@class='box-content'])[1]") private WebElement profilename;
	public Login_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickprofile()
	{
		profile.click();
	}
	
	public void setLogin_PomUsername(String username)
	{
		UN.sendKeys(username);
	}
	
	public void setLogin_Pompassword(String password)
	{
		PWD.sendKeys(password);
	}
	
	public void clickLogin_Pombtn() throws InterruptedException
	{
		Loginbtn.click();
		Thread.sleep(2000);
		String Name = profilename.getText();
		Reporter.log(Name, true);
		
		
	}
	
	
	
	
	
	
}
