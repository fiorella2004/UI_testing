import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/modifyAccount.feature", glue="steps")
public class RunModifyAccountTest extends AbstractTestNGCucumberTests {

}