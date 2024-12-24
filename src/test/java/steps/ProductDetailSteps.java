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
import utils.WebDriverManager;

public class ProductDetailSteps {
	
	protected WebDriver driver = WebDriverManager.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
	
	@And("the user clicks one product")
	public void theUserClicksOneProduct() {
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-image-photo")));
		product.click();
	}
	
	@Then("the product details are shown")
	public void theProductDetailsAreShown() {
		WebElement caracteristicas = driver.findElement(By.linkText("Características"));
		Assert.assertNotNull(caracteristicas);
	}
}
    