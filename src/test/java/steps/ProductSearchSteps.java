package steps;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.WebDriverManager;

public class ProductSearchSteps {
	
	protected WebDriver driver = WebDriverManager.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
    
    @And("the user enters arcane in the search bar")
    public void theUserEntersArcaneInTheSearchBar() {
    	WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
    	searchInput.sendKeys("arcane");
    	searchInput.sendKeys(Keys.RETURN);
    }
    
    @Then("the results show products related to arcane")
    public void theResultsShowRelatedToArcane() {
        WebElement products = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("products-grid"))); 
        
        List<WebElement> productItems = products.findElements(By.cssSelector(".product-item"));  
        
        boolean containsArcane = false;
        for (WebElement product : productItems) {
            String productText = product.getText().toLowerCase();
            if (productText.contains("arcane")) {
                containsArcane = true;
                break;
            }
        }
        Assert.assertTrue(containsArcane);
    }
    
    @And("the user enters mmmmm in the search bar")
    public void theUserEntersmmmmmInTheSearchBar() {
    	WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
    	searchInput.sendKeys("mmmmm");
    	searchInput.sendKeys(Keys.RETURN);
    }
    
    @Then("a message indicates Prueba de nuevo con otra busqueda")
    public void aMessageIndicatesPruebaDeNuevoConOtraBusqueda() {
    	WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'La búsqueda no ha devuelto ningún resultado')]")));
        String messageText = messageElement.getText();
        Assert.assertTrue(messageText.contains("La búsqueda no ha devuelto ningún resultado"));
    }
   
}
