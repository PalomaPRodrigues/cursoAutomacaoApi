package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.IOException;

// serve para iniciar o scenario e gerar o relatório
// classe que faz a automação rodar atrás do cucumber
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/report.html","json:target/report/cucumber.json"},
        features = {"src/test/resources/Features/"},
        glue = {"steps"}, // no glue coloca o nome do pacote que está o hooks
        tags = "@regressivo")

public class RunTest {
    // executada no final da execução dos testes
    @AfterClass
    public static void report() throws IOException {
            Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
    }

}
