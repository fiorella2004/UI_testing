package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps {
	WebDriver driver;
	

    @Given("the user is in the index page")
    public void theUserIsInTheIndexPage() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.navigate().to("https://www.normacomics.com/");
    }
    
    @When("The user clicks accept all cookies")
    public void theUserClicksAcceptAllCookies() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        acceptButton.click();
    }
    
    @When("the user enters arcane in the search bar")
    public void theUserEntersArcaneInTheSearchBar() {
    	 WebElement searchForm = driver.findElement(By.id("search_mini_form"));
    	 WebElement searchInput = searchForm.findElement(By.id("search"));
    	 searchInput.sendKeys("arcane");
    	 searchInput.sendKeys(Keys.RETURN);
    }
    
    @Then("the results show products related to arcane")
    public void theResultsShowRelatedToArcane() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        WebElement resultsContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("products-grid"))); 
        
        List<WebElement> productItems = resultsContainer.findElements(By.cssSelector(".product-item"));  
        
        boolean containsArcane = false;
        for (WebElement product : productItems) {
            String productText = product.getText().toLowerCase();
            if (productText.contains("arcane")) {
                containsArcane = true;
                break;
            }
        }
    }
    
    @When("the user enters mmmmm in the search bar")
    public void theUserEntersmmmmmInTheSearchBar() {
    	 WebElement searchForm = driver.findElement(By.id("search_mini_form"));
    	 WebElement searchInput = searchForm.findElement(By.id("search"));
    	 searchInput.sendKeys("mmmmm");
    	 searchInput.sendKeys(Keys.RETURN);
    }
    
    @Then("a message indicates Prueba de nuevo con otra busqueda")
    public void aMessageIndicatesPruebaDeNuevoConOtraBusqueda() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
    	WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'message notice')]//div[contains(text(),'La búsqueda no ha devuelto ningún resultado')]")));
        String messageText = messageElement.getText();
        Assert.assertTrue(messageText.contains("La búsqueda no ha devuelto ningún resultado"));
    }
    
    
    @After
    public void closeBrowser() {
        if (driver != null) {
            try {
                Thread.sleep(1000);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }
}
