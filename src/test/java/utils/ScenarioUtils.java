package utils;

import io.cucumber.java.Scenario;

import java.util.HashMap;
import java.util.Map;

public class ScenarioUtils {
// responsável para controlar os scenarios
    private static Map<Long, Scenario> repository = new HashMap<>();
//adiociona scenario
    public static void add(Scenario scenario) {
        if (get() == null)
            repository.put(getId(), scenario);
    }
// remove scenario
    public static void remove() {
        if (get() != null)
            repository.remove(getId());
    }

    public static Scenario get() {
        return repository.get(getId());
    }

    public static Long getId() {return Thread.currentThread().getId();}
//adiciona e recebe texto
    public static void addText(String texto) {get().log(texto);}
}
