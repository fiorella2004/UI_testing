package steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProductToCartSteps {
	
	private WebDriver driver;
	
	@Given("The user opens the homepage")
	public void theUserOpensTheHomepage() {
    	System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
    	driver = new FirefoxDriver();
    	driver.navigate().to("https://www.normacomics.com");
    }
    
    @Given("The cookie banner is displayed")
    public void theCookieBannerIsDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement cookieDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialog")));
    	Assert.assertTrue(cookieDialog.isDisplayed());
    }
    
    @When("The user clicks accept all cookies")
    public void theUserClicksAcceptAllCookies() {
        WebElement acceptButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")); 
        acceptButton.click();
    }
    
    @Then("The cart widget shows zero products")
    public void theCartWidgetShowsZeroProducts() {
        WebElement cartWidget = driver.findElement(By.cssSelector(".counter-number")); 
        String count = cartWidget.getText().trim();
        Assert.assertEquals("0", count);
    }
    
    @When("The user clicks add to cart the book KIDNAPPERS")
    public void theUserClicksAddToCartTheBookKIDNAPPERS() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bookKIDNAPPERS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-item-details")));
        WebElement bookExists = bookKIDNAPPERS.findElement(By.cssSelector("a[title='KIDNAPPERS']"));
        Assert.assertNotNull(bookExists);
        WebElement addToCartButton = bookKIDNAPPERS.findElement(By.cssSelector("button.action.tocart.primary"));
        addToCartButton.click();
    }
    
    @Then("The cart widget shows one product")
    public void theCartWidgetShowsOneProduct() {
        WebElement cartWidget = driver.findElement(By.cssSelector(".counter-number"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(cartWidget, "1"));
        String count = cartWidget.getText().trim();
        Assert.assertEquals("1", count);
    }
}