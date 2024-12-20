package steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverManager;

public class RegisterSteps {
	
	protected WebDriver driver = WebDriverManager.getDriver();
	
	@When("the user clicks the register button")
	public void theUserClicksTheRegisterButton() {
	    WebElement registerButton = driver.findElement(By.cssSelector("button.action.secondary a.register-link"));
	    registerButton.click();
	}
	
	@Then("the user can see the register page")
	public void theUserCanSeeTheRegisterPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-title span.base")));
		String title = page.getText();
		Assert.assertEquals("Regístrate", title);
	}
	
	@When("the user writes their information")
	public void theUserWritesTheirInformation() {
		WebElement firstName = driver.findElement(By.id("firstname")); 
		firstName.clear();
		firstName.sendKeys("Prueba");
		WebElement lastName = driver.findElement(By.id("lastname")); 
		lastName.clear();
		lastName.sendKeys("Test");
		WebElement email = driver.findElement(By.id("email_address")); 
		email.clear();
		email.sendKeys("1666868@uab.cat");
		WebElement password = driver.findElement(By.id("password")); 
		password.clear();
		password.sendKeys("pruebaTest24");
		WebElement passwordConfirmation = driver.findElement(By.id("password-confirmation")); 
		passwordConfirmation.clear();
		passwordConfirmation.sendKeys("pruebaTest24");
	}
	
	@And("the user clicks the confirm register button")
	public void theUserClicksTheConfirmRegisterButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement politicsButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aceptar_politica")));
		js.executeScript("arguments[0].scrollIntoView(true);", politicsButton); 
		js.executeScript("arguments[0].click();", politicsButton); 
		
		WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("register-submit-button")));
		js.executeScript("arguments[0].scrollIntoView(true);", registerButton); 
		js.executeScript("arguments[0].click();", registerButton);
	}
}
