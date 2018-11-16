package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

	public WebDriver driver;
	
	public static final String USERNAME = "cristianmira1";
	public static final String AUTOMATE_KEY = "yjfSF9yFgrjxe7is5z2f";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	@Parameters({ "browser" })
	@BeforeTest
	public void abrirNavegador(String browser) throws MalformedURLException {

		if ("chrome".equals(browser)) {

			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

			ChromeOptions chromeOptions = new ChromeOptions();
			// Preferencias del navegador
			chromeOptions.addArguments("start-maximized", "--incognito", "disable-infobars");

			// Para ejecutar pruebas con chrome
			driver = new ChromeDriver(chromeOptions);

		} else if ("remoto".equals(browser)) {
			
			DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
			
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.ANY);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		} else {
	
				DesiredCapabilities caps =  new DesiredCapabilities().chrome();
				caps.setCapability("browser", "Chrome");
			    caps.setCapability("browser_version", "62.0");
			    caps.setCapability("os", "Windows");
			    caps.setCapability("os_version", "10");
			    caps.setCapability("resolution", "1024x768");
			   			    
			    driver = new RemoteWebDriver(new URL(URL),caps);


		}
		// Se define la propiedad del sistema con el driver

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	}

	@AfterTest
	public void cerrarNavegador() {

		if (driver != null) {
			driver.quit();
			System.out.println("Se cierra el navegador");
		} else {
			System.out.println("No hay drivers con sesión activa");
		}

	}

}
