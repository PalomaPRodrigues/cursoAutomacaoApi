package utils;

import io.cucumber.java.Scenario;

public class LogUtils {

    public void logInfo(String value){
    if(!value.contains("{}")){
        ScenarioUtils.addText(value);
    }
    }

}
