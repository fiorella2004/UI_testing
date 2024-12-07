import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/productSearch.feature", glue="steps")
public class RunProductSearchTest extends AbstractTestNGCucumberTests{

}
