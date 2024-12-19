package steps;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CookiesSteps extends BasicSteps {
    
    @And("the cookie banner is displayed")
    public void theCookieBannerIsDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement cookieDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialog")));
    	Assert.assertTrue(cookieDialog.isDisplayed());
    }
	
    @When("the user clicks reject all cookies")
    public void theUserClicksRejectAllCookies() {
        WebElement rejectButton = driver.findElement(By.id("CybotCookiebotDialogBodyButtonDecline")); 
        rejectButton.click();
    }

    @Then("the cookie banner disappears")
    public void theCookieBannerDisappears() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("CybotCookiebotDialog")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isVisible = (Boolean) js.executeScript("return document.getElementById('CybotCookiebotDialog')"
        		+ "!== null && window.getComputedStyle(document.getElementById('CybotCookiebotDialog')).display !== 'none';");
        Assert.assertFalse(isVisible);
    }
    
    @Then("the cookie widget appears")
    public void theCookieWidgetAppears() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement cookieWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CookiebotWidget")));
    	Assert.assertTrue(cookieWidget.isDisplayed());
    }
}