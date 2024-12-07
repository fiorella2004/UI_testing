package steps;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("CybotCookiebotDialog")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isVisible = (Boolean) js.executeScript("return document.getElementById('CybotCookiebotDialog')"
        		+ "!== null && window.getComputedStyle(document.getElementById('CybotCookiebotDialog')).display !== 'none';");
        Assert.assertFalse(isVisible);
    }
    
    @Then("The cookie widget appears")
    public void theCookieWidgetAppears() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    WebElement cookieWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CookiebotWidget")));
	    Assert.assertTrue(cookieWidget.isDisplayed());
    }
}