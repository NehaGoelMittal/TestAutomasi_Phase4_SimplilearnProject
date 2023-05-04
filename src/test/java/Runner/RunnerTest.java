package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"html:target/cucumber/index.html","json:target/cucumber.json"},
		features="src/test/java/features",
		glue={"stepDefs"}
		)	
public class RunnerTest {


}
