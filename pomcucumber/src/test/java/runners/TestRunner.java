package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		monochrome= true,
		dryRun=false,
		features= {"src\\test\\java\\feature"},
		glue= {"package1"},
		plugin= {"pretty", 
				"html:target/cucumber-html/cucumber.html",
				"json:target/cucumber-reports/CucumberTestReport.json"
				}

				)
public class TestRunner {

}
