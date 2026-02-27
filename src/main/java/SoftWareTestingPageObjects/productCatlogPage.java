package SoftWareTestingPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTestingAbstrectCompaonents.AbstrectComponents;

public class productCatlogPage extends AbstrectComponents {

	WebDriver driver;;

	public productCatlogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> product;
//
//	@FindBy(css = ".ng-animating")
//	WebElement invisable;
	By invisibleLoader = By.cssSelector(".ng-animating");
   
	By addCart = By.cssSelector(".w-10");

	By Visable = By.cssSelector(".toast-container");

	public WebElement productsItems(String name) {

		WebElement value = product.stream().filter(s -> s.findElement(By.cssSelector(".mb-3 b")).getText().equals(name))
				.findFirst().orElse(null);

		return value;

	}

	public void addToCart(String name) throws InterruptedException   {
		// TODO Auto-generated method stub
		WebElement i = productsItems(name);
		WebElement addToCart = i.findElement(By.cssSelector(".w-10"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addToCart);	
//		waitForVisible(Visable);
//	    waitForElementToDisappear(invisibleLoader);
		Thread.sleep(2000);

	}

}
