package steps;

import static org.testng.Assert.assertNotNull;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.WebDriverManager;

public class FilteredSearchSteps {

	protected WebDriver driver = WebDriverManager.getDriver();
    
    @And("the user clicks on the Menu button")
    public void theUserClicksOnTheMenuButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Menú']")));
        menuButton.click();
    }
    
    @And("^the user selects (.*) filter$")
    public void theUserSelectsComicsFilter(String filter) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        WebElement comicsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//span[text()='%s']", filter))));
        comicsButton.click();
    }
    
    @Then("^the user should see a message (.*)")
    public void theUserShouldSeeAMessageNormaComicsLaMayorTiendaDeComicsDeEuropa(String title) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  
    	WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.base[data-ui-id='page-title-wrapper']")));
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        String messageText = messageElement.getText();
        Assert.assertTrue(messageText.contains(title));
    }
    
    @And("the user clicks on the merchandising button")
    public void theUserClicksOnTheMerchandisingButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
    	WebElement merchandisingButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Merchandising']")));
    	merchandisingButton.click();
    }
    
    @Then("the user should see a product of portamanga sushi")
    public void theUserShoulSeeAProductOfPortaMangaSushi() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
    	WebElement resultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.product-image-photo[alt='PORTAMANGA SUSHI']")));
        assertNotNull(resultsContainer);
    }
}
