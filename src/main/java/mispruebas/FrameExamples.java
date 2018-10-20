package mispruebas;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameExamples {
	
	private WebDriver driver;
	
	By lnkFrame = By.linkText("Frames Test");
	By lnkBrakeFrame = By.linkText("Break Frames");
	
	public void goToFrame() throws InterruptedException, MalformedURLException{
		
		MyFirstTest myFirstTest = new MyFirstTest();
		myFirstTest.abrirNavegador();
		driver= myFirstTest.getWebDriver();
		driver.get(WindowsExample.URL_SAHI);
		driver.findElement(lnkFrame).click();
		Thread.sleep(5000);
		driver.switchTo().frame(1);
		MetodosComunes.hacerHighlight(driver,driver.findElement(lnkBrakeFrame) );
		Thread.sleep(5000);
		driver.findElement(lnkBrakeFrame).click();
		Thread.sleep(5000);
		
		driver.quit();
		
	}
	
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		FrameExamples frameExample = new FrameExamples();
		frameExample.goToFrame();
		
	}

}
