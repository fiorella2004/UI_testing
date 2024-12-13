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

public class ViewCartSteps {
	
    private WebDriver driver;

    @Given("the user opens the homepage")
    public void theUserOpensTheHomepage() {
    	System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
    	driver = new FirefoxDriver();
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
    
    @Then("the cart widget shows zero products")
    public void theCartWidgetShowsZeroProducts() {
        WebElement cartWidget = driver.findElement(By.cssSelector(".counter-number")); 
        String count = cartWidget.getText().trim();
        Assert.assertEquals("0", count);
    }
    
    @When("the user clicks add to cart the book KIDNAPPERS")
    public void theUserClicksAddToCartTheBookKIDNAPPERS() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bookKIDNAPPERS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-item-details")));
        WebElement bookExists = bookKIDNAPPERS.findElement(By.cssSelector("a[title='KIDNAPPERS']"));
        Assert.assertNotNull(bookExists);
        WebElement addToCartButton = bookKIDNAPPERS.findElement(By.cssSelector("button.action.tocart.primary"));
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
        Assert.assertTrue(bookTitle.contains("KIDNAPPERS"));
    }
    
    @When("the user increases the product by one")
    public void theUserIncreasesTheProductByOne() {
        WebElement increaseButton = driver.findElement(By.cssSelector(".increaseqty-sticky qty-btn"));
        increaseButton.click();
    }
    
    @Then("the cart shows two items of that product")
    public void theCartShowsTwoItemsOfThatProduct() {
    	WebElement quantity = driver.findElement(By.id("cart-2168574-qty"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(quantity));
        String count = quantity.getAttribute("value");
        Assert.assertEquals("2", count);
    }
}
