package POM_Classes;

import java.util.List;

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

public class Mirafit_Package_Pom
{
	
	@FindBy(xpath = "(//a[@class='logo'])[2]") private WebElement Homepage;
	@FindBy(xpath = "//li[@class='nav-item level0 nav-6 level-top classic']") private WebElement Package;
	@FindBy(xpath = "(//a[@class='page'])[1]") private WebElement page2;
	@FindBy(xpath = "//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']") private WebElement Allproducts;
	@FindBy(xpath = "(//div[@class='product-item-info imgdim-x'])[2]//img[@class='product-image-photo']") private WebElement ProductImage;
	@FindBy(xpath = "(//div[@class='product-item-info imgdim-x'])[2]//span[@class='icon ib ib-hover ic ic-heart ']") private WebElement wishlist;
	@FindBy(xpath = "//div[@class='message-success success message']") private WebElement wishlist_message;
	@FindBy(xpath = "//a[text()='here']") private WebElement Continue_Shopping;
	@FindBy(xpath = "(//span[text()='Add to Cart'])[1]") private WebElement AddtoCart;
	@FindBy(xpath = "//div[@class='stock available']") private WebElement Stock;
	@FindBy(xpath = "//a[@class='action view']") private WebElement Reviews;
	@FindBy(id = "attribute447") private WebElement Colour;
	@FindBy(id = "attribute465") private WebElement Choice;
	@FindBy(id = "product-addtocart-button") private WebElement AddToCart;
	@FindBy(xpath = "(//span[@class='caret'])[1]") private WebElement CartButton;
	@FindBy(xpath = "//a[@class='action viewcart']") private WebElement ViewAndCartButton;
	@FindBy(xpath = "//div[@class='message message-success success']") private WebElement CartMessage;
	@FindBy(xpath = "//a[@class='action action-delete']") private WebElement RemoveItemfromcart;
	@FindBy(xpath = "//div[@class='cart-empty']") private WebElement EmptyCartMessage;
	
	
	
	public Mirafit_Package_Pom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_Homepage(WebDriver driver) throws InterruptedException
	{
		Homepage.click();
		Package.click();
		page2.click();
		Thread.sleep(2000);
		List<WebElement> allproducts = driver.findElements(By.xpath("//div[@class='products wrapper grid items-grid items-grid-partitioned category-products-grid single-line-name hover-effect equal-height ']"));  // Get all product list
		
		for(WebElement s1:allproducts)
		{
			System.out.println(s1.getText());
		}
	
	}
	
	public void GetProductImage()
	{
		if(ProductImage.isDisplayed())
		{
			Reporter.log("Product Image Displayed", true);
		}
		else
		{
			Reporter.log("Product Image Not Displayed", true);
		}
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
	
	public void Click_AddtoCart(WebDriver driver) throws InterruptedException
	{
		AddtoCart.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='fotorama__img magnify-opaque']")));
	}
	
	
	public void Click_On_Cart_Button(WebDriver driver) throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(CartButton).perform();
		ViewAndCartButton.click();
		
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
