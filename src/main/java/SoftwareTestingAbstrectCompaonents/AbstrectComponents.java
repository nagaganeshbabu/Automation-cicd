package SoftwareTestingAbstrectCompaonents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SoftWareTestingPageObjects.CartPage;
import SoftWareTestingPageObjects.OrderHisteryPage;

public class AbstrectComponents {

	WebDriver driver;

	@FindBy(css = "button[routerlink=\"/dashboard/cart\"]")
	WebElement cartbutton;

	@FindBy(css = ".hero-primary")
	WebElement confText;
	@FindBy (css ="button[routerlink='/dashboard/myorders")
	WebElement OrderHistory;
	
	public AbstrectComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void waitForVisible(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
	
	public void waitForElementToDisappear(By findBy) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

//	public void waitForTheElementget(WebElement findBy) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(findBy));
//
//	}

	public void invisableelement(WebElement invisable) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOf(invisable));
	}

	public CartPage goToCart() {
		cartbutton.click();

		CartPage CartPage = new CartPage(driver);
		return CartPage;

	}
	
	public OrderHisteryPage orderHistory() {
		
		OrderHistory.click();
		
		OrderHisteryPage OrderHisteryPage = new OrderHisteryPage(driver);
		
		return OrderHisteryPage;
			
		}
	
	}
	
	




// Justing to know that what is changeing and know that is it working or not

	
	
	
	
	
	
	
	
	
	
	


