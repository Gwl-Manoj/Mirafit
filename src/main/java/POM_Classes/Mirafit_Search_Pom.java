package POM_Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Mirafit_Search_Pom 
{
	
	@FindBy(id = "action-search") private WebElement Search_Button;
	@FindBy(xpath = "(//input[@class='input-text'])[1]") private WebElement Search_Box;
	@FindBy(className = "base") private WebElement Search_Result;
	@FindBy(xpath = "(//div[@class='product-item-info imgdim-x'])[2]//img[@class='product-image-photo']") private WebElement ProductImage;
	@FindBy(xpath = "(//div[@class='product-item-info imgdim-x'])[2]//span[@class='icon ib ib-hover ic ic-heart ']") private WebElement wishlist;
	@FindBy(xpath = "//div[@class='message-success success message']") private WebElement wishlist_message;
	@FindBy(xpath = "//a[text()='here']") private WebElement Continue_Shopping;
	@FindBy(xpath = "(//a[@class='action tocart primary'])[2]") private WebElement ViewDetails;
	@FindBy(xpath = "//div[@class='stock available']") private WebElement Stock;
	@FindBy(xpath = "//a[@class='action view']") private WebElement Reviews;
	@FindBy(id = "attribute446") private WebElement Choice;
	@FindBy(xpath = "//div[@class='qty-button increase']") private WebElement Quantity_Increment;
	@FindBy(id = "product-addtocart-button") private WebElement AddToCart;
	@FindBy(xpath = "(//span[@class='caret'])[1]") private WebElement CartButton;
	@FindBy(xpath = "//a[@class='action viewcart']") private WebElement ViewAndCartButton;
	@FindBy(xpath = "//div[@class='message message-success success']") private WebElement CartMessage;
	@FindBy(xpath = "//a[@class='action action-delete']") private WebElement RemoveItemfromcart;
	@FindBy(xpath = "//div[@class='cart-empty']") private WebElement EmptyCartMessage;
	
	
	
	public Mirafit_Search_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Get_Search() throws InterruptedException
	{
		if(Search_Button.isEnabled())
		{
			Reporter.log("Button enabled", true);
		}
		else
		{
			Reporter.log("Button is Disabled", true);
		}
		
		
		Search_Box.sendKeys("Dumbbells");
		
		if(Search_Button.isEnabled())
		{
			Reporter.log("Button enabled", true);
		}
		else
		{
			Reporter.log("Button is Disabled", true);
		}
		
		Search_Button.click();
		
		String result = Search_Result.getText();
		Reporter.log(result, true);
		
	}
	
	public void GetProductImage() throws InterruptedException
	{
		if(ProductImage.isDisplayed())
		{
			Reporter.log("Product Image Displayed", true);
		}
		else
		{
			Reporter.log("Product Image Not Displayed", true);
		}
//		Thread.sleep(2000);
	}
	
	public void click_Wish_List() throws InterruptedException
	{
		wishlist.click();
		Thread.sleep(2000);
	}
	
	public void Get_Wishlist_Message() throws InterruptedException
	{
		String Wishlistmessage = wishlist_message.getText();
		Reporter.log(Wishlistmessage, true);
		Thread.sleep(2000);
	}
	
	public void Click_Continue_shopping() throws InterruptedException
	{
		Continue_Shopping.click();
		Thread.sleep(2000);
	}
	
	public void Click_View_Details(WebDriver driver) throws InterruptedException
	{
		ViewDetails.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='fotorama__img magnify-opaque']")));
	}
	
	public void Get_Stock()
	{
		String stock = Stock.getText();
		Reporter.log(" The Product is "+stock, true);	
	}
	
	public void Get_Reviews()
	{
		String Reviews1 = Reviews.getText();
		Reporter.log(Reviews1, true);
	}
	
	public void Click_Choice() throws InterruptedException
	{	
		Select choice = new Select(Choice);
		choice.selectByValue("5540");
		Thread.sleep(2000);
	}
	
	public void Quantity_Increment() throws InterruptedException
	{
		Quantity_Increment.click();
		Thread.sleep(2000);
	}
	
	public void Click_Add_To_Cart(WebDriver driver) throws InterruptedException
	{
		AddToCart.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='minicart-icon-price']")));	
	}
	
	public void Click_On_Cart_Button(WebDriver driver) throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(CartButton).perform();
		ViewAndCartButton.click();
		Thread.sleep(2000);
		
	}
	
	public void Click_Remove_item_from_Cart(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='data table totals']/tbody//td)[2]")));
		RemoveItemfromcart.click();
	}
	
	public void Get_EmptyCartMessage()
	{
		String Emptycart = EmptyCartMessage.getText();
		Reporter.log(Emptycart, true);
	}
	

}
