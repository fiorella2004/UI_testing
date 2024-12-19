import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/productDetail.feature", glue="steps")
public class RunProductDetailTest extends AbstractTestNGCucumberTests{

}