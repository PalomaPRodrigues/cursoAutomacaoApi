package utils;

import io.cucumber.java.Scenario;

public class LogUtils {
// printa as informações no console  ou erro no report
    public void logInfo(String value) {
        if (!value.contains("{}")) {
            ScenarioUtils.addText(value);
        }
    }

    public void logError(String value){
        if(!value.contains("{}")){
            ScenarioUtils.addText(value);
        }
    }

}
