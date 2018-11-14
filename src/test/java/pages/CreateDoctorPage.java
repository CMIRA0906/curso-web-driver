package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.Utilities;

public class CreateDoctorPage {

	// Se instancia el driver
	private WebDriver driver;

	// Doctor page elements

	@FindBy(id = "name")
	private WebElement txtName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "telephone")
	private WebElement txtTelephone;

	@FindBy(id = "identification_type")
	private WebElement lstIdentificationType;

	@FindBy(id = "identification")
	private WebElement txtIdentification;

	@FindBy(xpath = "//a[text()='Guardar']")
	private WebElement btnGuardar;
	
	@FindBy(css="div.panel-body")
	private WebElement lblConfirm;

	public CreateDoctorPage(WebDriver driver) {
		this.driver = driver;

		// PageFactory
		PageFactory.initElements(driver, this);

	}
	
	
	public void createDoctor(String name, String lastName, String phone, String documentType, String numDocument){
		
		txtName.clear();
		txtName.sendKeys(name);
		Utilities.tomarEvidencia(driver);
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
		Utilities.tomarEvidencia(driver);
		txtTelephone.clear();
		txtTelephone.sendKeys(phone);
		Utilities.tomarEvidencia(driver);
		Select listDocumentType = new Select(lstIdentificationType);
		listDocumentType.selectByValue(documentType);
		Utilities.tomarEvidencia(driver);
		txtIdentification.clear();
		txtIdentification.sendKeys(numDocument);
		Utilities.tomarEvidencia(driver);
		btnGuardar.click();
		Utilities.tomarEvidencia(driver);
		
		
	}
	
	
	public String getMsjConfirm(){
		
		
		System.out.println(lblConfirm.getText());
		return lblConfirm.getText();
		
	}

}
