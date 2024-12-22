import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/legalAndInformationPages.feature", glue="steps")
public class RunLegalAndInformationPagesTest extends AbstractTestNGCucumberTests{

}
