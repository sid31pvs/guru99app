package guru99.websiteTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import guru99.base.BaseClass;
import guru99.base.BaseTest;
import guru99.objectRepository.HomePage;
import guru99.objectRepository.MobilePage;
import junit.framework.Assert;

public class MobileSortingTest extends BaseTest {
	HomePage homepage;
	Logger log;
	MobilePage mobilepage;

	public MobileSortingTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		log = LogManager.getLogger(MobileSortingTest.class.getName());
		log.debug("Web Browser has started");
		log.debug("Web page got maximized");
		homepage = new HomePage();
		mobilepage = homepage.clickOnMobileMenu();
		mobilepage.sortingMobileByName();
	}

	@Test(priority = 1)
	public void verifyTitleOfPageTest() {
		String title = homepage.verifyTitleOfPage();
		log.debug("Vefified the page title");
		Assert.assertEquals("THIS IS DEMO SITE FOR", title, "Title is not matching with expected title");
	}

	@Test(priority = 2)
	public void clickOnMobilemenuTest() {
		mobilepage = homepage.clickOnMobileMenu();
		log.info("clicked on mobile menu");
	}

	@Test(priority = 3)
	public void verifyTitleOfMobilePageTest() {
		String title = mobilepage.verifyTitleOfMobilePage();
		log.info("Title of the page " + title);
		Assert.assertEquals("Mobile", title);
	}

	@Test(priority = 4)
	public void selectDropDownByName() {
		mobilepage.sortingMobileByName();
		log.info("mobiles are sorted by name");
		mobilepage.VerifyMobileSortByName();
		log.info("Screenshot has been taken");
	}

	@AfterMethod
	public void closure() {

		driver.close();
		log.info("Web Browser closed");
	}
}
