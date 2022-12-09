package POM_Classes;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Mirafit_Share_Pom
{

	@FindBy (xpath = "(//span[@class='at-icon-wrapper'])[1]") private WebElement Facebook;
	@FindBy (xpath = "(//span[@class='at-icon-wrapper'])[2]") private WebElement Gmail;
	@FindBy (xpath = "(//span[@class='at-icon-wrapper'])[3]") private WebElement Pin;
	@FindBy (xpath = "(//span[@class='at-icon-wrapper'])[4]") private WebElement Twitter;
	@FindBy (xpath = "(//span[@class='at-icon-wrapper'])[5]") private WebElement More;
	@FindBy(xpath = "(//span[@class='at-expanded-menu-button-label'])[7]") private WebElement LinkedIn;
	
	
	
	
	
	public Mirafit_Share_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void click_Facebook(WebDriver driver) throws InterruptedException
	{
		Facebook.click();
		Set<String> Ids = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(Ids);
		String Facebook = al.get(1);
		
		driver.switchTo().window(Facebook);
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		System.out.println("The URL for Facebook is "+URL);
		
		Thread.sleep(2000);
		driver.close();
		
		String Mirafit = al.get(0);
		driver.switchTo().window(Mirafit);
		Thread.sleep(2000);
		
	}
	
	public void Click_Gmail(WebDriver driver) throws InterruptedException
	{
		Gmail.click();
		
		Set<String> Id = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(Id);
		String Gmail = al.get(1);
		
		driver.switchTo().window(Gmail);
		Thread.sleep(2000);
		String URL1 = driver.getCurrentUrl();
		System.out.println("The URL for Gmail is "+URL1);
		
		Thread.sleep(2000);
		driver.close();
		String Mirafit1 = al.get(0);
		driver.switchTo().window(Mirafit1);
		Thread.sleep(2000);
		
	}
	
	
	public void Click_Pin(WebDriver driver) throws InterruptedException
	{
		Pin.click();
		Thread.sleep(2000);
//	Set<String> Id = driver.getWindowHandles();
//	ArrayList<String> al = new ArrayList<String>(Id);
//	String Pin = al.get(1);
//	
//	driver.switchTo().window(Pin);
//	Thread.sleep(2000);
	
	driver.switchTo().frame("PIN_1646997747256_grid");
	
	driver.findElement(By.xpath("//a[@id='nagDismiss']")).click();
	
	WebElement img = driver.findElement(By.xpath("(//span[@class='pin'])[1]"));
	Actions act = new Actions(driver);
	act.moveToElement(img).click().perform();
//	
//	
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//span[@class='pin'])[1]")).click();
//	driver.findElement(By.xpath("//i[@class='buttonPin buttonSave']")).click();
	
	
	
//	String URL = driver.getCurrentUrl();
//	System.out.println("The URL for Pin is "+URL);
//	Thread.sleep(2000);driver.close();
//	String Mirafit = al.get(0);
//	driver.switchTo().window(Mirafit);
//	Thread.sleep(2000);
//	
	
		
		
	}
	
	
	public void Click_Twitter(WebDriver driver) throws InterruptedException
	{
		Twitter.click();
		Set<String> Ids = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(Ids);
		String Twitter = al.get(1);
		
		driver.switchTo().window(Twitter);
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		System.out.println("The URL for Twitter is "+URL);
		
		Thread.sleep(2000);
		driver.close();
		String Mirafit = al.get(0);
		driver.switchTo().window(Mirafit);
		Thread.sleep(2000);
		
	}
	
	public void Click_More_LinkedIn(WebDriver driver) throws InterruptedException
	{
		More.click();
		Thread.sleep(2000);
		
		LinkedIn.click();
		
		Set<String> Ids = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(Ids);
		String LinkedIn = al.get(1);
		
		driver.switchTo().window(LinkedIn);
		Thread.sleep(2000);
		String URL = driver.getCurrentUrl();
		System.out.println("The URL for LinkedIn is "+URL);
		
		Thread.sleep(2000);
		driver.close();
		String Mirafit = al.get(0);
		driver.switchTo().window(Mirafit);
		
	}
	
	
	
}
