package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class BaseTest {

	public WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeTest
	public void abrirNavegador() {
		// Se define la propiedad del sistema con el driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		// Preferencias del navegador
		chromeOptions.addArguments("--headless","start-maximized", "--incognito", "disable-infobars");

		// Para ejecutar pruebas con chrome
		driver = new ChromeDriver(chromeOptions);

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
