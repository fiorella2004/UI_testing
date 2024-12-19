package steps;

import java.time.Duration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.WebDriverManager;

public class BasicSteps {

    protected WebDriver driver;

    @Before
    public void setDriver() {
        driver = WebDriverManager.getDriver();  
    }
    
    //@After
    //public void closeDriver() {
    //    WebDriverManager.quitDriver();  
    //}

    @Given("the user opens the index page")
    public void theUserOpensTheIndexPage() {
        driver.navigate().to("https://www.normacomics.com");
    }
    
    @And("the cookie banner is displayed")
    public void theCookieBannerIsDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement cookieDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialog")));
    	Assert.assertTrue(cookieDialog.isDisplayed());
    }

    @When("the user clicks accept all cookies")
    public void theUserClicksAcceptAllCookies() {
        WebElement acceptButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        acceptButton.click();
    }
    
    @When("the user clicks add to cart one book")
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
    
	@And("the user clicks the user button")
	public void theUserClicksTheUserButton() {
        WebElement userButton = driver.findElement(By.id("account-dropdown-sinapsis"));
        userButton.click();
	}
	
	@Then("the user button is displayed")
	public void theUserButtonIsDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement userButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
    	Assert.assertTrue(userButton.isDisplayed());
	}
}