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
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CookiesSteps {
    
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
	    WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialog")));
	    Assert.assertTrue(cookieBanner.isDisplayed());
    }

    @When("The user clicks accept all cookies")
    public void theUserClicksAcceptAllCookies() {
        WebElement acceptButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")); 
        acceptButton.click();
    }
    
    @When("The user clicks reject all cookies")
    public void theUserClicksRejectAllCookies() {
        WebElement rejectButton = driver.findElement(By.id("CybotCookiebotDialogBodyButtonDecline")); 
        rejectButton.click();
    }

    @Then("The cookie banner disappears")
    public void theCookieBannerDisappears() {
        boolean isBannerVisible = driver.findElements(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).size() > 0;
        Assert.assertFalse(isBannerVisible);
    }

    @Then("All cookies are enabled")
    public void allCookiesAreEnabled() {
        String cookieValue = driver.manage().getCookieNamed("cookiePreference").getValue();
        Assert.assertEquals("all", cookieValue);  
    }
    
    @Then("Only essential cookies are enabled")
    public void onlyEssentialCookiesAreEnabled() {
        String cookieValue = driver.manage().getCookieNamed("cookiePreference").getValue();
        Assert.assertEquals("essential", cookieValue); 
    }
}