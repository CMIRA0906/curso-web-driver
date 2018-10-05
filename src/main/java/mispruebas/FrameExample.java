package mispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FrameExample {

	WebDriver driver;

	// Ingresar a frame por número de frame
	@Test
	public void ingresarAFramePorId() throws InterruptedException {

		RegistroTest web = new RegistroTest();
		web.abrirNavegador();
		driver = web.getWebDriver();
		driver.get("http://sahitest.com/demo/");
		MetodosComunes.hacerHighlight(driver, driver.findElement(By.linkText("Frames Test")));
		driver.findElement(By.linkText("Frames Test")).click();
		// Ir a frame
		driver.switchTo().frame(1);
		MetodosComunes.hacerHighlight(driver, driver.findElement(By.cssSelector("input[value='Close Self']")));
		// Elemento dentro frame 1
		driver.findElement(By.cssSelector("input[value='Close Self']")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("Frames Test")).click();
		driver.quit();

	}

	// Ingresar a frame por nombre
	@Test
	public void ingresarAFramePorNombre() throws InterruptedException {

		RegistroTest web = new RegistroTest();
		web.abrirNavegador();
		driver = web.getWebDriver();
		driver.get("http://sahitest.com/demo/");
		MetodosComunes.hacerHighlight(driver, driver.findElement(By.linkText("Frames Test")));
		driver.findElement(By.linkText("Frames Test")).click();
		// Ir a frame
		driver.switchTo().frame("top");
		MetodosComunes.hacerHighlight(driver, driver.findElement(By.cssSelector("input[value='Close Self']")));
		// Elemento dentro frame 1
		driver.findElement(By.cssSelector("input[value='Close Self']")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("Frames Test")).click();
		driver.quit();

	}

	

}
