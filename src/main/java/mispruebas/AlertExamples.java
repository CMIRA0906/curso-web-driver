package mispruebas;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class AlertExamples{
	
	
	WebDriver driver;
	
	//ELementos de page sahidemo
	By lnkAlertText = By.linkText("Alert Test");
	By btnClickAlertText = By.name("b1");
	By lnkConfirmPage = By.linkText("Confirm Page");
	By lnkPromptPage  = By.linkText("Prompt Page");
	
	
	public void alertAccept() throws InterruptedException{
		
		MyFirstTest myFirstTest = new MyFirstTest();
		myFirstTest.abrirNavegador();
		driver = myFirstTest.getWebDriver();
		driver.get(WindowsExample.URL_SAHI);
		driver.findElement(lnkAlertText).click();
		driver.findElement(btnClickAlertText).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.quit();		
		
	}
	
	public void getAlertText() throws InterruptedException{
		
		MyFirstTest myFirstTest = new MyFirstTest();
		myFirstTest.abrirNavegador();
		driver = myFirstTest.getWebDriver();
		driver.get(WindowsExample.URL_SAHI);
		driver.findElement(lnkAlertText).click();
		driver.findElement(btnClickAlertText).click();
		Thread.sleep(3000);
		String alertTextContent =driver.switchTo().alert().getText();
		System.out.println("Este es el texto de la alerta: "+alertTextContent);
		driver.switchTo().alert().accept();
		driver.quit();		
		
	}
	
	/**
	 * @author User
	 * Método que da clic en la opción cancelar de una alerta
	 * @throws InterruptedException
	 */
	public void alertDissmis() throws InterruptedException{
		
		MyFirstTest myFirstTest = new MyFirstTest();
		myFirstTest.abrirNavegador();
		driver = myFirstTest.getWebDriver();
		driver.get(WindowsExample.URL_SAHI);
		driver.findElement(lnkConfirmPage).click();
		driver.findElement(btnClickAlertText).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		driver.quit();		
		
	}
	
	
	public void sendAlertText() throws InterruptedException{
		
		MyFirstTest myFirstTest = new MyFirstTest();
		myFirstTest.abrirNavegador();
		driver = myFirstTest.getWebDriver();
		driver.get(WindowsExample.URL_SAHI);
		driver.findElement(lnkPromptPage).click();
		driver.findElement(btnClickAlertText).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Yo soy el mejor");
		driver.switchTo().alert().accept();
		
		//driver.quit();		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		AlertExamples alertExamples =  new AlertExamples();
		alertExamples.sendAlertText();
		
	}
	
	
	
	
	
	
	

}
