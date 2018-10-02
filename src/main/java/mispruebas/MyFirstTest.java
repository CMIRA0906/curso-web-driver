package mispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MyFirstTest {
	
	
	public WebDriver driver;
	
	//Objetos del login
	By lnkLogin = By.linkText("Sign in");
	By txtUser = By.id("email");
	By txtPassword = By.id("passwd");
	By btnSinIn=By.id("SubmitLogin");
	
	/**
	 * Método para configurar y abrir el navegador
	 */
	public void abrirNavegador(){
		
		//Se define la propiedad del sistema con el driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		//Preferencias del navegador
		chromeOptions.addArguments("start-maximized","--incognito","disable-infobars");
		
		//Para ejecutar pruebas con chrome
		driver = new ChromeDriver(chromeOptions);
		//Para ejecutar pruebas con firefox
		//driver = new FirefoxDriver();
		
		//Para ejecutar pruebas con internet explorer
		//driver = new InternetExplorerDriver();
		
		
		
	}
	
	/**
	 * Método para hacer login
	 */
	public void hacerLogin(){
		
		//Abrir la página web
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(lnkLogin).click();
		driver.findElement(txtUser).clear();
		driver.findElement(txtUser).sendKeys("cristian.mira@sofka.com.co");
		driver.findElement(txtPassword).clear();
		driver.findElement(txtPassword).sendKeys("milagros0509*");
		driver.findElement(btnSinIn).click();
		driver.quit();
		System.out.println("Cerré y me voy");
				
		
	}
	
	/**
	 * Método para cerra el navegador
	 */
	public void cerrarNavegador(){
		
		if(driver!=null){
			driver.quit();
		}else {
		 System.out.println("No hay drivers con sesión activa");
		}
		
	}
	
	public static void main(String[] args) {
		
		MyFirstTest firstTest = new MyFirstTest();
		firstTest.abrirNavegador();
		firstTest.hacerLogin();
		
	}
	
	
	
	

}
