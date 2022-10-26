package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\FeatureFiles", glue = {"stepdefinitions"},
monochrome = true , plugin = {"pretty","html:target/HtmlReports"},
dryRun = false)
public class RunnerClass {

}
