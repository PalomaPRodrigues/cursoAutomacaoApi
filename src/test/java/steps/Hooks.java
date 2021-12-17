package steps;

import api.ApiUtils;
import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScenarioUtils;

// Classe que faz a inicialização e Finalização dos testes automatizados
public class Hooks extends ApiUtils {
    // adiciona o scenario no inicio da automação
    @Before
    public void Before(Scenario scenario) {
        ScenarioUtils.add(scenario);

    }
  // remove scneario no fim da automação
    @After //depois de finalizar a automação
    public void after() {
        ScenarioUtils.remove();
    }
}
