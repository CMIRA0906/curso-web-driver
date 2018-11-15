package tests;


import org.testng.annotations.Test;

import common.BaseTest;
import common.Utilities;
import net.bytebuddy.utility.RandomString;
import pages.CreatePatientPage;
import pages.MenuPage;

public class CreatePatientTest extends BaseTest {

	@Test
	public void createPatientTestMethod() {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.openHerukuPage();
		menuPage.enterToAddPatientPage();
		CreatePatientPage createPatientPage = new CreatePatientPage(driver);
		createPatientPage.createPatient(RandomString.make(10), RandomString.make(10),
				String.valueOf(Utilities.randomNumber()), "C�dula de ciudadan�a",
				String.valueOf(Utilities.randomNumber()), "S");

	}

}
