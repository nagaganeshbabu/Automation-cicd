package SoftwareTesting.NewSeleniumFrameWork;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SoftWareTestingPageObjects.CartPage;
import SoftWareTestingPageObjects.CheckOutPagechek;
import SoftWareTestingPageObjects.ConformationPage;
import SoftWareTestingPageObjects.OrderHisteryPage;
import SoftWareTestingPageObjects.productCatlogPage;
import SoftwareTest.Componts.BaseTest;
   

public class SubmitOrder extends BaseTest {
	
	String PPPP = "ADIDAS ORIGINAL";
	@Test (dataProvider = "getData", groups = {"purches"})
	public void orderProduct(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		productCatlogPage productCatlogPage = LandingPage.loginPage(input.get("email") , input.get("password"));
		productCatlogPage.productsItems(input.get("name"));
		productCatlogPage.addToCart(input.get("name"));
		CartPage CartPage = productCatlogPage.goToCart();
		boolean check = CartPage.chekItemsInCart(input.get("name"));
		Assert.assertTrue(check);
		CheckOutPagechek CheckOutPagechek = CartPage.checkOutPage();
		CheckOutPagechek.sendInputs("India", "123654", "rahulshettyacademy");
		
		ConformationPage ConformationPage = CheckOutPagechek.palceOrder();
		String f = ConformationPage.testmessage();
		Thread.sleep(1000);
		Assert.assertTrue(f.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(f);
		//driver.close();
	
	}
	
//	@Test(dependsOnMethods= {"orderProduct"}, dataProvider = "getData")
//	public void orderHistoryTest() throws InterruptedException {
//		productCatlogPage productCatlogPage = LandingPage.loginPage("testing1212@gmail.com", "Naga@1212");
//		OrderHisteryPage OrderHisteryPage = productCatlogPage.orderHistory();
//		
//	    Assert.assertTrue(OrderHisteryPage.verifyOrderDisplay(PPPP));	
//	}
//	
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		
	List<HashMap<String, String>> data = 	getData(System.getProperty("user.dir") + "\\src\\test\\java\\SoftwareTestung\\Data\\purchaseOrder.json");		
		return new  Object[][] {{ data.get(0)}, { data.get(1)}};
		
	}
	
//	HashMap<String, String> map = new HashMap<String, String>();
//	map.put("email", "testing1212@gmail.com");
//	map.put("paswd", "Naga@1212");
//	map.put("name", "IPHONE 13 PRO");
//	
//	HashMap<String, String> map1 = new HashMap<String, String>();
//	map1.put("email", "testing121212@gmail.com");
//	map1.put("paswd", "Naga@1212");
//	map1.put("name","ADIDAS ORIGINAL");

}

//just cheking cicd here weather it is working or not 
//here we are checking file 


