package SoftwareTesting.NewSeleniumFrameWork;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SoftWareTestingPageObjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		String name = "ZARA COAT 3";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
		driver.findElement(By.id("userEmail")).sendKeys("testing1212@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Naga@1212");
		driver.findElement(By.id("login")).click();
		
		
		
		List<WebElement> items = driver.findElements(By.cssSelector(".mb-3"));
		WebElement value = items.stream().filter(s -> s.findElement(By.cssSelector(".mb-3 b")).getText().equals(name))
				.findFirst().orElse(null);

		
		
		WebElement addToCart = value.findElement(By.cssSelector(".w-10"));

		// Use JavaScript to click instead of the standard .click()
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addToCart);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".w-10")));
		//value.findElement(By.cssSelector(".w-10")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".cartWrap h3"));

		boolean check = products.stream().anyMatch(s -> s.getText().equalsIgnoreCase(name));

		Assert.assertTrue(check);

		driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ng-touched")));

		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");

		driver.findElement(By.xpath("//button[@type = 'button'] [2]")).click();

		driver.findElement(By.xpath("(//input[@class='input txt']) [1]")).sendKeys("123654");

		driver.findElement(By.xpath("(//input[@type = 'text'])[4]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".btn.btn-primary.mt-1")).click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-trigger-fadeIn"))));

		driver.findElement(By.cssSelector(".btnn")).click();
		
		
		String f = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		System.out.println(f);
		
		Assert.assertTrue(f.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	
		

		//driver.findElement(By.cssSelector("label[routerlink='/dashboard/myorders']")).click();

		//List<WebElement> finalproduct = driver.findElements(By.xpath("//tbody/tr/td[2]"));

		//boolean v = finalproduct.stream().anyMatch(s -> s.getText().contains(name));

		//Assert.assertTrue(v);

	}

}
