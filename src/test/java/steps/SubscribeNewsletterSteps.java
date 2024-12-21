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

public class SubscribeNewsletterSteps {
	
	protected WebDriver driver = WebDriverManager.getDriver();
	
	@Then("the page shows the option to subscribe to the newsletter")
	public void thePageShowsTheOptionToSubscribeToTheNewsletter() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.row-full-width-inner > div[data-content-type='text'] p")));
	    String expectedText = text.getText();
	    Assert.assertTrue(expectedText.contains("¿Quieres conocer las últimas novedades?"));
	}
	
	@When("the user completes the form")
	public void theUserCompletesTheForm() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("smIframe-tep2xdecpj6wrr37")));
	    driver.switchTo().frame(iframe);
	    WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("sm-form-email")));
	    email.clear();
	    email.sendKeys("1666868@uab.cat");
	    driver.switchTo().defaultContent();
	}
	
	@And("the user clicks the subscribe button")
	public void theUserClicksTheSubscribeButton() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("smIframe-tep2xdecpj6wrr37")));
	    driver.switchTo().frame(iframe);
	    WebElement subscribeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'].btn")));
	    subscribeButton.click();
	    driver.switchTo().defaultContent();
	}
	
	@And("the user checks the promo checkbox")
	public void theUserChecksThePromoCheckbox() {
	    driver.switchTo().frame(driver.findElement(By.id("smIframe-tep2xdecpj6wrr37")));
	    WebElement promoCheckbox = driver.findElement(By.cssSelector("input[name='sm-form-consent-name-CONSENTIMIENTOS_NEWSLETTERS']"));
	    promoCheckbox.click();
	    driver.switchTo().defaultContent();
	}
	
	@Then("the page shows the verification")
	public void thePageShowsTheVerification() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("smIframe-tep2xdecpj6wrr37")));
		driver.switchTo().frame(iframe);
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bhr-thank-you-message .full-width")));
		String text = message.getText();
		Assert.assertTrue(text.contains("¡Gracias por suscribirte!"));
		driver.switchTo().defaultContent();
	}
}