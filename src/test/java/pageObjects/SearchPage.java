package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends basePage {

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(linkText = "MacBook")
	WebElement macProduct;
	
	public boolean isProductExist(String ProductName)
	{
		 macProduct.sendKeys(ProductName); 
		 return true;
	}
	
}
