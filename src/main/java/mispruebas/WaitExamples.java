package mispruebas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import org.testng.annotations.Test;

public class WaitExamples {

	MyFirstTest myTest = new MyFirstTest();

	private WebDriver driver;

	By lnkPromptPage = By.linkText("Wait For Condition");
	By btnClickME = By.cssSelector("input[type=button]");
	By lblTest = By.id("id2");

	@Test
	public void getTextExpectedCondition() throws MyTestExcepcion {

		myTest.abrirNavegador();
		driver = myTest.getWebDriver();
		driver.get(Constantes.URL_PRUEBAS);
		driver.findElement(lnkPromptPage).click();
		driver.findElement(btnClickME).click();
		expectedConditionPresenWebElement(driver, lblTest);
		expectedConditionPresentTextInWebElementTest(driver, lblTest, "id 2");

		System.err.println("Si encontró el texto");
		System.out.println(driver.findElement(lblTest).getText());
		myTest.cerrarNavegador();

	}

	public void expectedConditionPresentTextInWebElementTest(WebDriver driver, By by, String text) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Constantes.EXPLICIT_WAIT);
			wait.until(ExpectedConditions.textToBe(by, text));
			LogTest.imprimirMensaje("Se encontró el texto buscado");

		} catch (Exception e) {
			LogTest.imprimirMensaje("No se existe el texto buscado dentro del elemento");
			throw new TestException("No se existe el texto buscado dentro del elemento");
			
		}

	}

	public void expectedConditionPresenWebElement(WebDriver driver, By by) throws MyTestExcepcion {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Constantes.EXPLICIT_WAIT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			LogTest.imprimirMensaje("Si está el elemento buscado");
		

		} catch (Exception e) {
			LogTest.imprimirMensaje("No se existe el elemento buscado en el DOM");
			throw new MyTestExcepcion("No se existe el elemento buscado en el DOM", null);
		}

	}

}
