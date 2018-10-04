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
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='45px solid yellow'", element);
		}

	}

}
