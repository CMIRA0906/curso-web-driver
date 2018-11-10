package common;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilidades {

	public static final Logger LOGGER = LogManager.getLogger(Utilidades.class);

	/**
	 * Método para tomar evidencia las acciones realizadas
	 * 
	 * @param driver
	 */
	public static void tomarEvidencia(WebDriver driver) {

		try {

			File evidencia = null;
			evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(evidencia,
					new File("src/test/resources/evidencias/evidencia" + new Date().getTime() + ".png"));

		} catch (Exception e) {

			LOGGER.error("Se presentó un error tomando la evidencia " + e);

		}

	}

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

	public static void showAlert(WebDriver driver, String textAlert) {

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("alert('" + textAlert + "')");
		}

	}

	public static void gotoNewWindowByTittle(WebDriver driver, String title) {

		driver.switchTo().window(title);

	}

}
