package POM_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Mirafit_Forgot_Password_Pom
{

	@FindBy(xpath = "(//div[@class='custom_sigin_header'])[2]") private WebElement ProfileButton;
	@FindBy(xpath = "//a[@class='action remind']") private WebElement Forgot_Password;
	@FindBy(xpath = "(//input[@class='input-text'])[2]") private WebElement Email;
	@FindBy(xpath = "//button[@class='action submit primary']") private WebElement Reset_My_Password;
	@FindBy(xpath = "(//div[@class='messages'])[1]") private WebElement Message;
	
	public Mirafit_Forgot_Password_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void Click_ProfileButton()
	{
		ProfileButton.click();
	}
	
	public void Forgot_Password() throws EncryptedDocumentException, IOException
	{
		Forgot_Password.click();
		Email.sendKeys("abc@mailinator.com");
		Reset_My_Password.click();
		String Reset_Message = Message.getText();
		Reporter.log(Reset_Message, true);
		
	}
}
