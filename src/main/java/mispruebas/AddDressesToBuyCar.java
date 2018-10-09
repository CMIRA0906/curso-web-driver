package mispruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDressesToBuyCar {

	WebDriver driver;
	
	MyFirstTest myFirstTest = new MyFirstTest();
	
	WaitExamples waitExamples = new WaitExamples();

	public AddDressesToBuyCar() {

//		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

	By lnkTShirts = By.cssSelector("div>ul>li>a[title='T-shirts']");
	By lnkDresses = By.cssSelector("div>ul>li>a[title='Dresses']");
	By lnkCasualDresses = By.xpath("//ul[@class='tree dynamized']/li/a[contains(text(),'Casual Dresses')]");
	By rbtSize = By.id("layered_id_attribute_group_2");
	By imgDress = By.cssSelector("img[title='Printed Dress']");
	By btnAddToCar = By.cssSelector("a[class='button ajax_add_to_cart_button btn btn-default'][title='Add to cart']");
			//By.cssSelector("ul[class='submenu-container clearfix first-in-line-xs'] ul[style='display: none;'] li>a[title='Casual Dresses']");
	By btnProceedToCheckout = By.cssSelector("a[class='btn btn-default button button-medium']");
	
	
	public void comprarCamisa() throws InterruptedException {

		// webTest.abrirNavegador();
		myFirstTest.abrirNavegador();
		
		driver =myFirstTest.getWebDriver();
		driver.get("http://automationpractice.com/index.php?id_category=9&controller=category");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(lnkDresses)).build().perform();
		driver.findElement(lnkDresses).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(lnkCasualDresses));
		
		MetodosComunes.hacerHighlight(driver, driver.findElement(lnkCasualDresses));
		System.out.println("Se espera a que el elemento esté visible");
		driver.findElement(lnkCasualDresses).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(imgDress));
		System.out.println("Se espera Size");
		MetodosComunes.hacerHighlight(driver,driver.findElement(rbtSize));
		driver.findElement(rbtSize).click();
	
		action.moveToElement(driver.findElement(imgDress)).build().perform();
		MetodosComunes.hacerHighlight(driver,driver.findElement(btnAddToCar));
		driver.findElement(btnAddToCar).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnProceedToCheckout));
		MetodosComunes.hacerHighlight(driver,driver.findElement(btnProceedToCheckout));
		driver.findElement(btnProceedToCheckout).click();
		
		Thread.sleep(5000);
		driver.quit();

	}
	
	public static void main(String[] args) throws InterruptedException {
		
		AddDressesToBuyCar addDressesToBuyCar = new AddDressesToBuyCar();
		addDressesToBuyCar.comprarCamisa();
		
		
	}

}
