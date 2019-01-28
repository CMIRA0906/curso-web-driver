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

	private WebDriver driver;
	
	

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

	public void abrirNavegador() {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("start-maximized");
		chromeOptions.setHeadless(false);

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
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(btnCrearCuenta)));

		} catch (Exception e) {

			System.out.println("No se encontró nada");
		}

	}

	public WebDriver getWebDriver() {
		return driver;
	}

}
