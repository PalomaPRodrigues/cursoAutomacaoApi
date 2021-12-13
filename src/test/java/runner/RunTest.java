package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// classe que faz a automação rodar atrás do cucumber
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/report.html"},
        features = {"src/test/resources/Features/"},
        glue = {"steps"},
        tags = "@Gorest")
public class RunTest {
}
