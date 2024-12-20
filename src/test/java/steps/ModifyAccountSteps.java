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

public class ModifyAccountSteps {
	
	protected WebDriver driver = WebDriverManager.getDriver();
	
	@And("the user logs with their account")
	public void theUserLogsWithTheirAccount() {
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys("1666868@uab.cat");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.clear();
		pass.sendKeys("pruebaTest24");
		WebElement loginButton = driver.findElement(By.id("send2"));
		loginButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-title")));
		String title = page.getText();
        Assert.assertTrue(title.contains("Mi Área FANZ"));
	}
	
	@When("the user clicks the edit profile link")
	public void theUserClicksTheEditProfileLink() {
		WebElement editProfileLink = driver.findElement(By.cssSelector("a.action.edit > span"));
		editProfileLink.click();
	}
	
	
	@When("the user clicks the change password link")
	public void theUserClicksTheChangePasswordLink() {
		WebElement editProfileLink = driver.findElement(By.cssSelector("a.action.change-password"));
		editProfileLink.click();
	}
	
	@Then("the page shows the information to edit")
	public void thePageShowsTheInformationToEdit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-title")));
		String title = page.getText();
		Assert.assertTrue(title.contains("Editar información de la cuenta"));
	}
	
	@When("the user writes their new information")
	public void theUserWritesTheirNewInformation() {
		WebElement firstName = driver.findElement(By.id("firstname")); 
		firstName.clear();
		firstName.sendKeys("Prueba");
		WebElement lastName = driver.findElement(By.id("lastname")); 
		lastName.clear();
		lastName.sendKeys("Test");
	}
	
	@When("the user writes their new password")
	public void theUserWritesTheirNewPassword() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    		By.xpath("//legend/span[@data-title='change-email-password' and text()='Cambiar contraseña']")));
		WebElement currentPassword = driver.findElement(By.id("current-password")); 
		currentPassword.clear();
		currentPassword.sendKeys("pruebaTest24");
		WebElement newPassword = driver.findElement(By.id("password")); 
		newPassword.clear();
		newPassword.sendKeys("pruebaTest24");
		WebElement newPassword2 = driver.findElement(By.id("password-confirmation")); 
		newPassword2.clear();
		newPassword2.sendKeys("pruebaTest24");
	}
	
	@When("the user writes their password incorrectly")
	public void theUserWritesTheirPasswordIncorrectly() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    		By.xpath("//legend/span[@data-title='change-email-password' and text()='Cambiar contraseña']")));
		WebElement currentPassword = driver.findElement(By.id("current-password")); 
		currentPassword.clear();
		currentPassword.sendKeys("pruebaTest");
		WebElement newPassword = driver.findElement(By.id("password")); 
		newPassword.clear();
		newPassword.sendKeys("pruebaTest24");
		WebElement newPassword2 = driver.findElement(By.id("password-confirmation")); 
		newPassword2.clear();
		newPassword2.sendKeys("pruebaTest24");
	}
	
	@And("the user clicks the save button")
	public void theUserClicksTheSaveButton() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.action.save.primary")));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", saveButton);
	}
	
	@Then("the page shows that the information has been saved")
	public void thePageShowsThatTheInformationHasBeenSaved() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-success.success.message")));
	    String messageText = successMessage.getText();
	    Assert.assertTrue(messageText.contains("Ha guardado la información de cuenta."));
	}
	
	@Then("the page shows that the password doesnt match")
	public void thePageShowsThatThePasswordDoesntMatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-error.error.message")));
	    String messageText = errorMessage.getText();
	    Assert.assertTrue(messageText.contains("The password doesn't match this account. Verify the password and try again."));
	}
}
