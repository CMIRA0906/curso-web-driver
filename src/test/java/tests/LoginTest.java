package tests;

import org.testng.annotations.Test;

import common.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void hacerLoginTest() throws Exception {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.abrirPagina();
		loginPage.hacerLogin();

	}

}
