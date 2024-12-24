import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Wishlist.feature", glue="steps")
public class RunWishlistTest extends AbstractTestNGCucumberTests{

}
