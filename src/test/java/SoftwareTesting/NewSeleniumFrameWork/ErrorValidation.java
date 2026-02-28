package SoftwareTesting.NewSeleniumFrameWork;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import SoftWareTestingPageObjects.CartPage;
import SoftWareTestingPageObjects.CheckOutPagechek;
import SoftWareTestingPageObjects.ConformationPage;
import SoftWareTestingPageObjects.productCatlogPage;
import SoftwareTest.Componts.BaseTest;
import SoftwareTest.Componts.Retry;

public class ErrorValidation extends BaseTest {

	@Test(groups = {"ErrorHandling"} , retryAnalyzer=Retry.class)
	public void errorLogins() {
		
		LandingPage.loginPage("testing1212@gmail.com", "Naga@112");
		
		System.out.println(LandingPage.errorMessage());

		Assert.assertEquals("Incorrect email or password.", LandingPage.errorMessage());
		

	}
	
	@Test
	
	public void errorItem() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String name = "ZARA COAT 3";
		productCatlogPage productCatlogPage = LandingPage.loginPage("testing121212@gmail.com", "Naga@1212");
		productCatlogPage.productsItems(name);
		productCatlogPage.addToCart(name);
		CartPage CartPage = productCatlogPage.goToCart();

		boolean check = CartPage.chekItemsInCart("ZARA COAT 33");
		Assert.assertFalse(check);
		

	}
	
	//Ganesh Naga Here 
	
	
	// Here it is the Develpo batach 
	
	// Again i am chnage  something to know more 
	

}
