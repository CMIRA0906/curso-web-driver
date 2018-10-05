package mispruebas;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WindowExamples {
	
	MyFirstTest myTest = new MyFirstTest();
	
	WebDriver driver;
	
	//Elementos
	By linkWindow = By.cssSelector("a[target=_blank]");
	

	
	public void goToNewWindow(){
		
		myTest.abrirNavegador();
		driver = myTest.getWebDriver();
		driver.get(Constantes.URL_PRUEBAS);
		//Window inicial
		String windowParent = driver.getWindowHandle();
		System.out.println("Es el handled de la ventana inicial: "+windowParent);
		driver.findElement(linkWindow).click();
		driver.switchTo().window(windowParent);
		Set<String>AllWindows= driver.getWindowHandles();
		//Es la segunda ventana
		String secondWindow =(String) AllWindows.toArray()[1];
		driver.switchTo().window(secondWindow);
		
	}
	
	
	
	
	

}
