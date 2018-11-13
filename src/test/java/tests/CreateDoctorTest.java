package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import common.BaseTest;
import pages.CreateDoctorPage;

public class CreateDoctorTest extends BaseTest{
	
	@Test
	private void createDoctorTest() throws InterruptedException{
		
		driver.get("http://automatizacion.herokuapp.com/pperez/addDoctor");
		
		CreateDoctorPage doctorPage = new CreateDoctorPage(driver);
		doctorPage.createDoctor("Cristian", "Mira", "3008502112","C�dula de ciudadan�a", "10995258125");
		assertTrue(doctorPage.getMsjConfirm().contains("Datos guardados correctamente."));
		Thread.sleep(5000);
		
		
	}
	
	
	

}
