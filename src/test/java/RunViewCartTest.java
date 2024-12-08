import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/viewCart.feature", glue="steps")
public class RunViewCartTest extends AbstractTestNGCucumberTests {

}