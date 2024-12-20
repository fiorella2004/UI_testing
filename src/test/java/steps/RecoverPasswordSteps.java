package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverManager;

public class RecoverPasswordSteps {
	
	protected WebDriver driver = WebDriverManager.getDriver();
	
	@When("the user clicks the link to recover their password")
	public void theUserClicksTheLinkToRecoverTheirPassword() {
		WebElement recoverPassLink = driver.findElement(By.cssSelector(".remind")); 
		recoverPassLink.click();
	}
	
	@Then("the user provides their email")
	public void theUserProvidesTheirEmail() {
		WebElement email = driver.findElement(By.id("email_address")); 
		email.clear();
		email.sendKeys("1666868@uab.cat");
	}
	
	@When("the user clicks the recover password button")
	public void theUserClicksTheRecoverPasswordButton() {
		WebElement recoverPasswordButton = driver.findElement(By.cssSelector("button.action.submit.primary")); 
		recoverPasswordButton.click();
	}
	
	@Then("the user can see the page to recover their password")
	public void theUserCanSeeThePageToRecoverTheirPassword() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-title")));
        String title = page.getText();
        Assert.assertTrue(title.contains("¿Olvidó su contraseña?"));
	}
}
