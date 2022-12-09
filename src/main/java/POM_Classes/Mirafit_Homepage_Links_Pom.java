package POM_Classes;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Mirafit_Homepage_Links_Pom 
{

	@FindBy(xpath = "(//a[@class='logo'])[2]") private WebElement Logo;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[1]") private WebElement Weight_Benches;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[1]") private WebElement Image_Weight_Benches;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[2]") private WebElement Squat_Racks;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[2]") private WebElement Image_Squat_Racks;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[3]") private WebElement Power_Racks;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[3]") private WebElement Image_Power_Racks;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[4]") private WebElement Conditioning;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[4]") private WebElement Image_Conditioning;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[5]") private WebElement Bars;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[5]") private WebElement Image_Bars;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[6]") private WebElement Bumper_Plates;
	@FindBy(xpath = "(//div[@class='col-md-4 col-sm-4 text-center'])[6]") private WebElement Image_Bumper_Plates;
	
	
	public Mirafit_Homepage_Links_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Click_Weight_Benches(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		
		if(Image_Weight_Benches.isDisplayed())
		{
			Reporter.log("The product image is displayed", true);
		}
		else
		{
			Reporter.log("The product image is not displayed", true);
		}
		
		Weight_Benches.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		Reporter.log("The URL for Weight Benches is "+url, true);
		
		String URL = "https://mirafit.co.uk/strength-equipment/weight-benches.html";
		if(url.equalsIgnoreCase(URL))
		{
			Reporter.log("The Url for Weight Benches Is Matched", true);
		}
		
		else
		{
			Reporter.log("The Url for Weight Benches Is Not Matched", true);
		}
		
		Reporter.log("----------------------The List of Weight Banches Products ---------------------", true);

		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']"));  // Get all product list
		
		for(WebElement s1:allproducts)
		{
			System.out.println(s1.getText());
		}
		
		Logo.click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,700)");
		
	}
	
	public void Click_Squat_Racks(WebDriver driver) throws InterruptedException
	{
		if(Image_Squat_Racks.isDisplayed())
		{
			Reporter.log("The product image is displayed", true);
		}
		else
		{
			Reporter.log("The product image is not displayed", true);
		}
		
		
		Squat_Racks.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		Reporter.log("The URL for Squat Racks is "+url, true);
		String URL = "https://mirafit.co.uk/strength-equipment/squat-racks-stands.html";
		if(url.equalsIgnoreCase(URL))
		{
			Reporter.log("The URL for Squat Racks is Matched", true);
		}
		
		else
		{
			Reporter.log("The URL for Squat Racks is Not Matched", true);
		}
		Reporter.log("----------------------The List of Squat Racks Products ---------------------", true);
		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']"));  // Get all product list
		
		for(WebElement s1:allproducts)
		{
			System.out.println(s1.getText());
		}
		
		Logo.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		
	}
	
	
	
	public void Click_Power_Racks(WebDriver driver) throws InterruptedException
	{
		if(Image_Power_Racks.isDisplayed())
		{
			Reporter.log("The product image is displayed", true);
		}
		else
		{
			Reporter.log("The product image is not displayed", true);
		}
		
		Power_Racks.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		Reporter.log("The URL for Power_Racks is "+url, true);
		String URL = "https://mirafit.co.uk/strength-equipment/power-cages-racks.html";
		if(url.equalsIgnoreCase(URL))
		{
			Reporter.log("The URL for Power_Racks is Matched", true);
		}
		
		else
		{
			Reporter.log("The URL for Power_Racks is Not Matched", true);
		}
		Reporter.log("----------------------The List of Power_Racks Products ---------------------", true);
		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']"));  // Get all product list
		
		for(WebElement s1:allproducts)
		{
			System.out.println(s1.getText());
		}
		
		Logo.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
	}
	
	public void Click_Conditioning(WebDriver driver) throws InterruptedException
	{
		if(Image_Conditioning.isDisplayed())
		{
			Reporter.log("The product image is displayed", true);
		}
		else
		{
			Reporter.log("The product image is not displayed", true);
		}
		
		
		Conditioning.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		Reporter.log("The URL for Conditioning is "+url, true);
		String URL = "https://mirafit.co.uk/conditioning.html";
		if(url.equalsIgnoreCase(URL))
		{
			Reporter.log("The URL for Conditioning is Matched", true);
		}
		
		else
		{
			Reporter.log("The URL for Conditioning is Not Matched", true);
		}
		Reporter.log("----------------------The List of Conditioning Products ---------------------", true);
		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']"));  // Get all product list
		
		for(WebElement s1:allproducts)
		{
			System.out.println(s1.getText());
		}
		
		Logo.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
	}
	
	public void Click_Bars(WebDriver driver) throws InterruptedException
	{
		if(Image_Bars.isDisplayed())
		{
			Reporter.log("The product image is displayed", true);
		}
		else
		{
			Reporter.log("The product image is not displayed", true);
		}
		
		
		Bars.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		Reporter.log("The URL for Bars is "+url, true);
		String URL = "https://mirafit.co.uk/weights-and-bars/bars.html";
		if(url.equalsIgnoreCase(URL))
		{
			Reporter.log("The URL for Bars is Matched", true);
		}
		
		else
		{
			Reporter.log("The URL for Bars is Not Matched", true);
		}
		Reporter.log("----------------------The List of Bars Products ---------------------", true);
		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']"));  // Get all product list
		
		for(WebElement s1:allproducts)
		{
			System.out.println(s1.getText());
		}
		
		Logo.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
	}
	
	public void Click_Bumper_Plates(WebDriver driver) throws InterruptedException
	{
		if(Image_Bumper_Plates.isDisplayed())
		{
			Reporter.log("The product image is displayed", true);
		}
		else
		{
			Reporter.log("The product image is not displayed", true);
		}
		
		
		Bumper_Plates.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		Reporter.log("The URL for Bumper_Plates is "+url, true);
		String URL = "https://mirafit.co.uk/weights-and-bars/bumper-plates.html";
		if(url.equalsIgnoreCase(URL))
		{
			Reporter.log("The URL for Bumper_Plates is Matched", true);
		}
		
		else
		{
			Reporter.log("The URL for Bumper_Plates is Not Matched", true);
		}
		Reporter.log("----------------------The List of Bumper_Plates Products ---------------------", true);
		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']"));  // Get all product list
		
		for(WebElement s1:allproducts)
		{
			System.out.println(s1.getText());
		}
		
		Logo.click();
		
		
		
	}
	
	
	
	
}
