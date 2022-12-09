package POM_Classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Mirafit_Sortby_listbox_Pom
{

	@FindBy(xpath = "//li[@class='nav-item level0 nav-1 level-top first nav-item--parent classic nav-item--only-subcategories parent']") private WebElement Strength_Equipement;
	@FindBy(xpath = "(//select[@class='sorter-options'])[1]") private WebElement SortBy;
	
	
	
	public Mirafit_Sortby_listbox_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_Strength_Equipement() throws InterruptedException
	{
		Strength_Equipement.click();
		Thread.sleep(2000);
	}
	
	public void Click_SortBy(WebDriver driver) throws InterruptedException
	{
		System.out.println("----------------< Result before sorting >--------------------");
		List<WebElement> Options = driver.findElements(By.xpath("//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']"));  // For to get 24 products list
		
		for(WebElement s1:Options)
		{
			System.out.println(s1.getText());
		}
				
		Thread.sleep(2000);
		Select ss = new Select(SortBy);		
		ss.selectByValue("name"); //  The results will be sorted by name
		Thread.sleep(2000);
		System.out.println("----------------< Result after sorting >------------------");
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']"));  // For to get 24 products list
		
		for(WebElement s1:options)
		{
			System.out.println(s1.getText());
		}
	}
	
}
