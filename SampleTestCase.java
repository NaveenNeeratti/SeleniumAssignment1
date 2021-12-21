import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class SampleTestCase {
	WebDriver driver;
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","C:\\GeckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@Test
	void test() {
		String baseUrl = "https://iamneo.ai";
		driver.get(baseUrl);
		String title = driver.getTitle();
		String expected = "We Are Hiring";
		if(title.equals(expected)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIl");
		}
		driver.navigate().to("https://www.facebook.com");
		driver.navigate().back();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	@AfterEach
	void tearDown() throws Exception {
			driver.close();
	}

}
