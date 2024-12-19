package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public abstract class BasicSteps {

	protected WebDriver driver; 
	
    @Given("the user opens the index page")
    public void theUserOpensTheIndexPage() {
    	System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
    	driver = new FirefoxDriver();
    	driver.navigate().to("https://www.normacomics.com");
    }

    @When("the user clicks accept all cookies")
    public void theUserClicksAcceptAllCookies() {
        WebElement acceptButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")); 
        acceptButton.click();
    }
}