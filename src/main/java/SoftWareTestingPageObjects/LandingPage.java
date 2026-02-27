package SoftWareTestingPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTestingAbstrectCompaonents.AbstrectComponents;



public class LandingPage  extends AbstrectComponents{
	
	
//	driver.findElement(By.id("userEmail")).sendKeys("testing1212@gmail.com");
//	driver.findElement(By.id("userPassword")).sendKeys("Naga@1212");
//
//	driver.findElement(By.id("login")).click();
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
		
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy (css = "div[class*='ng-trigger-flyInOut']")
	WebElement message;
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");

	}
	
	public productCatlogPage loginPage(String usermail, String pasword) {
		userEmail.sendKeys(usermail);
		userPassword.sendKeys(pasword);
		login.click();
		productCatlogPage productCatlogPage = new productCatlogPage(driver);
		return productCatlogPage;
		

		
	}
	
	
	public String errorMessage() {
		
//		waitForTheElementget(message);
		return message.getText();
		
	}
	

}
