import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/recoverPassword.feature", glue="steps")
public class RunRecoverPasswordTest extends AbstractTestNGCucumberTests{

}