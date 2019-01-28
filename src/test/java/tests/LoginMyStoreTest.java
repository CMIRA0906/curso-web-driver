package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest;
import common.ReadExcelData;
import common.Utilities;
import constantes.Constantes;

public class LoginMyStoreTest extends BaseTest {

	By lnkSingIn = By.cssSelector("a.login");
	By txtEmail = By.id("email");
	By txtPassword = By.id("passwd");
	By btnLogin = By.id("SubmitLogin");
	By lnkUsuario = By.cssSelector("a[title='View my customer account']");
	By singOut = By.className("logout");

	// @Test
	// public void hecerLogin() throws IOException, InterruptedException{
	//
	// driver.get(ConstantesPruebas.URL_MY_STORE);
	// Utilidades.tomarEvidencia(driver);
	//
	// DataPropertiesManagement2 dataPropertiesManagement2 = new
	// DataPropertiesManagement2();
	// Properties properties = dataPropertiesManagement2.getProperties();
	//
	// driver.findElement(lnkSingIn).click();
	// WebDriverWait wait = new WebDriverWait(driver,15);
	// wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmail));
	//
	// driver.findElement(txtEmail).sendKeys(properties.getProperty("user"));
	//
	// driver.findElement(txtPassword).sendKeys(properties.getProperty("password"));
	// driver.findElement(btnLogin).click();
	// Assert.assertEquals(driver.findElement(lnkUsuario).getText(),"Cristian
	// Mira");
	//
	//
	// }

	@Test(dataProvider = "getDatosPrueba", dataProviderClass = ReadExcelData.class)
	public void hecerLogin(String usuario, String clave) throws IOException, InterruptedException {

		driver.get(Constantes.URL_MY_STORE);

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lnkSingIn));

		Utilities.tomarEvidencia(driver);

		driver.findElement(lnkSingIn).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmail));

		driver.findElement(txtEmail).sendKeys(usuario);

		driver.findElement(txtPassword).sendKeys(clave);
		driver.findElement(btnLogin).click();
		Utilities.tomarEvidencia(driver);
		Assert.assertEquals(driver.findElement(lnkUsuario).getText(), "Cristian Mira");
		driver.findElement(singOut).click();

	}

}
