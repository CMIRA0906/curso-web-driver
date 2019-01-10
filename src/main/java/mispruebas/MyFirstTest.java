package mispruebas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyFirstTest {

	public static final String USERNAME = "cristianmira1";
	public static final String AUTOMATE_KEY = "yjfSF9yFgrjxe7is5z2f";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	private static final Logger LOGGER = LogManager.getLogger("Pruebas automatizadas: ");
	private WebDriver driver;


	By lnkLogin = By.linkText("Sign in");
	By txtUser = By.id("email");
	By txtPassword = By.id("passwd");
	By btnSinIn = By.id("SubmitLogin");
	
	public void abrirNavegador() {

	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized", "--incognito", "disable-infobars");

		
		driver = new ChromeDriver(chromeOptions);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

	
	}


	public void hacerLogin(WebDriver driver) {

	
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(lnkLogin).click();
		driver.findElement(txtUser).clear();
		driver.findElement(txtUser).sendKeys("cristian.mira@sofka.com.co");
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys("milagros0509*");
		driver.findElement(btnSinIn).click();
		driver.quit();
		LOGGER.info("Cerré y me voy");

	}


	public void cerrarNavegador() {

		if (driver != null) {
			driver.quit();
			System.out.println("Se cierra el navegador");
		} else {
			LOGGER.info("No hay drivers con sesión activa");
		}

	}

	public WebDriver getWebDriver() {

		return driver;
	}

	public void abrirNavegadorRemotoSauseLabs() throws MalformedURLException{
		
		DesiredCapabilities caps =  new DesiredCapabilities().chrome();
		caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "62.0");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1024x768");
	    
	    
	    driver = new RemoteWebDriver(new URL(URL),caps);
		
		
	}
	
public void abrirNavegadoEnDocker() throws MalformedURLException{
		
		DesiredCapabilities caps =  new DesiredCapabilities().chrome();

	    caps.setPlatform(Platform.LINUX);
	    
	    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
		
		
	}


}
