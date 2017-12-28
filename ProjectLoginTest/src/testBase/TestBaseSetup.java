package testBase;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;

public class TestBaseSetup {

	public static WebDriver driver;//mukitheclipse\ProjectLoginTest\Drivers
	public static String driverPath = "C:\\mukitheclipse\\ProjectLoginTest\\Drivers\\";

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(String browserType, String appURL) throws InterruptedException {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
		//	driver = initFirefoxDriver(appURL);
		}
	}

	public static WebDriver initChromeDriver(String appURL) throws InterruptedException {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		//Thread.sleep(2000);
		return driver;
	}

	public static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.navigate().to(appURL);
		return driver;
	}
	
	public void closeBrowser(){
		driver.quit();
	}
}
