package SoftWareTestingPageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SoftwareTestingAbstrectCompaonents.AbstrectComponents;

public class CheckOutPagechek extends AbstrectComponents {
	
	
	
	WebDriver driver;
	public CheckOutPagechek(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (css ="input[placeholder='Select Country']")
	WebElement countery;
	
	@FindBy (xpath ="//button[@type = 'button'] [2]")
	WebElement selectCounter;
	
	@FindBy (xpath ="(//input[@class='input txt']) [1]")
	WebElement cvvas;
	
	@FindBy (css ="input[name=\"coupon\"]")
	WebElement promoCode;
	
	@FindBy (css =".btn.btn-primary.mt-1")
	WebElement promoApply;
	
	@FindBy(css =".btnn")
	WebElement PlaceOrder;
	
    @FindBy  (css = ".ng-trigger-fadeIn")
    WebElement Invisabl;
	
	//By Invisabl= By.cssSelector(".ng-trigger-fadeIn");
	@FindBy (css = ".ngx-spinner-overlay")
   WebElement invss ;

	public void  sendInputs(String country , String cvv,String promo) {
		
		
		countery.sendKeys(country);
		selectCounter.click();
		cvvas.sendKeys(cvv);
		//promoCode.sendKeys(promo);
		//promoApply.click();
		
		//invisableelement(Invisabl);
		
				
	}
	
	public ConformationPage palceOrder() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//		waitForTheElementget(PlaceOrder);
//	    invisableelement(invss);

	    wait.until(ExpectedConditions.elementToBeClickable(PlaceOrder));
		
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", PlaceOrder);
	    js.executeScript("arguments[0].click();", PlaceOrder);
		ConformationPage ConformationPage = new ConformationPage(driver);
		
		return  ConformationPage;
		
	}
	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	invisableelement(invss);
//	waitForTheElementget(PlaceOrder);
//    wait.until(ExpectedConditions.elementToBeClickable(PlaceOrder));
//	
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("arguments[0].scrollIntoView(true);", PlaceOrder);
//    js.executeScript("arguments[0].click();", PlaceOrder);


}
