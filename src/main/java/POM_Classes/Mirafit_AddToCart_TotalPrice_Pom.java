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

public class Mirafit_AddToCart_TotalPrice_Pom 
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
	@FindBy(xpath = "(//table[@class='cart items data table']//tbody[@class='cart item']//td)[1]") private WebElement Product_Info;
	@FindBy(xpath = "(//table[@class='cart items data table']//tbody[@class='cart item']//td)[2]") private WebElement Product_Price;
	@FindBy(xpath = "(//table[@class='data table totals']/tbody//td)[1]") private WebElement SubTotal;
	@FindBy(xpath = "(//table[@class='data table totals']/tbody//td)[2]") private WebElement All_Charges;
	@FindBy(xpath = "(//table[@class='data table totals']/tbody//td)[3]") private WebElement Ordertotal;
	
	
	public Mirafit_AddToCart_TotalPrice_Pom(WebDriver driver)
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
	
	public void Get_Product_Info(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@class='data table totals']/tbody//td)[2]")));
		String Productinfo = Product_Info.getText();
		Reporter.log("The product Info is "+Productinfo, true);
		Thread.sleep(2000);
	}
	
	public void Get_Product_Price() throws InterruptedException
	{
		String ProductPrice = Product_Price.getText();
		Reporter.log("Product price is "+ProductPrice , true);
		String ExpPrice ="£199.95";
		if(ProductPrice.equals(ExpPrice))
		{
			Reporter.log("The TC for Product price is Pass", true);
		}
		else
		{
			Reporter.log("The TC for Product price is Fail", true);
		}
		
	}

	public void Get_Sub_Total() throws InterruptedException
	{
		String Expsubtotal ="£399.90";
		String Subtotal = SubTotal.getText();
		Reporter.log("The product subtotal is "+Subtotal, true);
		
		if(Subtotal.equals(Expsubtotal))
		{
			Reporter.log("The TC for Subtotal is Pass", true);
		}
		else
		{
			Reporter.log("The TC for Subtotal is Fail", true);
		}
		Thread.sleep(2000);
	}
	
	public void Get_Charges() throws InterruptedException
	{
		String Charges = All_Charges.getText();
		Reporter.log("The Shipping charges are "+Charges, true);
		String Expcharges = "£4.95";
		if(Charges.equals(Expcharges))
		{
			Reporter.log("The TC for Charges is Pass", true);
		}
		else
		{
			Reporter.log("The TC for Charges is Fail", true);
		}
		Thread.sleep(2000);
	}
	
	public void Get_Ordertotal()
	{
		String OrderTotal = Ordertotal.getText();
		Reporter.log("The order total is "+OrderTotal, true);
		String Expordeertotal ="£404.85";
		if(OrderTotal.equals(Expordeertotal))
		{
			Reporter.log("The TC for Order Total is Pass", true);
		}
		else
		{
			Reporter.log("The TC for Order Total is Fail", true);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
