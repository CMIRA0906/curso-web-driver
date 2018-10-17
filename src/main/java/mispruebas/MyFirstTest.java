package mispruebas;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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

	public WebDriver driver;

	// Objetos del login
	By lnkLogin = By.linkText("Sign in");
	By txtUser = By.id("email");
	By txtPassword = By.id("passwd");
	By btnSinIn = By.id("SubmitLogin");

	/**
	 * M�todo para configurar y abrir el navegador
	 */
	public void abrirNavegador() {

		// Se define la propiedad del sistema con el driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		// Preferencias del navegador
		chromeOptions.addArguments("start-maximized", "--incognito", "disable-infobars");

		// Para ejecutar pruebas con chrome
		driver = new ChromeDriver(chromeOptions);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// Para ejecutar pruebas con firefox
		// driver = new FirefoxDriver();

		// Para ejecutar pruebas con internet explorer
		// driver = new InternetExplorerDriver();

	}

	/**
	 * M�todo para hacer login
	 */
	public void hacerLogin(WebDriver driver) {

		// Abrir la p�gina web
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(lnkLogin).click();
		driver.findElement(txtUser).clear();
		driver.findElement(txtUser).sendKeys("cristian.mira@sofka.com.co");
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys("milagros0509*");
		driver.findElement(btnSinIn).click();
		driver.quit();
		System.out.println("Cerr� y me voy");

	}

	/**
	 * M�todo para cerra el navegador
	 */
	public void cerrarNavegador() {

		if (driver != null) {
			driver.quit();
			System.out.println("Se cierra el navegador");
		} else {
			System.out.println("No hay drivers con sesi�n activa");
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

	public static void main(String[] args) {

		MyFirstTest firstTest = new MyFirstTest();
		firstTest.abrirNavegador();
		firstTest.hacerLogin(firstTest.getWebDriver());

	}

}
