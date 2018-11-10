package mispruebas;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MetodosComunes {
	
	/**
	 * Método para hacer highlight
	 * 
	 * @param driver
	 * @param element
	 */
	public static void hacerHighlight(WebDriver driver, WebElement element) {

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='25px solid red'", element);
		}

	}
	
	public static void showAlert(WebDriver driver,String textAlert) {

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("alert('"+textAlert+"')");
		}

	}
	
	public static void gotoNewWindowByTittle(WebDriver driver, String title ){
		
		driver.switchTo().window(title);
	
	}

}
