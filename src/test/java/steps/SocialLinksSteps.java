package steps;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.WebDriverManager;

public class SocialLinksSteps {
    protected WebDriver driver = WebDriverManager.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @And("^the user clicks (.*) link$")
    public void theUserClicksSocialLink(String socialLink) {
        WebElement socialLinkElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '" + socialLink.toLowerCase() + "')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", socialLinkElement);
    }

    @Then("^a new page opens with url (.*)")
    public void aNewPageOpens(String url) {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle); 
                break;
            }
        }
        
        wait.until(ExpectedConditions.urlContains(url));
        assertTrue(driver.getCurrentUrl().contains(url));
    }
}
