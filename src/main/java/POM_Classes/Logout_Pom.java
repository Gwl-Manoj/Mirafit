package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Logout_Pom 
{

	@FindBy(xpath = "(//a[@href='https://mirafit.co.uk/customer/account/'])") private WebElement Profile;
	@FindBy(xpath = "//a[@class='header_account_link']") private WebElement logout;
	@FindBy(xpath="//span[@class='base']") private WebElement logout_message;
	
	
	public Logout_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void click_login_btn()
	{
		Profile.click();
	}
	
	public void click_logout()
	{
		logout.click();
	}
	
	public void get_logout_message()
	{
		String SignOut = logout_message.getText();
		Reporter.log(SignOut, true);
	}
	
}
