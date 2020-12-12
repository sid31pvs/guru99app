package guru99.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import guru99.base.BaseClass;
import guru99.base.BaseTest;

public class HomePage extends BaseTest {

	
	
	@FindBy(xpath="//a[contains(text(),'Mobile')]")
	WebElement mobileMenu;
	
	@FindBy(xpath="//a[contains(text(),'TV')]")
	WebElement TVMenu;
	
	@FindBy(xpath="//header/div[1]/div[2]/div[1]/a[1]/span[2]")
	WebElement AccountMenu;
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public MobilePage clickOnMobileMenu()
	{
		mobileMenu.click();
		return new MobilePage();
	}
	
	public String verifyTitleOfPage()
	{
		return driver.getTitle();
	}
	
}
