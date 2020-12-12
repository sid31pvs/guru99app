package guru99.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import guru99.base.BaseTest;

public class ShoppingCartPage extends BaseTest {
	
	@CacheLookup
	@FindBy(xpath="//tbody/tr[1]/td[4]/input[1]")
	WebElement quantityField;
	
	@CacheLookup
	@FindBy(xpath="//tbody/tr[1]/td[4]/input[1]")
	WebElement updateButton;
	
	@CacheLookup
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[1]/span[1]")
	WebElement errorMessage;
	
	@CacheLookup
	@FindBy(xpath="//tbody/tr[1]/td[4]/input[1]")
	WebElement emptyCartButton;
	
	@CacheLookup
	@FindBy(xpath="//h1[normalize-space()='Shopping Cart is Empty']")
	WebElement emptyCartMessage;
	
	//****************************Constructor*********************************
	
	public ShoppingCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//*************************Methods*****************************************
	
	
	public void changeQuantity()
	{
		 quantityField.clear();
		 quantityField.sendKeys("1000");
		 
	}
	
	public void clickOnUpdateButton()
	{
		updateButton.click();
	}
	public String getErrorMessage()
	{
		String error_msg = errorMessage.getText();
		return error_msg;
	}
	
	public void clickOnEmptyCart()
	{
		 emptyCartButton.click();
		 
	}
	
	public String getEmptyCartMessage()
	{
		String empty_cart_msg = emptyCartMessage.getText();
	
		return empty_cart_msg ;
	}

}
