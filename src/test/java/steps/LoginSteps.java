package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverManager;

public class LoginSteps {
	
	protected WebDriver driver = WebDriverManager.getDriver();

	@When("the user writes their email")
	public void theUserWritesTheirEmail() {
		WebElement email = driver.findElement(By.id("email")); 
		email.clear();
		email.sendKeys("1666868@uab.cat");
	}
	
	@And("the user writes their password")
	public void theUserWritesTheirPassword() {
		WebElement pass = driver.findElement(By.id("pass")); 
		pass.clear();
		pass.sendKeys("pruebaTest24");
	}
	
	@And("the user clicks the login button")
	public void theUserClicksTheLoginButton() {
		WebElement loginButton = driver.findElement(By.id("send2")); 
		loginButton.click();
	}
	
	@Then("the user is logged")
	public void theUserButtonIsLogged() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-title")));
        String title = page.getText();
        Assert.assertTrue(title.contains("Mi Área FANZ"));
	}
}
