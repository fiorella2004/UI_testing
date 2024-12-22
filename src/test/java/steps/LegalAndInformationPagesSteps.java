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

public class LegalAndInformationPagesSteps {
	
	protected WebDriver driver = WebDriverManager.getDriver();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	
	@And("^the user clicks on (.*) page")
    public void theUserSelectsComicsFilter(String namePage) { 
    	WebElement linkPage = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(namePage)));
        linkPage.click();
    }
	
	@Then("^the page should open with the (.*)")
	public void thePageShouldOpenWithTheTitle(String expectedTitle)
	{
		WebElement webTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
		String title = webTitle.getText();
		Assert.assertTrue(title.contains(expectedTitle));
	}
}
