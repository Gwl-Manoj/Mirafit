package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mirafit_RemoveAllFrom_Wishlist_Pom 
{

	@FindBy(xpath = "//a[text()='Wish List']") private WebElement Wishlist;
	@FindBy(xpath = "//span[text()='Remove item']") private WebElement Remove_Item;
	
	
	public Mirafit_RemoveAllFrom_Wishlist_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_Wishlist()
	{
		Wishlist.click();
		
	}
	
	public void Click_Remove_Item(WebDriver driver) throws InterruptedException
	{
	
		int size = driver.findElements(By.xpath("//ol[@class='product-items']/li")).size();
			
		for(int i=1; i<=size; i++)
		{
			Remove_Item.click();
			Thread.sleep(2000);
		}
		
	}
}
