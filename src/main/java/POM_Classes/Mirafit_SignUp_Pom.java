package POM_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Library_files.Utility;

public class Mirafit_SignUp_Pom
{

	@FindBy(xpath = "(//div[@class='custom_sigin_header'])[2]") private WebElement ProfileButton;
	@FindBy(xpath = "//a[@class='action create primary']") private WebElement SignUpButton;
	@FindBy(xpath = "(//input[@class='input-text required-entry'])[1]") private WebElement First_Name;
	@FindBy(xpath = "(//input[@class='input-text required-entry'])[2]") private WebElement Last_Name;
	@FindBy(xpath = "(//input[@class='input-text'])[2]") private WebElement Email;
	@FindBy(xpath = "(//input[@class='input-text'])[3]") private WebElement Password;
	@FindBy(xpath = "(//input[@class='input-text'])[4]") private WebElement Confirm_Password;
	@FindBy(xpath = "//button[@class='action submit primary']") private WebElement SignUp_Submit;
	@FindBy(xpath = "(//div[@class='messages'])[1]") private WebElement SignUp_Message;

	public Mirafit_SignUp_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void Click_ProfileButton()
	{
		ProfileButton.click();
	}
	
	public void SignUpButton() throws EncryptedDocumentException, IOException
	{
		SignUpButton.click();
		First_Name.sendKeys(Utility.getdata(5, 6));
		Last_Name.sendKeys(Utility.getdata(6, 6));
		Email.sendKeys(Utility.getdata(7, 6));
		Password.sendKeys(Utility.getdata(8, 6), Keys.TAB);
		Confirm_Password.sendKeys(Utility.getdata(9, 6));
		SignUp_Submit.click();
		String Signup_Message = SignUp_Message.getText();
		Reporter.log(Signup_Message, true);
		
	}
	
	
}
