package steps;

import api.ApiUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScenarioUtils;

import java.util.HashMap;

// Classe que faz a inicialização e Finalização dos testes automatizados
public class Hooks extends ApiUtils {

    @Before
    public void Before(Scenario scenario) {
        ScenarioUtils.add(scenario);
        headers = new HashMap<>();
        params = new HashMap<>();
    }

    @After
    public void after() {
        ScenarioUtils.remove();
    }
}
