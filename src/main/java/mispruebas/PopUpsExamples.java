package mispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PopUpsExamples {

	MyFirstTest myTest = new MyFirstTest();

	WebDriver driver;

	By lnkAlertText = By.linkText("Alert Test");
	By lnkConfirmPage = By.linkText("Confirm Page");
	By lnkPromptPage = By.linkText("Prompt Page");
	By btnClicAlert = By.name("b1");

	public void clickAlertAccept() {

		myTest.abrirNavegador();
		driver = myTest.getWebDriver();
		driver.get(Constantes.URL_PRUEBAS);
		driver.findElement(lnkAlertText).click();
		driver.findElement(btnClicAlert).click();
		// Da clic en la opción aceptar de la alerta
		driver.switchTo().alert().accept();
		myTest.cerrarNavegador();

	}

	public void clickAlertDismiss() {

		myTest.abrirNavegador();
		driver = myTest.getWebDriver();
		driver.get(Constantes.URL_PRUEBAS);
		driver.findElement(lnkConfirmPage).click();
		driver.findElement(btnClicAlert).click();
		// Da clic en la opción cancelar de la alerta
		driver.switchTo().alert().dismiss();
		myTest.cerrarNavegador();

	}
	
	public void sendTextInAlert(){

		myTest.abrirNavegador();
		driver = myTest.getWebDriver();
		driver.get(Constantes.URL_PRUEBAS);
		driver.findElement(lnkPromptPage).click();
		driver.findElement(btnClicAlert).click();
		// Envia información en el textBox 
		driver.switchTo().alert().sendKeys("Test.....");
		driver.switchTo().alert().accept();
		

	}
	
	
	public void waitAlertIsPresent(){

		myTest.abrirNavegador();
		driver = myTest.getWebDriver();
		driver.get(Constantes.URL_PRUEBAS);
		driver.findElement(lnkAlertText).click();
		driver.findElement(btnClicAlert).click();
		//Se instancia objeto WebDriverWait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent()); 
		
		driver.switchTo().alert().accept();
		myTest.cerrarNavegador();

	}
	
	
	
	
	
	
	

}
