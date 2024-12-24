package steps;

import static org.testng.Assert.assertTrue;
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

public class MapLinkSteps {
    
    protected WebDriver driver = WebDriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  

    @And("the user clicks quienes somos")
    public void theUserClicksQuienesSomos() { 
    	WebElement linkPage = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Quiénes somos")));
        linkPage.click();
    }
    
    @Then("the page quienes somos opens")
	public void thePageQuienesSomosOpens()
	{
		WebElement webTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		String title = webTitle.getText();
		Assert.assertTrue(title.contains("Quiénes somos"));
	}
    
    @And("the user clicks googleMaps")
    public void theUserClicksGoogleMaps() {
        WebElement googleMapsLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='https://goo.gl/maps/i9VBSGfiSjYYckZt8']")));
        googleMapsLink.click();
    }

    @Then("google maps page opens")
    public void googleMapsPageOpens() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);  
                break;
            }
        }
        assertTrue(wait.until(ExpectedConditions.urlContains("google.com/maps")));
    }
}