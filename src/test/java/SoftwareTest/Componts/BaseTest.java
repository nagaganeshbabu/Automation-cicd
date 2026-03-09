package SoftwareTest.Componts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SoftWareTestingPageObjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage LandingPage;

	public WebDriver InitilalizeDriver() throws IOException {
//		
//		System.setProperty("selenium.manager.skip", "true");
//
//		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
//		System.setProperty("webdriver.edge.driver", "C:\\SeleniumDrivers\\msedgedriver.exe");

		Properties pro = new Properties();
		FileInputStream file = new FileInputStream(
		System.getProperty("user.dir") + "//src//main//java//SoftwareTesting//Resources//Golbal.properties");
		pro.load(file);
		
		String browserName =System.getProperty("browser") != null ? System.getProperty("browser") : pro.getProperty("browser") ;
		//String browserName = pro.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
        
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
		    FirefoxOptions options = new FirefoxOptions();
		    options.addArguments("--headless");   // THIS IS THE FIX

		    driver = new FirefoxDriver(options);

		} else if (browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
		    options.addArguments("--headless");   
			driver = new EdgeDriver(options);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1920, 1080));

		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage lunchApplication() throws IOException {

		driver = InitilalizeDriver();
		LandingPage = new LandingPage(driver);
		LandingPage.goTo();

		return LandingPage;

	}
	
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = 	ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		}

//	@AfterMethod
//	public void close() {
//		driver.close()
//	}
	 public List<HashMap<String, String>> getData(String adders) throws IOException {
	String jsonData = 	FileUtils.readFileToString(new File(adders),
			StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
	
	List<HashMap<String , String>> data = mapper.readValue(jsonData, new TypeReference<List <HashMap<String,String>>>(){});
	return data;
	
	 }

}

// here we can find Commam thing that we what to use 

// here  i am adding to check cicd is working or not

