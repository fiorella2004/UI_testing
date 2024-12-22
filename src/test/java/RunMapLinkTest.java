import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/mapLink.feature", glue="steps")
public class RunMapLinkTest extends AbstractTestNGCucumberTests{

}
