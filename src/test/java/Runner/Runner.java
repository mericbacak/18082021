package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = {"Steps"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit-target/cucumber-reports/Cucumber.json",
                "html-target/cucumber-reports"}, monochrome = true)
//tags = {"@register"}
public class Runner {
}

