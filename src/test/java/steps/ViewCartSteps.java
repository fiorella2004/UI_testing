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

public class ViewCartSteps{
	
	protected WebDriver driver = WebDriverManager.getDriver();
    
    @And("the user clicks go to cart")
    public void theUserClicksGoToCart() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement goToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.action.viewcart")));
        goToCartButton.click();
    }
    
    @Then("the user can see the cart page")
    public void theUserCanSeeTheCartPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-title")));
        String title = page.getText();
        Assert.assertTrue(title.contains("Cesta"));
    }
    
    @And("the user can see the book in the cart page")
    public void theUserCanSeeTheBookInTheCartPage() {
        WebElement product = driver.findElement(By.cssSelector("strong.product-item-name"));
        String bookTitle = product.getText();
        Assert.assertNotNull(bookTitle);
    }
    
    @When("the user increases the number of the products")
    public void theUserIncreasesTheNumberOfTheProducts() {
    	WebElement increaseButton = driver.findElement(By.cssSelector(".increaseqty-sticky.qty-btn"));
    	increaseButton.click();
    }
    
    @Then("the cart shows two products")
    public void theCartShowsTwoProducts() {
    	WebElement quantity = driver.findElement(By.cssSelector("input.input-text.qty"));
        String value = quantity.getAttribute("value");
        Assert.assertEquals(value, "2");
    }
    
    @When("the user decreases the number of the products")
    public void theUserDecreasesTheNumberOfTheProducts() {
    	WebElement increaseButton = driver.findElement(By.cssSelector(".decreaseqty-sticky.qty-btn"));
    	increaseButton.click();
    }
    
    @Then("the cart shows one product")
    public void theCartShowsOneProduct() {
    	WebElement quantity = driver.findElement(By.cssSelector("input.input-text.qty"));
        String value = quantity.getAttribute("value");
        Assert.assertEquals(value, "1");
    }
    
    @When("the user clicks the delete button")
    public void theUserClicksTheDeleteButton() {
    	WebElement deleteButton = driver.findElement(By.cssSelector(".action.action-delete"));
    	deleteButton.click();
    }
    
    @And("the user clicks the accept button")
    public void theUserClicksTheAcceptButton() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.action-primary.action-accept")));
    	acceptButton.click();
    }
    
    @Then("the cart shows zero products")
    public void theCartShowsZeroProducts() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.cart-empty > p")));
        String text = page.getText();
        Assert.assertEquals(text, "No tienes ningún artículo en tu carrito.");
    }
}
