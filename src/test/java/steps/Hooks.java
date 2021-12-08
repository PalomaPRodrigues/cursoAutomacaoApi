package steps;

import api.ApiUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScenarioUtils;

import java.util.HashMap;

public class Hooks extends ApiUtils {

    @Before
    public void Before(Scenario scenario){
        ScenarioUtils.add(scenario);
        hearders = new HashMap<>();
        params = new HashMap<>();
    }

    @After
    public  void after(){
        ScenarioUtils.remove();
    }
}
