package guru99.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import guru99.base.BaseTest;

public class SonyXperiaMobilePage extends BaseTest {
	
	
	 @FindBy (xpath="//span[contains(text(),'$100.00')]")
	WebElement sonyXperiaMainPagePrice;
	
	
	
	
	
	
	//**************************** Constructor*********************************** 
	public SonyXperiaMobilePage () 
	{
		PageFactory.initElements(driver, this);
	}

	//**************************** Methods*********************************** 
	
	public String sonyxperiaDetailPagePrice()
	{
		String detailPagePrice = sonyXperiaMainPagePrice.getText();
		return detailPagePrice;
	}
	

	
}
