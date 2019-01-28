package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constantes.Constantes;

public class Utilities {

	public static final Logger LOGGER = LogManager.getLogger(Utilities.class);

	/**
	 * Método para tomar evidencia las acciones realizadas
	 * 
	 * @param driver
	 */
	public static void tomarEvidencia(WebDriver driver) {

		try {

			File evidenceFolder = createEvidenceFolder();
			File evidenceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(evidenceFile,
					new File(evidenceFolder + "/" + String.valueOf(System.currentTimeMillis()) + ".png"));

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

	/**
	 * Método para generar número de forma aleatoria
	 * 
	 * @return
	 */
	public static int randomNumber() {

		Random random = new Random();
		return random.nextInt();

	}

	private static File createEvidenceFolder() {
		try {
			String stringDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());

			File directory = new File(Constantes.EVIDENCES_PATH.concat(stringDate));

			if (!directory.exists()) {
				directory.mkdir();
				LOGGER.info("Se creó la carpeta de las evidencias");
			}

			return directory;

		} catch (Exception e) {

			LOGGER.info("No se pudo crear la carpeta " + e);
			return null;

		}

	}

	public static void waitForVisibilityOfWebElement(WebElement webElement, WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

}
