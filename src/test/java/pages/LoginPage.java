package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// instancia de objeto webdriver
	private WebDriver driver;

	// elementos de login
	@FindBy(css = "a.login")
	private WebElement lnkSingIn;
	// By lnkSingIn = By.cssSelector("a.login");

	@FindBy(how = How.ID_OR_NAME, using = "email")
	private WebElement txtEmail;
	// By txtEmail = By.id("email");
	@FindBy(how = How.ID, using = "passwd")
	private WebElement txtPassword;
	// By txtPassword = By.id("passwd");
	@FindBy(how = How.ID, using = "SubmitLogin")
	private WebElement btnLogin;
	// By btnLogin = By.id("SubmitLogin");
	@FindBy(how = How.CSS, using = "a[title='View my customer account']")
	private WebElement lnkUsuario;
	// By lnkUsuario = By.cssSelector("a[title='View my customer account']");
	@FindBy(how = How.CLASS_NAME, using = "logout")
	private WebElement lnkSingOut;
	// By singOut = By.className("logout");

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		// PageFactory
		PageFactory.initElements(driver, this);
	}

	public void hacerLogin() throws Exception {

		try {

			lnkSingIn.click();
			txtEmail.sendKeys("cmira0906@gmail.com");
			txtPassword.sendKeys("pruebas");
			btnLogin.click();

		} catch (NoSuchElementException e) {

			System.out.println("Se presentó un error: " + e);
			throw new Exception("Se presentó un error: "+e);
			// TODO: handle exception
		}

	}

	public void abrirPagina() {

		driver.get("http://automationpractice.com/");
	}

}
