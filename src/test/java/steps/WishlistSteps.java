package steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class WishlistSteps {
	protected WebDriver driver = WebDriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    @And("the user clicks product")
    public void theUserClicksProduct() {
    	WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-image-photo")));
		product.click();
    }
    
    @And("the user clicks icon heart")
    public void theUserClicksIconHeart() {
    	WebElement heartIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".towishlist")));
    	heartIcon.click();
    }
    
    @And("the website requires username and password")
    public void theWebsiteRequiresUsernameAndPassword() {
    	WebElement webTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.base")));
		String title = webTitle.getText();
		Assert.assertTrue(title.contains("Customer Login"));
    }
    
    @And("the user writes username and password")
    public void theUserWritesUsernameAndPassword() {
    	WebElement account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-dropdown-sinapsis")));
    	account.click();
    	WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='login[username]']")));
		email.sendKeys("1666868@uab.cat");
		WebElement password = driver.findElement((By.xpath("//input[@name='login[password]']"))); 
		password.sendKeys("pruebaTest24");
		WebElement loginButton = driver.findElement(By.id("send2")); 
		loginButton.click();
    }
    
    @Then("the website displays a message that the product has been added")
    public void theWebsiteDisplaysAMessageThatTheProductHasBeenAdded() {
    	WebElement succesMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-bind*='html: $parent.prepareMessageForHtml(message.text)']")));
    	String succesMessageText = succesMessage.getText();
		Assert.assertTrue(succesMessageText.contains("se ha agregado a su lista de deseos"));
    }
}
