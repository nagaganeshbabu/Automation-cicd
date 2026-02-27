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
	

}
