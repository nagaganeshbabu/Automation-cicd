package SoftWareTestingPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTestingAbstrectCompaonents.AbstrectComponents;


public class CartPage extends AbstrectComponents {
	
	WebDriver driver;
	
	public CartPage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (css =".cartWrap h3")
	List<WebElement> products;
	
	@FindBy(xpath = "//button[text()=\"Checkout\"]")
	WebElement checkout;	
	public boolean chekItemsInCart(String name) {
		
		boolean check = products.stream().anyMatch(s -> s.getText().equalsIgnoreCase(name));
		return check;
	}
	
	public CheckOutPagechek checkOutPage() {
		
		checkout.click();
		
		CheckOutPagechek CheckOutPagechek = new CheckOutPagechek(driver);
		return CheckOutPagechek;
	}
	
	
	
	
	
	
//	List<WebElement> products = driver.findElements(By.cssSelector(".cartWrap h3"));
//
//	boolean check = products.stream().anyMatch(s -> s.getText().equalsIgnoreCase(name));
//
//	Assert.assertTrue(check);
//
//	driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();

}
