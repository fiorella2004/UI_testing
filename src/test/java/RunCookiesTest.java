import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/cookies.feature", glue="steps")
public class RunCookiesTest extends AbstractTestNGCucumberTests {

}