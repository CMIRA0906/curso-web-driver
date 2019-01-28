package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import constantes.Constantes;

public class MenuPage {
	
	private WebDriver driver;
	
	@FindBy(how = How.CSS,using="a[href='addDoctor']")
	private WebElement lnkAddDoctor;
	@FindBy(how = How.CSS,using="a[href='addPatient']")
	private WebElement lnkAddPatient;
	
	
	
	public MenuPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
	}
	
	public void openHerukuPage(){
		
		driver.get(Constantes.URL_HERUKU_APP);

		
	}
	
	public void enterToAddDoctorPage(){
		
		lnkAddDoctor.click();
	
	}
	public void enterToAddPatientPage(){
		
		lnkAddPatient.click();

	}
	

	

}
