package mispruebas;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PracticaWindowFramePopups {

	WebDriver driver;

	By linkWindow = By.cssSelector("a[target=_blank]");
	By lnkFrame = By.linkText("Frames Test");
	By lnkAlertText = By.linkText("Alert Test");
	By btnClickAlertText = By.name("b1");
	By lnkConfirmPage = By.linkText("Confirm Page");
	By lnkPromptPage  = By.linkText("Prompt Page");

	public void practicing() {

		MyFirstTest myFirstTest = new MyFirstTest();
		myFirstTest.abrirNavegador();
		driver = myFirstTest.getWebDriver();
		driver.get(WindowsExample.URL_SAHI);
		String windowParent = driver.getWindowHandle();
		LogTest.imprimirMensaje("Es el handled de la ventana inicial: " + windowParent);
		driver.findElement(linkWindow).click();
		Set<String> AllWindows = driver.getWindowHandles();
		String secondWindow = (String) AllWindows.toArray()[1];
		driver.switchTo().window(secondWindow);
		driver.switchTo().frame(0);
		driver.findElement(lnkConfirmPage).click();
		driver.findElement(btnClickAlertText).click();
		driver.switchTo().alert().accept();
		driver.close();
		driver.switchTo().window(windowParent);
		driver.findElement(lnkAlertText).click();
		driver.findElement(btnClickAlertText).click();
		String textAlert= driver.switchTo().alert().getText();
		LogTest.imprimirMensaje("Este es el texto de la alerta: "+textAlert);
		driver.quit();
		

	}

}
