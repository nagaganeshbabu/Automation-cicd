package SoftWareTestingPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTestingAbstrectCompaonents.AbstrectComponents;

public class ConformationPage extends AbstrectComponents {
	
	
	WebDriver driver;
	public ConformationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	@FindBy (css= ".hero-primary")
	WebElement message;
	
	
	
	
	public String testmessage() {
	//String finalMessage =	message.getText();
		
		return message.getText();
	}

}
