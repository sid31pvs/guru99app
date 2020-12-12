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
import guru99.objectRepository.ShoppingCartPage;

public class VerifyCartQuantityTest extends BaseTest {
	HomePage homepage;
	MobilePage mobilepage;
	ShoppingCartPage shoppingCart;

	public VerifyCartQuantityTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.debug("Webpage has maximized");
		

	}

	@Test(priority = 1)
	public void clickOnMobileMenu() {
		homepage = new HomePage();
		mobilepage = homepage.clickOnMobileMenu();
		log.info("clicked on mobile menu");
	}

	@Test(priority = 2)
	public void clickOnAddToCartButton() {
		homepage = new HomePage();
		mobilepage = homepage.clickOnMobileMenu();
		shoppingCart = mobilepage.clickOnSonyXperiaAddToCartButton();
		log.info("clicked on add to cart button");
	}

	@Test(priority = 3)
	public void changeProductQuantity() {
		homepage = new HomePage();
		mobilepage = homepage.clickOnMobileMenu();
		log.info("clicked on mobile menu");
		
		shoppingCart = mobilepage.clickOnSonyXperiaAddToCartButton();
		log.info("clicked on add to cart button");
		
		shoppingCart.changeQuantity();
		log.info("changed mobile quantity from 1 to 100");
		
		shoppingCart.clickOnUpdateButton();
		log.info("clicked on update button");

		String err_msg = shoppingCart.getErrorMessage();
		log.info("verifying error message is " + err_msg);
		
		Assert.assertEquals(err_msg, "The requested quantity for \"Sony Xperia\" is not available",
				"Orignal Error message is not matching with Expected error message");
	}

	@Test(priority = 4)
	public void clickOnEmptyCartButton() throws InterruptedException {
		homepage = new HomePage();
		mobilepage = homepage.clickOnMobileMenu();
		log.info("clicked on mobile menu");
		
		shoppingCart = mobilepage.clickOnSonyXperiaAddToCartButton();
		log.info("clicked on add to cart button");
		
		shoppingCart.changeQuantity();
		log.info("changed mobile quantity from 1 to 100");
		
		shoppingCart.clickOnUpdateButton();
		log.info("clicked on update button");
		
		shoppingCart.clickOnEmptyCart();
		log.info("clicked on empty cart button");
		Thread.sleep(2000);
		
		String emptyCart_msg = shoppingCart.getEmptyCartMessage();
		log.debug("showing empty cart message is "+emptyCart_msg);
		Assert.assertEquals(emptyCart_msg, "SHOPPING CART IS EMPTY");
		log.info("Both title are matching");
	}

	@AfterMethod
	public void tearDown() {
		closure();
		log.debug("Browser closed successfully");
	}
}
