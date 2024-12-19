import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/FilteredSearch.feature", glue="steps")
public class RunFilteredSearchTest extends AbstractTestNGCucumberTests{

}
