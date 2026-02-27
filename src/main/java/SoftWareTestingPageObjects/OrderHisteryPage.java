package SoftWareTestingPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SoftwareTestingAbstrectCompaonents.AbstrectComponents;

public class OrderHisteryPage extends AbstrectComponents {
	WebDriver driver;
	
	public OrderHisteryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}

	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> listOfItems;

	public boolean verifyOrderDisplay(String name) throws InterruptedException {
   
		boolean v = listOfItems.stream().anyMatch(s -> s.getText().contains(name));
		return v;
	

	}

}
