package acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty",  "html:target/test-report",
        "json:target/test-report/nonMerci.json",
        "junit:target/test-report/nonMerci.xml",
},
        features = "src/test/resources")
public class RunCucumberTest {
}
