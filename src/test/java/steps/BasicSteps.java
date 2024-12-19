package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.After;
import utils.WebDriverManager;

public class BasicSteps {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();  // Utilizamos WebDriverManager en lugar de crear un nuevo FirefoxDriver
    }

    @After
    public void tearDown() {
        WebDriverManager.quitDriver();  // Cerramos el navegador usando el método de WebDriverManager
    }

    @Given("the user opens the index page")
    public void theUserOpensTheIndexPage() {
        driver.navigate().to("https://www.normacomics.com");
    }

    @When("the user clicks accept all cookies")
    public void theUserClicksAcceptAllCookies() {
        WebElement acceptButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        acceptButton.click();
    }
}
