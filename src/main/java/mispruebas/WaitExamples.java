package mispruebas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExamples {

	public static final Logger LOGGER = LogManager.getLogger(WaitExamples.class);

	MyFirstTest myTest = new MyFirstTest();

	private WebDriver driver;

	By lnkPromptPage = By.linkText("Wait For Condition");
	By btnClickME = By.cssSelector("input[type=button]");
	By lblTest = By.id("id2");

	public void getTextExpectedCondition() throws Exception {

		myTest.abrirNavegador();
		driver = myTest.getWebDriver();
		driver.get(Constantes.URL_PRUEBAS);
		driver.findElement(lnkPromptPage).click();
		driver.findElement(btnClickME).click();
		expectedConditionPresenWebElement(driver, lblTest);
		expectedConditionPresentTextInWebElementTest(driver, lblTest, "id 2");

		LOGGER.info("Si encontró el texto");
		LOGGER.info(driver.findElement(lblTest).getText());
		myTest.cerrarNavegador();

	}

	public void expectedConditionPresentTextInWebElementTest(WebDriver driver, By by, String text) throws Exception {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Constantes.EXPLICIT_WAIT);
			wait.until(ExpectedConditions.textToBe(by, text));
			LogTest.imprimirMensaje("Se encontró el texto buscado");

		} catch (Exception e) {
			LogTest.imprimirMensaje("No se existe el texto buscado dentro del elemento");
			throw new Exception("No se existe el texto buscado dentro del elemento");

		}

	}

	public void expectedConditionPresenWebElement(WebDriver driver, By by) throws Exception {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Constantes.EXPLICIT_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			LogTest.imprimirMensaje("Si está el elemento buscado");

		} catch (Exception e) {
			LogTest.imprimirMensaje("No se existe el elemento buscado en el DOM");
			throw new Exception("No se existe el elemento buscado en el DOM", null);
		}

	}

}
