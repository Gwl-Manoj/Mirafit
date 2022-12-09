package POM_Classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Library_files.Utility;

public class Mirafit_Address_Pom
{

	@FindBy(xpath = "(//a[@class='action edit'])[3]") private WebElement Manage_Address;
	@FindBy(xpath = "//button[@class='action primary add']") private WebElement Add_New_Address;
	@FindBy(xpath = "(//input[@class='input-text required-entry'])[3]") private WebElement Phone_Number;
	@FindBy(xpath = "(//input[@class='input-text required-entry'])[4]") private WebElement Street_Address;
	@FindBy(xpath = "(//input[@class='input-text required-entry'])[5]") private WebElement City;
	@FindBy(xpath = "//input[@class='input-text validate-zip-international required-entry']") private WebElement Zip_Code;
	@FindBy(xpath = "//button[@class='action save primary']") private WebElement Save_Address;
	@FindBy(xpath = "(//div[@class='messages'])[1]") private WebElement Save_Address_Message;
	@FindBy(xpath = "(//a[@class='action delete'])[1]") private WebElement Delete;
	@FindBy(xpath = "//button[@class='action-primary action-accept']") private WebElement Delete_Ok;
	@FindBy(xpath = "//div[text()='You deleted the address.']") private WebElement Delete_Message;
	
	
	
	
	public Mirafit_Address_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_Manage_Address() throws InterruptedException
	{
		Manage_Address.click();
		Thread.sleep(2000);
	}
	
	public void Click_Add_New_Address() throws InterruptedException
	{
		Add_New_Address.click();
		Thread.sleep(2000);
	}
	
	public void Set_Phone_Number() throws EncryptedDocumentException, IOException
	{
		Phone_Number.sendKeys(Utility.getdata(5, 3));
	}
	
	public void Set_Street_Address() throws EncryptedDocumentException, IOException
	{
		Street_Address.sendKeys(Utility.getdata(6, 3));
	}
	
	public void Set_City() throws EncryptedDocumentException, IOException
	{
		City.sendKeys(Utility.getdata(7, 3));
	}
	
	public void Set_Zip_Code() throws EncryptedDocumentException, IOException
	{
		Zip_Code.sendKeys(Utility.getdata(8, 3));
	}
	
	public void Click_Save_Address() throws InterruptedException
	{
		Save_Address.click();
		Thread.sleep(2000);
		String Add_Message = Save_Address_Message.getText();
		Reporter.log(Add_Message, true);
	}
	
	public void Click_Delete() throws InterruptedException
	{
		Delete.click();
		Delete_Ok.click();
		String delete_message = Delete_Message.getText();
		Reporter.log(delete_message, true);
		Thread.sleep(2000);
		
	}
	
	
	
}
