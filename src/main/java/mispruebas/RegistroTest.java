package mispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class RegistroTest {

	// Se instancia de la clase webdriver
	public WebDriver driver;

	By linkLogin = By.cssSelector("div>.login");
	By txtEmailNuevo = By.id("email_create");
	By btnCrearCuenta = By.id("SubmitCreate");
	By rBtnGeneroHombre = By.cssSelector("div>span>#id_gender1");
	By rBtnGeneroMujer = By.id("uniform-id_gender2");
	By txtNombreUsu = By.id("customer_firstname");
	By txtApellidoUsu = By.id("customer_lastname");
	By txtEmail = By.id("email");
	By password = By.id("passwd");
	By listDias = By.id("days");
	By listMeses = By.id("months");
	By listAnios = By.id("years");
	By txtNombreCorreo = By.id("firstname");
	By txtApellidoCorreo = By.id("lastname");
	By txtEmpresa = By.id("company");
	By txtDireccion = By.id("address1");
	//Ojo el registro no está completo

	public void abrirNavegador() {

		// Se agrega propiedad que contiene el driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		// Se agregan preferencias del navegador
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		chromeOptions.setHeadless(false);

		// Se crea una instancia de la clase del driver a usar
		driver = new ChromeDriver(chromeOptions);

	}

	public void abrirPaginaWeb() {

		driver.get("http://automationpractice.com ");
	}

	public void registrarUsuario() throws Exception {

		driver.findElement(linkLogin).click();
		driver.findElement(txtEmailNuevo).sendKeys("cmira0905@gmail.com");
		driver.findElement(btnCrearCuenta).click();

		Thread.sleep(5000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(rBtnGeneroHombre));

		System.out.println("Nada que encuentra objet" + driver.findElement(rBtnGeneroHombre).isDisplayed());

		driver.findElement(rBtnGeneroHombre).click();
		driver.findElement(txtNombreUsu).sendKeys("Cristian");
		driver.findElement(txtApellidoUsu).sendKeys("Mira");
		driver.findElement(password).sendKeys("matrix123");
		Select listDia = new Select(driver.findElement(listDias));
		listDia.selectByValue("6");

	}

	public void esperaExplicita() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 7000);
			// System.out.println("Se recibe
			// esto"+driver.findElement(rBtnGeneroHombre).getLocation());
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(btnCrearCuenta)));

		} catch (Exception e) {

			System.out.println("No se encontró nada");
			// TODO: handle exception
		}

	}
	
	public WebDriver getWebDriver(){
		return driver;
	}


	public static void main(String[] args) throws Exception {
		RegistroTest test = new RegistroTest();
		test.abrirNavegador();
		test.abrirPaginaWeb();
		test.registrarUsuario();

	}

}
