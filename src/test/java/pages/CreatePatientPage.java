package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestException;

public class CreatePatientPage {

	private WebDriver driver;

	// Objetos dom addPatient
	@FindBy(how = How.ID_OR_NAME, using = "name")
	private WebElement txtName;
	@FindBy(how = How.ID_OR_NAME, using = "last_name")
	private WebElement txtLastName;
	@FindBy(how = How.ID_OR_NAME, using = "telephone")
	private WebElement txtTelephone;
	@FindBy(how = How.ID_OR_NAME, using = "identification_type")
	private WebElement lstIdentificationType;
	@FindBy(how = How.ID_OR_NAME, using = "identification")
	private WebElement txtIdentification;
	@FindBy(how = How.ID_OR_NAME, using = "prepaid")
	private WebElement chkPrepaid;
	@FindBy(how = How.XPATH, using = "//a[text()='Guardar']")
	private WebElement btnGuardar;

	public CreatePatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void createPatient(String name, String lastName, String telephone, String identificationType,
			String identification, String havePrepaid) {

		try {

			txtName.sendKeys(name);
			txtLastName.sendKeys(lastName);
			txtTelephone.sendKeys(telephone);
			Select listIdenType = new Select(lstIdentificationType);
			listIdenType.selectByValue(identificationType);
			txtIdentification.sendKeys(identification);
			if ("S".equals(havePrepaid)) {
				chkPrepaid.click();
			} else {
				System.out.println("Don't have prepaid");
			}
			btnGuardar.click();
		} catch (Exception e) {
			throw new TestException("Have a error"+e);
		}

	}

}
