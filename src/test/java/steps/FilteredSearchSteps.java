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
    
    @And("the user selects Comics")
    public void theUserSelectsComics() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        WebElement comicsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='COMICS']")));
        comicsButton.click();
    }
    
    @Then("the user should see a message Norma Comics La Mayor Tienda De Comics De Europa")
    public void theUserShouldSeeAMessageNormaComicsLaMayorTiendaDeComicsDeEuropa() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  
    	WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.base[data-ui-id='page-title-wrapper']")));
        String messageText = messageElement.getText();
        Assert.assertTrue(messageText.contains("Norma Cómics: La Mayor Tienda De Cómics De Europa"));
    }
    
    @And("the user selects Libros")
    public void theUserSelectsLibros() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        WebElement librosButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='LIBROS']")));
        librosButton.click();
    }
    
    
    @Then("the user should see a message Libros")
    public void theUserShouldSeeAMessageLibros() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
    	WebElement messageLibros = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.base[data-ui-id='page-title-wrapper']")));
        String messageText = messageLibros.getText();
        Assert.assertTrue(messageText.contains("Libros"));
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
