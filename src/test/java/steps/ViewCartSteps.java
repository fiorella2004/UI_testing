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
}
