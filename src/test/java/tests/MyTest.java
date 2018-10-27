package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.BaseTest;
import common.ReadExcelData;

public class MyTest extends BaseTest {

	By linkTestCorrecto = By.linkText("Link Test");
	By linkTestInCorrecto = By.linkText("Link Tes");

	//@Test(dataProvider = "getDatosPrueba", dataProviderClass = ReadExcelData.class)
	public void todoTest(String p1, String p2, String p3) {

	}

	@Test
	public void ingresarSahiThrow() throws NoSuchElementException {
		//public void ingresarSahiThrow(String p1, String p2, String p3) throws NoSuchElementException {

		try {
			driver.get("http://sahitest.com/demo/");
			driver.findElement(linkTestCorrecto).click();

		} catch (NoSuchElementException e) {

			System.out.println("Ingresé al catch de la excepcion  NoSuchElementException");

			throw new NoSuchElementException("No estaba disponible el elemento linkTestInCorrecto");

		} catch (Exception e) {

			System.out.println("Ingresé al catch de la excepcion Exception");

		}

	}

	@DataProvider(name="getD")
	public Object[][] getDatosDataProvider() {

		return new Object[][] { { "p1", "p2", "p3" }, { "p12", "p22", "p32" }, { "p12", "p22", "p32" } };

	}

}
