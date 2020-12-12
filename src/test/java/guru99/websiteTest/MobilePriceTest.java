package guru99.websiteTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import guru99.base.BaseTest;
import guru99.objectRepository.HomePage;
import guru99.objectRepository.MobilePage;
import guru99.objectRepository.SonyXperiaMobilePage;

public class MobilePriceTest extends BaseTest {
	HomePage homepage;
	Logger log;
	MobilePage mobilepage;
	String sonyXperiaprice;
	SonyXperiaMobilePage detailpageOfSonyXperia;
	
	
	public  MobilePriceTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		log = LogManager.getLogger(MobilePriceTest.class.getName());
		initialization();
		log.info("Browser has started Successfully");
		
		 homepage=new HomePage();
		 mobilepage=homepage.clickOnMobileMenu();
		
	}
	
	@Test(priority=1)
	public void clickOnMobileMenu()
	{
		MobilePage mobilepage=homepage.clickOnMobileMenu();
		log.info("clicked on mobile menu");
	}
	
	@Test(priority=2)
	public void readSonyXperiaMobileCost()
	{
	 sonyXperiaprice = mobilepage.getSonyxperiaMobilePrice();
	 log.info("price of sony Xperia on mobile page is : "+ sonyXperiaprice);
	}

	@Test(priority=3)
	public void clickOnsonyXperiaMobile()
	{
		 detailpageOfSonyXperia=mobilepage.clickOnSonyXperiaMobile();
		 log.info("clicked on sony Xperia mobile");
			String sonyXperiaMainpagePrice = detailpageOfSonyXperia.sonyxperiaDetailPagePrice();
			log.info("price of sony xperia on detail page is : "+sonyXperiaMainpagePrice);
			Assert.assertEquals(sonyXperiaprice, sonyXperiaMainpagePrice);
			log.info("price of sony xperia is same on mobile page and details page");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		log.debug("browser is closed successfully");
	}
}
