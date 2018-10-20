package mispruebas;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsExample {

	private WebDriver driver;

	public static final String URL_SAHI = "http://sahitest.com/demo/";

	By lnkWindowTest = By.linkText("Window Open Test");
	By lnkText = By.linkText("Alert Test");

	public void goToNewWindow() throws InterruptedException {

		MyFirstTest myFirstTest = new MyFirstTest();
		myFirstTest.abrirNavegador();
		driver = myFirstTest.getWebDriver();
		driver.get(URL_SAHI);
		// Identifico la primera ventana
		String windowParent = driver.getWindowHandle();
		System.out.println("Esta es la ventana inicial :" + windowParent);
		Thread.sleep(3000);
		driver.findElement(lnkWindowTest).click();
		// obtengo todas las ventanas
		Set<String> allWindows = driver.getWindowHandles();
		// Identificamos la segunda ventana
		String secondWindow = (String) allWindows.toArray()[1];
		System.out.println("Esta es la segunda ventana" + secondWindow);
		Thread.sleep(3000);
		// vamos a la segunda ventana
		driver.switchTo().window(secondWindow);
		//Vamos a cerrar la segunda ventana
		driver.close();
		//Volvemos a la primera ventana
		driver.switchTo().window(windowParent);
		MetodosComunes.hacerHighlight(driver, driver.findElement(lnkText));
		Thread.sleep(3000);
		driver.findElement(lnkText).click();
		
		Thread.sleep(5000);
		driver.quit();

	}
	
	public static void main(String[] args) throws InterruptedException {
		
		WindowsExample windowsExample =  new WindowsExample();
		windowsExample.goToNewWindow();
		
	}

}
