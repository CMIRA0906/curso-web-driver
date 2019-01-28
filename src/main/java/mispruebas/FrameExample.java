package mispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FrameExample {

	WebDriver driver;

	public void ingresarAFramePorId() throws InterruptedException {

		RegistroTest web = new RegistroTest();
		web.abrirNavegador();
		driver = web.getWebDriver();
		driver.get("http://sahitest.com/demo/");
		MetodosComunes.hacerHighlight(driver, driver.findElement(By.linkText("Frames Test")));
		driver.findElement(By.linkText("Frames Test")).click();
		driver.switchTo().frame(1);
		MetodosComunes.hacerHighlight(driver, driver.findElement(By.cssSelector("input[value='Close Self']")));
		driver.findElement(By.cssSelector("input[value='Close Self']")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("Frames Test")).click();
		driver.quit();

	}

	public void ingresarAFramePorNombre() throws InterruptedException {

		RegistroTest web = new RegistroTest();
		web.abrirNavegador();
		driver = web.getWebDriver();
		driver.get("http://sahitest.com/demo/");
		MetodosComunes.hacerHighlight(driver, driver.findElement(By.linkText("Frames Test")));
		driver.findElement(By.linkText("Frames Test")).click();
		driver.switchTo().frame("top");
		MetodosComunes.hacerHighlight(driver, driver.findElement(By.cssSelector("input[value='Close Self']")));
		driver.findElement(By.cssSelector("input[value='Close Self']")).click();
		driver.navigate().back();
		driver.findElement(By.linkText("Frames Test")).click();
		driver.quit();

	}

	

}
