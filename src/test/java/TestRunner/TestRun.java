package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
		(
				features=".//Features/",
				glue="stepDefinitions",
				dryRun=false,
				monochrome=true,
				plugin= {"html:target/HTMLReports/Report3.html"},
				tags= "@regression"
		)
public class TestRun {

}
