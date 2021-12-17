package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
// serve para iniciar o scenario e gerar o relatório
// classe que faz a automação rodar atrás do cucumber
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/report.html"},
        features = {"src/test/resources/Features/"},
        glue = {"steps"}, // no glue coloca o nome do pacote que está o hooks
        tags = "@delete")
public class RunTest {
}
