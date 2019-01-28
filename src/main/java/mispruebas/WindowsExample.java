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
		String windowParent = driver.getWindowHandle();
		System.out.println("Esta es la ventana inicial :" + windowParent);
		Thread.sleep(3000);
		driver.findElement(lnkWindowTest).click();
		Set<String> allWindows = driver.getWindowHandles();
		String secondWindow = (String) allWindows.toArray()[1];
		System.out.println("Esta es la segunda ventana" + secondWindow);
		Thread.sleep(3000);
		driver.switchTo().window(secondWindow);
		driver.close();
		driver.switchTo().window(windowParent);
		MetodosComunes.hacerHighlight(driver, driver.findElement(lnkText));
		Thread.sleep(3000);
		driver.findElement(lnkText).click();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
