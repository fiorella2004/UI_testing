package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import utils.WebDriverManager;

public class AddProductToCartSteps {

	protected WebDriver driver = WebDriverManager.getDriver();
	
    @Then("the cart widget shows the product added")
    public void theCartWidgetShowsTheProductAdded() {
        WebElement bookTitle = driver.findElement(By.cssSelector("strong.product-item-name > a"));
        String exists = bookTitle.getText().trim();
        Assert.assertNotNull(exists);
    }
}