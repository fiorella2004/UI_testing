import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/SocialLinks.feature", glue="steps")
public class RunSocialLinksTest extends AbstractTestNGCucumberTests{

}
