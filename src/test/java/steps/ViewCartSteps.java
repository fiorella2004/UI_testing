package steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.WebDriverManager;

public class ViewCartSteps{
	

	protected WebDriver driver = WebDriverManager.getDriver();
    
    @And("the user clicks add to cart one book")
    public void theUserClicksAddToCartOneBook() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement book = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-item-details")));
        WebElement addToCartButton = book.findElement(By.cssSelector("button.action.tocart.primary"));
        addToCartButton.click();
    }
    
    @Then("the cart widget shows one product")
    public void theCartWidgetShowsOneProduct() {
        WebElement cartWidget = driver.findElement(By.cssSelector(".counter-number"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(cartWidget, "1"));
        String count = cartWidget.getText().trim();
        Assert.assertEquals("1", count);
    }
    
    @When("the user clicks the cart widget")
    public void theUserClicksTheCartWidget() {
        WebElement cartWidget = driver.findElement(By.cssSelector(".minicart-wrapper .action.showcart"));
        cartWidget.click();
    }
    
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
