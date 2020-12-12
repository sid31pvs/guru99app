package guru99.objectRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import guru99.base.BaseClass;
import guru99.base.BaseTest;

public class MobilePage extends BaseTest {

	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement mobileMenu;

	@FindBy(xpath = "//body/div[@class='wrapper']/div[@class='page']/div[@class='main-container col3-layout']/div[@class='main']/div[@class='col-wrapper']/div[@class='col-main']/div[@class='category-products']/div[@class='toolbar']/div[@class='sorter']/div[@class='sort-by']/select[1]")
	WebElement selectDropDown;

	@FindBy(xpath = "//span[contains(text(),'$100.00')]")
	WebElement sonyXperiaMobilePrice;
	
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/h2[1]/a[1]")
	WebElement sonyXperiaMobile;
	
	@FindBy(xpath="//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[3]/button[1]")
	WebElement SonyXperiaAddToCartButton;
	

//**************************** Constructor*********************************** 
	public MobilePage() {
		PageFactory.initElements(driver, this);

	}

	// **************************** Methods***********************************
	
	
	public String verifyTitleOfMobilePage() {
		return driver.getTitle();
	}

	public void sortingMobileByName() {
		Select select = new Select(selectDropDown);
		select.selectByVisibleText("Name");
	}

	public void VerifyMobileSortByName() {
		String path = System.getProperty("user.dir");
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File(path + "\\screenshot\\" + "mobileSortedByname" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getSonyxperiaMobilePrice()
	{
		 String sonyXperiaPrice = sonyXperiaMobilePrice.getText();
		 return sonyXperiaPrice;
	}
	
	public SonyXperiaMobilePage clickOnSonyXperiaMobile()
	{
		sonyXperiaMobile.click();
		return new SonyXperiaMobilePage();
	}
	
	public ShoppingCartPage clickOnSonyXperiaAddToCartButton()
	{
		SonyXperiaAddToCartButton.click();
		return new ShoppingCartPage();
	}
	
}
